Gestion des Transports Universitaires
🚍 UniTransport – Une plateforme pour la gestion des bus et des abonnements étudiants

📁 Table des matières
🗂 Contexte
❓ Problématique
🎯 Objectif
📊 Diagrammes
🗃 Tables de Données
✨ Fonctionnalités principales
🔍 Requêtes SQL
🏛 Architecture
🛠 Technologies Utilisées
🎥 Démo Vidéo
📁 .exe

🗂 Contexte
Dans un cadre universitaire, la gestion du transport des étudiants est un enjeu majeur. Une mauvaise organisation peut entraîner des retards, un manque d'efficacité et des désagréments pour les étudiants et l'administration. La gestion traditionnelle sur papier ou avec des fichiers statiques est souvent source d'erreurs et peu optimisée.

Une solution informatisée permettrait de simplifier la gestion des bus, des abonnements et d'améliorer l'expérience des étudiants en garantissant un suivi précis.

❓ Problématique
Les universités font face à plusieurs défis dans la gestion des transports étudiants :

Attribution inefficace des places dans les bus

Manque de suivi des abonnements

Difficulté d'accès aux informations sur les bus et abonnés

Expérience utilisateur peu intuitive pour l’administration

Un système numérique permettrait une gestion plus efficace et une meilleure satisfaction des utilisateurs.

🎯 Objectif
L'objectif du projet UniTransport est de développer une application pour faciliter la gestion des transports universitaires.

L’application doit permettre :
✅ Un suivi précis des abonnements aux bus
✅ Une gestion optimisée des étudiants et des bus
✅ Des outils de recherche et de filtrage avancés
✅ Une visualisation claire des abonnements et des disponibilités

📊 Diagrammes
📌 Diagramme Use Case : (Représentation des interactions entre étudiants, administrateurs et système)
📌 Diagramme de Classe : (Structure des entités principales : Bus, Étudiant, Abonnement)

🗃 Tables de Données
1️⃣ Bus (id, immatriculation, nombre_places)
2️⃣ Étudiant (id, nom, prénom, email)
3️⃣ AbonnementTransport (id, bus_id, etudiant_id, date_abonnement)
4️⃣ User (login, password)

✨ Fonctionnalités Principales
1️⃣ Gestion des Bus
🚍 Ajouter un bus (saisie de l'immatriculation et du nombre de places)
🚍 Modifier les informations d'un bus
🚍 Supprimer un bus

2️⃣ Gestion des abonnements étudiants
🎫 Abonner un étudiant à un bus
🎫 Désinscrire un étudiant

3️⃣ Recherche et filtrage
🔎 Trouver un étudiant par nom ou email
🔎 Lister les abonnements d’un étudiant
🔎 Voir la liste des étudiants abonnés à un bus

🔍 Requêtes SQL
Création des tables
sql
Copy
Edit
CREATE TABLE Bus (
    id INT NOT NULL AUTO_INCREMENT,
    immatriculation VARCHAR(20) NOT NULL,
    nombre_places INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Etudiant (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE AbonnementTransport (
    id INT NOT NULL AUTO_INCREMENT,
    bus_id INT NOT NULL,
    etudiant_id INT NOT NULL,
    date_abonnement DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (bus_id) REFERENCES Bus(id),
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id)
);

CREATE TABLE User (
    login VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (login)
);
🏛 Architecture
L’application suit une structure MVC (Modèle-Vue-Contrôleur) :

ma.projet.utils → Gestion de la connexion à la base de données

ma.projet.entities → Classes des entités Bus, Etudiant, AbonnementTransport

ma.projet.services → DAO pour la gestion des opérations CRUD

ma.projet.dao → Interface générique IDao<T>

🛠 Technologies Utilisées
💻 Java Swing (Interface graphique)
📊 MySQL (Base de données)
🔗 JDBC (Connexion base de données)
🛠 NetBeans (IDE de développement)
🗂 phpMyAdmin (Gestion SQL)
🎨 Icons8 (Bibliothèque d’icônes)

🎥 Démo Vidéo
🚀 Une démonstration interactive montrant la gestion des bus et abonnements étudiants

📁 Version .exe disponible pour tester l’application en local.
