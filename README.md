# pjjee

SQL Code :
DROP TABLE VISITE;

CREATE TABLE "VISITE" ("ID" INTEGER NOT NULL AUTO_INCREMENT,
                      "GR" VARCHAR(2) NOT NULL,
                      "NOM" VARCHAR(25),
                      "CDC" BOOLEAN,
                      "FICHE" BOOLEAN,
                      "FICHEEVAL" BOOLEAN,
                      "SONDAGE" BOOLEAN,
                      "RAPPORT" BOOLEAN,
                      "SOUT" BOOLEAN,
                      "PLANNIF" BOOLEAN,
                      "FAITE" BOOLEAN,
                      "DEBUT" DATETIME,
                      "FIN" DATETIME,
                      "ENTR" VARCHAR(10),
                      "MDS" VARCHAR(10),
                      "ADRESSE" VARCHAR(60),
                      "NOTE_TECH" INTEGER,
                      "NOTE_COM" INTEGER,
                       CONSTRAINT INTEGER PRIMARY KEY (ID)
                      ); //INSERT INTO VISITE(GR,NOM,CDC,FICHE,FICHEEVAL,SONDAGE,RAPPORT,SOUT,PLANIF,FAITE,DEBUT,FIN,ENTR,ADRESSE,NOTE_TECH,NOTE_COM);

