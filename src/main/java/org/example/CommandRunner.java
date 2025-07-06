package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandRunner {
    public static void main(String[] args) {
        try {
            // Создаем процесс с правильными аргументами
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "dbus-monitor",
                    "interface='org.freedesktop.Notifications',member='Notify'"
            );

            // Объединяем стандартный вывод и ошибки
            processBuilder.redirectErrorStream(true);

            // Запускаем процесс
            Process process = processBuilder.start();
            StringBuilder code = new StringBuilder();
            Pattern pattern = Pattern.compile("Ваш код подтверждения:\\s*(\\d+)");

            // Поток для чтения вывода в реальном времени
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream())
                )) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains("string \"Ваш код подтверждения: ")) {
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                code.append(matcher.group(1)); // Извлекаем цифры из первой группы
                                System.out.println("Код: " + code); // Вывод: Код: 123456
                                process.destroy();
                            }
                            System.out.println("[DBUS] " + line); // Обработка каждой строки

                        }
                    }
                } catch (Exception e) {

                }
            }).start();

            // Ожидаем завершения с таймаутом (для длительных процессов)
            process.waitFor(30, TimeUnit.MINUTES);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}