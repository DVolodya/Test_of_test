# Report Portal UI Automation Tests

Этот проект содержит автоматизированные UI тесты для демо-версии Report Portal с использованием Selenium WebDriver, JUnit 5 и Allure Reports.

## Структура проекта
report-portal-tests/
├── src/test/java/com/reportportal/
│ ├── pages/ # Page Object Model классы
│ ├── tests/ # Тестовые классы
│ ├── utils/ # Вспомогательные утилиты
│ └── config/ # Конфигурация тестов
├── pom.xml # Maven конфигурация
└── README.md # Документация


## Технологии

- **Java 11**
- **Selenium WebDriver 4.15.0**
- **JUnit 5**
- **Allure Reports 2.24.0**
- **Maven**
- **Page Object Model**

## Предварительные требования

1. Java 11 или выше
2. Maven 3.6 или выше
3. Браузер Chrome или Firefox

## Установка и запуск

1. Клонируйте репозиторий:
``` bash
git clone https://github.com/your-username/report-portal-tests.git
cd report-portal-tests

2. Соберите проект:
``` bash
mvn clean compile

3. Запустите все тесты
``` bash
mvn test

4.Запуск конкретного тестового класса:
``` bash
mvn test -Dtest=LoginPositiveTest

5. Запуск тестов с определенным браузером (по умолчанию Chrome):
java
// Измените в BaseTest.java
TestConfig.initializeDriver(TestConfig.Browser.FIREFOX);

## Генерация отчетов Allure
1. Запустите тесты с генерацией Allure результатов:

``` bash
mvn test

2. Сгенерируйте и откройте отчет:

``` bash
mvn allure:serve

3. Для генерации статического отчета:

``` bash
mvn allure:report


## Инструкции по настройке Git

### Создание репозитория и веток:

```bash```
# Инициализация Git
git init

# Создание основной ветки
git checkout -b master

# Добавление файлов
git add .

# Первый коммит
git commit -m "Initial commit: Report Portal UI automation tests"

# Создание ветки dev
git checkout -b dev

# Настройка удаленного репозитория
git remote add origin https://github.com/your-username/report-portal-tests.git

# Push веток
git push -u origin master
git push -u origin dev
