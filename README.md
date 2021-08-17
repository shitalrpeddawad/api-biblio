# Système d'information de la bibliothèque - P7
Gestion des bibliothèques d'une grande ville

**Prérequis**
--------------
Apache Maven 3.6.3

PostgreSQL 12

**Déploiement**
---------------
Cloner les 3 projets sous GitHub

Importer les projets dans l'IDE ( projet développé avec IntelliJ)

Compiler via maven avec la commande mvn clean compile

Le fichier war est généré dans le repertoire target

Créer une base de données nommée library sous postgreSQL

Utiliser le script du dump pour créer les tables puis le script du jeu de données pour remplir les tables de la BDD

Soit demarrer le serveur tomcat sur l'IDE pour les 3 projets, soit copier les fichiers war de l'application depuis le dossier target dans le dossier webapps du répertoire Tomcat, puis lancer le serveur Tomcat

Puis se rendre via le navigateur sur l'adresse http://localhost:portduserveur/lade-webapp/Accueil

L'application est prète à fonctionner avec 3 utilisateurs :

admin mot de passe admin pour le rôle de membre de l'association

Mika mot de passe 123 pour le rôle d'utilisateur connecté

lolo-13 mot de passe 123 pour le rôle d'utilisateur connecté
