Configuration de la base de données PostgreSQL
Dans le fichier application.properties ou application.yml :

Copier et coller le code suivant :

spring.datasource.url=jdbc:postgresql://localhost:5432/forum_db
spring.datasource.username=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


# Forum API

Cette API permet de gérer un forum avec des forums, des sujets, et des messages.

## Prérequis

- Java 17
- Maven
- PostgreSQL

## Installation

1. Clonez le projet :

   ```bash
   git clone https://github.com/nehemie001/forum-api.git