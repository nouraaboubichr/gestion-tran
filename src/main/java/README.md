# 🚍 UniTransport – Une plateforme pour la gestion des bus et des abonnements étudiants

## 📁 Table des matières
- [🗂 Contexte](#contexte)
- [❓ Problématique](#problématique)
- [🎯 Objectif](#objectif)
- [📊 Diagrammes](#diagrammes)
- [🗃 Tables de Données](#tables-de-données)
- [✨ Fonctionnalités principales](#fonctionnalités-principales)
- [🏛 Architecture](#architecture)
- [🛠 Technologies Utilisées](#technologies-utilisées)
- [🎥 Démo Vidéo](#démo-vidéo)
- [🎥 Démo Vidéo .exe](#démo-vidéo-exe)
- [🔍 Requêtes SQL](#requêtes-sql)
- [📁 .exe](#exe)

## 🗂 Contexte
Dans un cadre universitaire, la gestion du transport des étudiants est un enjeu majeur. Une mauvaise organisation peut entraîner des retards, un manque d'efficacité et des désagréments pour les étudiants et l'administration. La gestion traditionnelle sur papier ou avec des fichiers statiques est souvent source d'erreurs et peu optimisée.

Une solution informatisée permettrait de simplifier la gestion des bus, des abonnements et d'améliorer l'expérience des étudiants en garantissant un suivi précis.

## ❓ Problématique
Les universités font face à plusieurs défis dans la gestion des transports étudiants :

- Attribution inefficace des places dans les bus
- Manque de suivi des abonnements
- Difficulté d'accès aux informations sur les bus et abonnés
- Expérience utilisateur peu intuitive pour l’administration

Un système numérique permettrait une gestion plus efficace et une meilleure satisfaction des utilisateurs.

## 🎯 Objectif
L'objectif du projet UniTransport est de développer une application pour faciliter la gestion des transports universitaires.

L’application doit permettre :
- ✅ Un suivi précis des abonnements aux bus
- ✅ Une gestion optimisée des étudiants et des bus
- ✅ Des outils de recherche et de filtrage avancés
- ✅ Une visualisation claire des abonnements et des disponibilités

## 📊 Diagrammes
### 📌 Diagramme Use Case![Image](https://github.com/user-attachments/assets/90f139df-c6c2-48a3-8a67-7f6e79934a36)

### 📌 Diagramme de Classe
![Image](https://github.com/user-attachments/assets/cdd1dcf7-bb3f-4861-aef5-dbda209f1763)

## 🗃 Tables de Données
1️⃣ **Bus** (`id`, `immatriculation`, `nombre_places`)  
2️⃣ **Étudiant** (`id`, `nom`, `prénom`, `email`)  
3️⃣ **AbonnementTransport** (`id`, `bus_id`, `etudiant_id`, `date_abonnement`)  
4️⃣ **User** (`login`, `password`)

## ✨ Fonctionnalités principales
### 1️⃣ Gestion des Bus
- 🚍 Ajouter un bus (saisie de l'immatriculation et du nombre de places)
- 🚍 Modifier les informations d'un bus
- 🚍 Supprimer un bus

### 2️⃣ Gestion des abonnements étudiants
- 🎫 Abonner un étudiant à un bus
- 🎫 Désinscrire un étudiant

### 3️⃣ Recherche et filtrage
- 🔎 Lister les abonnements d’un étudiant
- 🔎 Voir la liste des étudiants abonnés à un bus
## 🏛 Architecture
![Image](https://github.com/user-attachments/assets/18fdca9a-8df8-4772-9e15-a4700adc3b37)
## 🛠 Technologies Utilisées
- 💻 **Java Swing** : Utilisé pour développer l'interface graphique de l'application. Permet de créer une interface conviviale et réactive.
- 📊 **MySQL** : Base de données relationnelle utilisée pour stocker les informations sur les bus, les étudiants et les abonnements.
- 🔗 **JDBC** : Utilisé pour connecter l'application Java à la base de données MySQL et gérer les opérations de lecture et d'écriture.
- 🛠 **NetBeans** : IDE de développement utilisé pour écrire, déboguer et exécuter le code Java du projet.
- 🗂 **phpMyAdmin** : Outil de gestion de la base de données MySQL via une interface web. Utilisé pour configurer et maintenir la base de données.
- 🎨 **Icons8** : Bibliothèque d'icônes utilisée pour embellir l'interface avec des images de qualité professionnelle.
## 🎥 Démo Vidéo
https://github.com/user-attachments/assets/07a1d109-5c96-4773-9970-d1d4aa53dd64
## 🎥 Démo Vidéo .exe
## 🔍 Requêtes SQL
### Création des tables

```sql
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

