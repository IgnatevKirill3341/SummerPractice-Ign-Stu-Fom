package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetNoty {
    /**
     * Получает код из системных уведомлений путем мониторинга DBus событий.
     * Запускает процесс dbus-monitor, анализирует вывод в реальном времени,
     * извлекает цифровой код по шаблону и возвращает его.
     *
     * @return StringBuilder содержащий найденный код (пустой, если код не обнаружен)
     */
    public static StringBuilder getNoty() {
        StringBuilder code = new StringBuilder();
        try {
            Process process = startDbusMonitorProcess();
            startOutputProcessingThread(process, code);
            waitForProcessTermination(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }
    /**
     * Создает и запускает процесс dbus-monitor для отслеживания уведомлений.
     *
     * @return Запущенный процесс
     * @throws IOException Если произошла ошибка ввода/вывода при запуске процесса
     */
    private static Process startDbusMonitorProcess() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "dbus-monitor",
                "interface='org.freedesktop.Notifications',member='Notify'"
        );
        processBuilder.redirectErrorStream(true);
        return processBuilder.start();
    }
    /**
     * Запускает поток для обработки вывода процесса в реальном времени.
     *
     * @param process Процесс, вывод которого нужно обрабатывать
     * @param code StringBuilder для сохранения найденного кода
     */
    private static void startOutputProcessingThread(Process process, StringBuilder code) {
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                processOutputLines(reader, process, code);
            } catch (Exception e) {

            }
        }).start();
    }
    /**
     * Обрабатывает поток вывода построчно, фильтруя и анализируя строки.
     *
     * @param reader Буферизированный читатель потока вывода процесса
     * @param process Обрабатываемый процесс
     * @param code StringBuilder для сохранения найденного кода
     * @throws IOException Если произошла ошибка чтения потока
     */
    private static void processOutputLines(BufferedReader reader,
                                           Process process,
                                           StringBuilder code) throws IOException {
        Pattern pattern = Pattern.compile("\\s*(\\d+) — никому его не говорите");
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("string \"")) {
                checkForCodeMatch(line, pattern, process, code);
            }
        }
    }
    /**
     * Проверяет строку на соответствие шаблону и извлекает код при совпадении.
     * При обнаружении кода сохраняет его, выводит строку и завершает процесс.
     *
     * @param line Анализируемая строка вывода
     * @param pattern Скомпилированное регулярное выражение для поиска кода
     * @param process Процесс, который будет завершен при обнаружении кода
     * @param code StringBuilder для сохранения найденного кода
     */
    private static void checkForCodeMatch(String line,
                                          Pattern pattern,
                                          Process process,
                                          StringBuilder code) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            code.append(matcher.group(1));
            System.out.println(line);
            process.destroy();
        }
    }
    /**
     * Ожидает завершения процесса с ограничением по времени.
     *
     * @param process Процесс, завершения которого ожидаем
     * @throws InterruptedException Если поток был прерван во время ожидания
     */
    private static void waitForProcessTermination(Process process) throws InterruptedException {
        process.waitFor(1, TimeUnit.MINUTES);
    }
}
