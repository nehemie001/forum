# Forum APIs

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

## Installation

Suivez les étapes ci-dessous pour installer et exécuter l'API :

1. Clonez le dépôt Git dans votre répertoire local :

    ```properties
    git clone https://github.com/nehemie001/forum.git

2. Accédez au répertoire du projet :

     ```properties
    cd forum

3. Compilez le projet avec Maven :

    ```properties
    mvn clean install

4. Démarrez l'application avec Maven :

   ```properties
    mvn spring-boot:run

5. L'application sera disponible sur http://localhost:votre_port

## Endpoints des APIs

Gestion des Forums

  - Créer un forum
      - Méthode : `POST`
      - URL : `/api/forums`
      - Body :
   
    ```properties
    {
    "title": "Nom du forum",
    "description": "Description du forum"
    }

 - Liste des forums
      - Méthode : `GET`
      - URL : `/api/forums`

- Details d'un forum
      - Méthode : `GET`
      - URL : `/api/forums/{id}`

Gestion des Sujets

  - Créer un sujet dans un forum
      - Méthode : `POST`
      - URL : `/api/sujets`
      - Body :
   
    ```properties
    {
    "title":"nom du sujet",
    "description":"description du sujet"
    }

 - Liste des sujets
      - Méthode : `GET`
      - URL : `/api/sujets`

- Details d'un sujet
      - Méthode : `GET`
      - URL : `/api/sujets/{id}`

Gestion des Messages

  - Créer un message dans un sujet
      - Méthode : `POST`
      - URL : `/api/messages`
      - Body :
   
    ```properties
    {
    "content":"contenu du message",
    "sujet_id":id du sujet
    }

 - Liste des messages
      - Méthode : `GET`
      - URL : `/api/sujets`
        
## Documentation des APIs

La documentation complète de l'API est disponible via un fichier Postman que vous pouvez importer dans votre environnement Postman. Téléchargez le fichier ici.

## Contributions
Les contributions sont les bienvenues. Veuillez ouvrir une "issue" pour discuter des changements majeurs avant de soumettre une pull request.
