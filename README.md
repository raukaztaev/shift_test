Инструкция по запуску

# Необходимо
- Java 17 (https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html)
- Gradle 8 (https://services.gradle.org/distributions/gradle-8.0-bin.zip)

# Установка и запуск

```bash
git clone https://github.com/raukaztaev/shift_test
cd shift_test

#Сборка
./gradle build

#Пример запуска
java -jar build/libs/shift_test-1.0-SNAPSHOT.jar -f <your_file.txt>
