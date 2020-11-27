
INSERT INTO PUBLIC.TUTOR (FIRSTNAME_PROF, LASTNAME_PROF, LOGIN_PROF, PWD_PROF)
    VALUES  ('Etienne ', 'Ygorra', 20170227, 123),
            ('Tristan', 'Esteban', 20170330, 123),
            ('Guillaume', 'Hamel', 20170378, 123);

INSERT INTO PUBLIC.DOC (CDC, FICHE_EVAL, SONDAGE, RAPPORT, SOUTENANCE)
    VALUES  ('true', 'true', 'true', 'true', 'true'),
            ('false', 'true', 'false', 'true', 'true'),
            ('false', 'true', 'true', 'true', 'false'),
            ('false', 'true', 'true', 'true', 'false'),
            ('true', 'false', 'false', 'false', 'true'),
            ('true', 'true', 'false', 'true', 'true'),
            ('true', 'true', 'false', 'false', 'true'),
            ('true', 'false', 'true', 'false', 'true'),
            ('true', 'false', 'false', 'true', 'true');

INSERT INTO PUBLIC.STUDENT (FIRSTNAME_STUDENT, LASTNAME_STUDENT, GROUP_STUDENT, ID_TUTOR, ID_DOC)
    VALUES  ('Adam', 'Troajour', '2', 1, 1),
            ('Bill', 'Aterahl', '2', 1, 2),
            ('Nicolas', 'Cardoso', '3', 1, 3),
            ('Cedric', 'Merliot', '3', 2, 4),
            ('Louis', 'Tran', '3', 2, 5),
            ('Camille', 'Onette', '3', 2, 6),
            ('Daisy', 'Rable', '3', 2, 7),
            ('Eddie', 'Scylla', '3', 2, 8),
            ('Firmin', 'Peutagel', '3', 3, 9);


INSERT INTO PUBLIC.VISITE (FICHE_VISITE, PLANNIF, FAITE, ID_TUTOR, ID_STUDENT)
    VALUES  ('true', 'false', 'true', 1, 1),
            ('true', 'true', 'true', 1, 2),
            ('true', 'true', 'true', 1, 3),
            ('true', 'true', 'true', 2, 4),
            ('true', 'false', 'false', 2, 5),
            ('false', 'true', 'false', 2, 6),
            ('true', 'true', 'false', 2, 7),
            ('false', 'false', 'true', 2, 8),
            ('false', 'false', 'false', 3, 9);

INSERT INTO PUBLIC.ENTREPRISE (NAME_ENTREPRISE, ADRESSE)
    VALUES  ('Lacoste', '31 rue du crocodile'),
            ('Sephora', '7 rue du lila'),
            ('Boulanger', '18 rue des champs'),
            ('Intermarche', '5 rue la table'),
            ('Discord', '23 rue des emoticones'),
            ('Decathlon', '2 rue du marathon');

INSERT INTO PUBLIC.STAGE (DEBUT, FIN, MDS, NOTE_TECH, NOTE_COM, ID_ENTERPRISE, ID_STUDENT, DESCRIPTION_MISSION, COMMENTAIRE)
    VALUES  ('2020-05-16 00:00:00.000000', '2020-08-17 00:00:00.000000', 'Thierry', 12, 10, 1, 1, 'Classer les papier par couleur', 'Ne connait pas les couleurs'),
            ('2020-04-11 00:00:00.000000', '2020-09-19 00:00:00.000000', 'Thierry', 15, 12, 1, 2, 'Faire les cafés', 'il était trop chaud'),
            ('2020-11-12 00:00:00.000000', '2021-09-17 00:00:00.000000', 'Guy', 17, 13, 2, 3, 'Tester chacun des canapés du magasin', 'Ne dort pas assez au travail'),
            ('2020-11-12 00:00:00.000000', '2021-09-17 00:00:00.000000', 'Guy', 16, 18, 2, 4, 'Coder le site du gouvernement', 'Parfait il gère'),
            ('2020-11-21 00:00:00.000000', '2021-07-10 00:00:00.000000', 'Henry', 8, 15, 3, 5, 'Faire un marathon sur twitch', 'A fait une crise cardiaque'),
            ('2020-11-21 00:00:00.000000', '2021-07-10 00:00:00.000000', 'Henry', 7, 14, 3, 6, 'Faire des impressions', 'Pour sur, il a fait une forte impression'),
            ('2020-11-21 00:00:00.000000', '2021-07-10 00:00:00.000000', 'Julia', 12, 13, 4, 7, 'Créer la base de données', 'Comment on utilise le insert ?'),
            ('2020-11-21 00:00:00.000000', '2021-07-10 00:00:00.000000', 'Paul', 10, 18, 5, 8, 'Recurer les WC', 'Passe plus de temps dessus qu à les nettoyer'),
            ('2020-11-21 00:00:00.000000', '2021-07-10 00:00:00.000000', 'Bob', 3, 11, 6, 9, 'Faire des croches pieds aux clients', 'Parfait 2 clients se sontt cassé une jambe');

DELETE FROM STAGE;
DELETE FROM ENTREPRISE;
DELETE FROM VISITE;
DELETE FROM STUDENT;
DELETE FROM DOC;
DELETE FROM TUTOR;