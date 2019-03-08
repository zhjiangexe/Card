# Credit Card Processing

## Development Environment

- JDK8
- Node v8.11.4
- Gradle Wrapper 5.2.1

1. Download `git clone https://github.com/zhjiangexe/Card.git`

2. Go to Card folder `cd Card`

3. Execute `npm install`

# DEVELOPMENT

1. Execute `npm start` to run the webpack-dev-server localhost:9060
2. Exectue `gradlew` or `./gradlew` to *bootRun* api server localhost:8080
3. open `http://localhost:9000` in browser and use it

## RUN BOOT JAR

1. Execute `gradlew bootJar`
2. cd `build/libs`
3. Execute `java -jar card-0.0.1.jar`
4. open `http://localhost:8080/index.html` in browser

# Test

1. FrontEnd: `npm test`
2. BackEnd: `gradlew test` or `./gradlew test`

---
## folder

- src/main/java/**
- src/main/resources/**
- src/main/webapp/**
- src/main/webapp/app/**

## test folder
- src/test/java/**
- src/test/javascript/spec/app/**

---
## BackEnd

### Save Card

input `com.jiang.app.vo.CardForm` to `com.jiang.app.web.controller.CreditCardController`

basic field validate by `@Valid` and handle validate error response by `com.jiang.app.web.advice.GlobalAdvice`

then go through `com.jiang.app.service.CreditCardService`

if this card number luhn validate is fail throw `ServiceException` and handle exception by `com.jiang.app.web.advice.CustomAdvice`

in the end, save this information by `com.jiang.app.domain.repository.CreditCardRepository`

---
## FrontEnd

### SAVE AND LIST CARD PAGES

- src/main/webapp/app/pages/card
    - index.tsx
    - add.tsx
    - list.tsx
    - service.ts 
