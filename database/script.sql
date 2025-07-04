DROP DATABASE IF EXISTS bibliotheque;
CREATE DATABASE bibliotheque;
\c bibliotheque;

CREATE TABLE utilisateur_type(
   id SERIAL,
   type VARCHAR(255),
   PRIMARY KEY(id)
);

INSERT INTO utilisateur_type (type) VALUES ('user' ), ('bibliothecaire' );

CREATE TABLE utilisateur(
   id SERIAL,
   nom VARCHAR(255),
   email VARCHAR(255),
   mot_de_passe VARCHAR(255),
   id_type INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_type) REFERENCES utilisateur_type(id)
);

CREATE TABLE auteur(
   id SERIAL,
   nom VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE genre(
   id SERIAL,
   genre VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE livre(
   id SERIAL,
   titre VARCHAR(255),
   synopsis TEXT,
   date_publication DATE,
   page INTEGER,
   age_lim INTEGER,
   id_auteur INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_auteur) REFERENCES auteur(id)
);

CREATE TABLE livre_genre(
   id SERIAL,
   id_livre INTEGER NOT NULL,
   id_genre INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_livre) REFERENCES livre(id),
   FOREIGN KEY(id_genre) REFERENCES genre(id)
);

CREATE TABLE exemplaire(
   id SERIAL,
   date_arrive DATE,
   id_livre INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_livre) REFERENCES livre(id)
);

CREATE TABLE type_adhesion(
   id SERIAL,
   type VARCHAR(255),
   PRIMARY KEY(id)
);
CREATE TABLE adhesion(
   id SERIAL,
   date_debut TIMESTAMP,
   date_fin TIMESTAMP,
   id_type INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_type) REFERENCES type_adhesion(id),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id)
);

CREATE TABLE action_type(
   id SERIAL,
   action VARCHAR(255),
   PRIMARY KEY(id)
);


CREATE TABLE type_reservation(
   id SERIAL,
   type VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE quota(
   id SERIAL,
   quota INTEGER NOT NULL,
   action VARCHAR(255),
   id_type INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_type) REFERENCES type_adhesion(id)
);

CREATE TABLE reservation(
   id SERIAL,
   date_de_prise TIMESTAMP,
   date_demande TIMESTAMP,
   date_accept TIMESTAMP,
   date_refus TIMESTAMP,
   id_type INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   id_exemplaire INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_type) REFERENCES type_reservation(id),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id),
   FOREIGN KEY(id_exemplaire) REFERENCES exemplaire(id)
);



