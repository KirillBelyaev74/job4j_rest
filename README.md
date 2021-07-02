[![Build Status](https://travis-ci.com/KirillBelyaev74/job4j_rest.svg?branch=master)](https://travis-ci.com/KirillBelyaev74/job4j_rest)
[![codecov](https://codecov.io/gh/KirillBelyaev74/job4j_rest/branch/master/graph/badge.svg?token=iSnrWNyNZO)](https://codecov.io/gh/KirillBelyaev74/job4j_rest)


## Проект курса [job4j](http://job4j.ru)

### Rest

Приложение риализует создание/редактирование/удаление модели Person.

Технологии:
- PostgresSQL
- CRUDRepository
- Spring Boot / Security / Data / Rest
- Log4j
- JUnit / Mockito
- MVC / Singleton (On Demand Holder Idom)

Добавление пользователя http://localhost:8080/person/
![screenshot of sample](screenshot/1.png)

Изменение пользователя по ID http://localhost:8080/person/
![screenshot of sample](screenshot/2.png)

Получение всех пользователей http://localhost:8080/person/
![screenshot of sample](screenshot/3.png)

Получение пользователя по ID http://localhost:8080/person/{id}
![screenshot of sample](screenshot/4.png)

Удаление пользователя по ID http://localhost:8080/person/{id}
![screenshot of sample](screenshot/5.png)

Через Rest можно добиться такого результата добавления пользователя http://localhost:8080/employee/
![screenshot of sample](screenshot/6.png)

Изменения пользователя по ID http://localhost:8080/employee/
![screenshot of sample](screenshot/7.png)

Получение всех работников http://localhost:8080/employee/
![screenshot of sample](screenshot/8.png)

Получения пользователя по ID http://localhost:8080/employee/{id}
![screenshot of sample](screenshot/9.png)

Удаление пользователя по ID http://localhost:8080/employee/{id}
![screenshot of sample](screenshot/10.png)