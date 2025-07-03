INSERT INTO utilisateur(nom,email,mot_de_passe,id_type) VALUES
    ('bibliothecaire' , 'biblio@gmail.com' , 'biblio' , 2);

    insert into auteur(nom) VALUES ('Descarte') , ('Voltaire');

INSERT INTO genre (genre) VALUES ('Roman');
INSERT INTO genre (genre) VALUES ('Science-fiction');
INSERT INTO genre (genre) VALUES ('Fantasy');
INSERT INTO genre (genre) VALUES ('Policier');
INSERT INTO genre (genre) VALUES ('Thriller');
INSERT INTO genre (genre) VALUES ('Horreur');
INSERT INTO genre (genre) VALUES ('Historique');
INSERT INTO genre (genre) VALUES ('Biographie');
INSERT INTO genre (genre) VALUES ('Essai'); 


INSERT INTO livre (titre, synopsis, date_publication, page, age_lim, id_auteur) VALUES
('Le Souffle des Etoiles', 
 'Dans un futur lointain, une jeune capitaine de vaisseau spatial decouvre une conspiration menacant la galaxie entiere.',
 '2023-06-15', 428, 14, 1),

('Les Brumes dAlteria', 
 'Une adolescente decouvre qu elle est la cle dun monde magique cache derriere un miroir ancien.',
 '2019-10-01', 352, 12, 2),

('Le Dernier Chapitre', 
 'Un ecrivain a succes est accuse dun meurtre identique a celui decrit dans son dernier roman.',
 '2021-04-07', 310, 16, 1),

('Les Cendres de lHiver', 
 'Dans une Europe devastee par une guerre fictive, un soldat tente de rentrer chez lui a pied a travers des ruines glacees.',
 '2018-01-23', 290, 15, 2),

('Petits Mots pour Grand Coeur', 
 'Un recueil de lettres fictives ecrites par une mere a sa fille durant sa maladie, plein de sagesse et despoir.',
 '2022-03-14', 180, 10, 1),

('Les Oublies de la Tour Noire', 
 'Un detective et une bibliothecaire unissent leurs forces pour elucider des disparitions mysterieuses liees a une tour maudite.',
 '2020-09-17', 398, 13, 2),

('Eclats de Verre', 
 'Une femme revient dans sa ville natale apres 20 ans d absence pour resoudre un mystere familial.',
 '2017-11-05', 275, 16, 1),

('La Machine a Rever', 
 'Un garcon decouvre une etrange machine qui lui permet dentrer dans les reves des autres.',
 '2023-02-22', 320, 11, 2),

('La Promesse du Lac', 
 'Un roman damour sur deux ames liees par une promesse faite sur les rives dun lac vingt ans plus tot.',
 '2016-06-10', 340, 14, 1),

('Carnet de lOubli', 
 'Un vieil homme retrouve un carnet rempli de souvenirs quil ne se rappelle pas avoir vecus.',
 '2015-08-20', 210, 12, 2);


-- Livre 1 : Science-fiction (2)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (1, 2);

-- Livre 2 : Fantasy (3), Jeunesse (8)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (2, 3);
INSERT INTO livre_genre (id_livre, id_genre) VALUES (2, 8);

-- Livre 3 : Thriller (5)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (3, 5);

-- Livre 4 : Historique (7), Aventure (9)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (4, 7);
INSERT INTO livre_genre (id_livre, id_genre) VALUES (4, 9);

-- Livre 5 : Essai (9)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (5, 9);

-- Livre 6 : Policier (4), Fantasy (3)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (6, 4);
INSERT INTO livre_genre (id_livre, id_genre) VALUES (6, 3);

-- Livre 7 : Roman (1), Thriller (5)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (7, 1);
INSERT INTO livre_genre (id_livre, id_genre) VALUES (7, 5);

-- Livre 8 : Science (9), Jeunesse (8)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (8, 9);
INSERT INTO livre_genre (id_livre, id_genre) VALUES (8, 8);

-- Livre 9 : Romance (assume id 6), Classique (1)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (9, 1);
INSERT INTO livre_genre (id_livre, id_genre) VALUES (9, 6);

-- Livre 10 : Roman (1)
INSERT INTO livre_genre (id_livre, id_genre) VALUES (10, 1);

