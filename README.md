## Инструкция по запуску

# Необходимо
- Java 17 (https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html)
- Gradle 8 (https://services.gradle.org/distributions/gradle-8.0-bin.zip)

## Установка и запуск

Клонируем
```bash
git clone https://github.com/raukaztaev/shift_test
cd shift_test
```

Сборка(Windows)
```bash
gradlew build
```

Сборка(Linux, macOS)
```bash
./gradlew build
```

Пример запуска
```bash
java -jar build/libs/shift_test-1.0-SNAPSHOT.jar -f <your_file.txt>
```
