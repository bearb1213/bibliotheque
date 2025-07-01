DROP DATABASE IF EXISTS bibliotheque;
CREATE DATABASE bibliotheque;
USE bibliotheque;

CREATE TABLE auteur(
   id INT AUTO_INCREMENT,
   name VARCHAR(255),
   first_name VARCHAR(255),
   birthday DATE,
   nationality VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE genre (
   id INT AUTO_INCREMENT,
   nom_genre VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE periode (
   id INT AUTO_INCREMENT,
   nom_periode VARCHAR(255),
   annee_debut INT,
   annee_fin INT,
   PRIMARY KEY(id)
);

CREATE TABLE maison_edition (
   id INT AUTO_INCREMENT,
   nom_edition VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE collection (
   id INT AUTO_INCREMENT,
   nom_collection VARCHAR(255),
   id_maison_edition INT,
   PRIMARY KEY(id),
   FOREIGN KEY(id_maison_edition) REFERENCES maison_edition(id)
);

CREATE TABLE livre (
   id INT AUTO_INCREMENT,
   isbn VARCHAR(255),
   titre VARCHAR(255) NOT NULL,
   resume TEXT,
   premiere_edition DATE,
   langue VARCHAR(50),
   nb_pages INT,
   age_limite INT,
   id_periode INT NOT NULL,
   id_collection INT NOT NULL,
   id_genre INT NOT NULL,
   id_auteur INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_periode) REFERENCES periode(id),
   FOREIGN KEY(id_collection) REFERENCES collection(id),
   FOREIGN KEY(id_genre) REFERENCES genre(id),
   FOREIGN KEY(id_auteur) REFERENCES auteur(id)
);

CREATE TABLE exemplaire (
   id INT AUTO_INCREMENT,
   date_arrivee DATE,
   id_livre INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_livre) REFERENCES livre(id)
);

CREATE TABLE statut (
   id INT AUTO_INCREMENT,
   nom_statut VARCHAR(255),
   PRIMARY KEY(id)
);

insert into statut (nom_statut) values ('actif') , ('inactif');


CREATE TABLE type_membre (
   id INT AUTO_INCREMENT,
   nom_type VARCHAR(255),
   cotisation DECIMAL(15,2),
   PRIMARY KEY(id)
);

CREATE TABLE utilisateur (
   id INT AUTO_INCREMENT,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255),
   email VARCHAR(255),
   telephone VARCHAR(255),
   mot_de_passe VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE cotisation (
   id INT AUTO_INCREMENT,
   montant_mensuel DECIMAL(15,2),
   date_changement DATETIME,
   id_type_membre INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_type_membre) REFERENCES type_membre(id)
);

CREATE TABLE paiement (
   id INT AUTO_INCREMENT,
   montant DECIMAL(15,2) NOT NULL,
   date_paiement DATETIME NOT NULL,
   id_utilisateur INT NOT NULL,
   id_type_membre INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id),
   FOREIGN KEY(id_type_membre) REFERENCES type_membre(id)
);

CREATE TABLE bibliothecaire (
   id INT AUTO_INCREMENT,
   id_utilisateur INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id)
);

CREATE TABLE type_pret (
   id INT AUTO_INCREMENT,
   nom_type_pret VARCHAR(255),
   PRIMARY KEY(id)
);
insert into type_pret (nom_type_pret) values ('Sur Place'),('A Domicile') ;

CREATE TABLE statut_reservation (
   id INT AUTO_INCREMENT,
   nom_statut VARCHAR(255),
   PRIMARY KEY(id)
);
insert into statut_reservation (nom_statut) values ('En Attente'),('Valide'),('Annulee'),('Terminee');

CREATE TABLE penalite (
   id INT AUTO_INCREMENT,
   nb_jours_retard INT,
   penalite_par_jour INT,
   PRIMARY KEY(id)
);

CREATE TABLE jour_ferie (
   id INT AUTO_INCREMENT,
   date_jour_ferie DATE,
   PRIMARY KEY(id)
);

CREATE TABLE adherent (
   id INT AUTO_INCREMENT,
   date_debut DATETIME,
   date_fin DATETIME,
   id_utilisateur INT NOT NULL,
   id_type_membre INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id),
   FOREIGN KEY(id_type_membre) REFERENCES type_membre(id)
);

CREATE TABLE pret (
   id INT AUTO_INCREMENT,
   date_debut DATETIME,
   date_fin DATETIME,
   id_exemplaire INT NOT NULL,
   id_type_pret INT,
   id_adherent INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_exemplaire) REFERENCES exemplaire(id),
   FOREIGN KEY(id_type_pret) REFERENCES type_pret(id),
   FOREIGN KEY(id_adherent) REFERENCES adherent(id)
);

-- ;bola tohizana
CREATE TABLE reservation (
   id INT AUTO_INCREMENT,
   date_changement DATETIME,
   id_exemplaire INT NOT NULL,
   id_statut INT NOT NULL,
   id_adherent INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_exemplaire) REFERENCES exemplaire(id),
   FOREIGN KEY(id_statut) REFERENCES statut_reservation(id),
   FOREIGN KEY(id_adherent) REFERENCES adherent(id)
);

CREATE TABLE penalite_utilisateur(
   id INT AUTO_INCREMENT,
   date_debut DATETIME,
   date_fin DATETIME,
   id_penalite INT NOT NULL,
   id_utilisateur INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_penalite) REFERENCES penalite(id),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id)
);

CREATE TABLE quota (
   id INT AUTO_INCREMENT,
   valeur INT,
   date_changement DATETIME,
   id_type_membre INT NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (id_type_membre) REFERENCES type_membre(id)
);


