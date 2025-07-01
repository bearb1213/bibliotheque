CREATE DATABASE departement;
\c departement;
CREATE TABLE department
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE employe (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department_id INTEGER,
    CONSTRAINT fk_department
        FOREIGN KEY (department_id)
        REFERENCES department(id)
);

CREATE TABLE film (
    id SERIAL PRIMARY KEY ,
    titre VARCHAR(255) ,
    date_sortie Date 
);

CREATE TABLE categorie (
    id SERIAL PRIMARY KEY ,
    nom VARCHAR(255) 
);

CREATE TABLE filmCategorie (
    id SERIAL PRIMARY KEY ,
    film_id INTEGER REFERENCES film(id),
    categorie_id INTEGER REFERENCES categorie(id)
);

INSERT INTO categorie (nom) VALUES 
('Action'),
('Aventure'),
('Comédie'),
('Drame'),
('Fantastique'),
('Horreur'),
('Science-Fiction'),
('Thriller'),
('Romance'),
('Animation');
