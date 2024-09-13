# Forum API

Cette API REST permet de gérer un forum avec des entités telles que **Forum**, **Sujet**, et **Message**. Elle permet de créer des forums, de gérer les sujets dans chaque forum, et de poster des messages dans les sujets. L'API est construite avec **Spring Boot 3.3.3**, utilise **PostgreSQL** pour la persistance des données, et suit une architecture RESTful.

## Prérequis

Avant de lancer ce projet, vous devez avoir installé les éléments suivants :

- **Java 17**
- **Maven** (version 3.8 ou supérieure)
- **PostgreSQL** (version 12 ou supérieure)

## Configuration de la base de données

1. Installez PostgreSQL et créez une base de données.
2. Configurez un utilisateur et un mot de passe pour la base de données.
3. Configurez votre port
4. Mettez à jour le fichier `application.properties` avec les informations de connexion à votre base de données :

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:votre_port/nom_db
   spring.datasource.username=votre_nom_utilisateur
   spring.datasource.password=votre_mot_de_passe
   spring.jpa.hibernate.ddl-auto=create(au premier demmarage), update(apres le premier demmarage)
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
