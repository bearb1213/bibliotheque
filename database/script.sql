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

INSERT INTO utilisateur(nom,email,mot_de_passe,id_type) VALUES
    ('bibliothecaire' , 'biblio@gmail.com' , 'biblio' , 2);
