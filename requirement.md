Credit Card Processing

Write a small full stack application for a credit card provider. It should allow you to add new credit card accounts and view them as a list. The backend must be a RESTful API.

Requirements

Two REST Endpoints must be implemented
- "Add" will create a new credit card for a given name, card number, and limit
- Card numbers should be validated using Luhn 10
- New cards start with a £0 balance
- for cards not compatible with Luhn 10, return an error
- "Get all" returns all cards in the system

The endpoints should be given appropriate URLs and HTTP methods, according to RESTful design principles. There is no right and wrong answer here, but you may be asked to explain and justify your design, so give it some thought.

Validation

- all input and output will be JSON
- credit card numbers may vary in length, up to 19 characters
- credit card numbers will always be numeric

User Interface

- Build a UI according to the provided wireframe
- You can design it how you wish, and use a design system if you want (like bootstrap)
- The UI should utilise the RESTful services you have built
- Show error message on the form for unsuccessful validation (whether you show this at field level, or a summary, or both, is up to you)
- The UI can be in whatever technology you prefer - React, Angular, and it’s fine to use a boilerplate as a starting point

Technical requirements

- Create the RESTful API using Spring Boot and Use Maven/Gradle for dependency management
- Create the endpoints use appropriate HTTP Methods and define the payloads, return codes and response structures
- Factor in all the input validation
- Write unit test cases. (note: this is not a production grade application. It is a way of showing us your skills, so you don’t have to test to the n-th degree. If you prefer you can write some key unit tests, and then add a comment to explain the other edge cases you would test in the real world)
- Use an in-memory DB to store the information while the API is running, so that it can store the credit card information
- Send steps for how to run and test the API, and the front-end
- Hand code the Luhn 10 check, don’t use a library

---

### Guides
The following guides illustrates how to use certain features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validating Form Input](https://spring.io/guides/gs/validating-form-input/)


1. Write frontend unit test cases. (note: this is not a production grade application. It is a way of showing us your skills, so you don’t have to test to the n-th degree. If you prefer you can write some key unit tests, and then add a comment to explain the other edge cases you would test in the real world)
3. Send steps for how to run and test the API, and the front-end

---
3. page design