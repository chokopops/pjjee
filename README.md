create table TUTOR
(
    ID_TUTOR       INTEGER auto_increment,
    FIRSTNAME_PROF VARCHAR(25),
    LASTNAME_PROF  VARCHAR(255),
    LOGIN_PROF     VARCHAR(255),
    PWD_PROF       VARCHAR(255),
    constraint PK_TUTOR
        primary key (ID_TUTOR)
);

create table DOC
(
    ID_DOC     INTEGER auto_increment,
    CDC        BOOLEAN,
    FICHE_EVAL BOOLEAN,
    SONDAGE    BOOLEAN,
    RAPPORT    BOOLEAN,
    SOUTENANCE BOOLEAN,
    constraint PK_DOC
        primary key (ID_DOC)
);

create table ENTREPRISE
(
    ID_ENTREPRISE   INTEGER auto_increment,
    NAME_ENTREPRISE VARCHAR(10),
    ADRESSE         VARCHAR(60),
    constraint PK_ENTREPRISE
        primary key (ID_ENTREPRISE)
);

create table STUDENT
(
    ID_STUDENT        INTEGER auto_increment,
    FIRSTNAME_STUDENT VARCHAR(25),
    LASTNAME_STUDENT  VARCHAR(25),
    GROUP_STUDENT     VARCHAR(10),
    ID_TUTOR          INTEGER,
    ID_DOC            INTEGER,
    constraint PK_STUDENT
        primary key (ID_STUDENT),
    constraint FK_DOC
        foreign key (ID_DOC) references DOC (ID_DOC),
    constraint FK_TUTOR
        foreign key (ID_TUTOR) references TUTOR (ID_TUTOR)
);

create table STAGE
(
    ID_STAGE            INTEGER auto_increment,
    DEBUT               DATETIME,
    FIN                 DATETIME,
    MDS                 VARCHAR(10),
    NOTE_TECH           INTEGER,
    NOTE_COM            INTEGER,
    ID_ENTERPRISE       INTEGER,
    ID_STUDENT          INTEGER,
    DESCRIPTION_MISSION VARCHAR default NULL,
    COMMENTAIRE         VARCHAR default NULL,
    constraint PK_STAGE
        primary key (ID_STAGE),
    constraint FK_ENTREPRISE
        foreign key (ID_ENTERPRISE) references ENTREPRISE (ID_ENTREPRISE),
    constraint FK_STUDENT
        foreign key (ID_STUDENT) references STUDENT (ID_STUDENT)
);

create table VISITE
(
    ID_VISITE    INTEGER auto_increment,
    FICHE_VISITE BOOLEAN,
    PLANNIF      BOOLEAN,
    FAITE        BOOLEAN,
    ID_TUTOR     INTEGER,
    ID_STUDENT   INTEGER,
    constraint PK_VISITE
        primary key (ID_VISITE),
    constraint FK_STUDENT_VISITE
        foreign key (ID_STUDENT) references STUDENT (ID_STUDENT),
    constraint FK_TUTOR_VISITE
        foreign key (ID_TUTOR) references TUTOR (ID_TUTOR)
);
