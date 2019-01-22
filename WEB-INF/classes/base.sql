-- sqlplus za/za
-- create user bours identified by bours;
-- grant dba to bours
-- quitter

-- sqlplus bours/bours

-- drop table transaction;
-- drop sequence idTransac;
-- drop table titre_vendu;
-- drop sequence id;
-- drop table promotion;
-- drop sequence idProm;
-- drop table titre;
-- drop sequence idTitre;
-- drop table ordre;
-- drop sequence idOrdre;
-- drop table client;
-- drop sequence idClient;
-- drop table societe;
-- drop sequence idSociete;
-- drop table brocker;
-- drop sequence idBrocker;

create table Client(
    idClient varchar(10) not null primary key,
    nom varchar(20),
    argent decimal
);

create sequence idClient;

create table brocker(
    idBrocker varchar(10) primary key not null,
    nom varchar(20),
    pourcentage integer,
    argent decimal
);
create sequence idBrocker;

create table societe(
    idSociete varchar(10) not null primary key,
    nom varchar(50),
    nbTitre integer,
    idBrocker varchar(10) not null,
    foreign key(idBrocker) references brocker(idBrocker)
);
create sequence idSociete;

create table titre(
    idTitre varchar(10) primary key not null,
    idSociete varchar(10) not null,
    prix decimal not null,
    foreign key(idSociete) references societe(idSociete)
);

create sequence idTitre;

create table ordre(
    idOrdre varchar(10) primary key,
    idSociete varchar(10),
    prixUnitaire decimal,
    idClient varchar(10),
    nbTitre integer,
    idBrocker varchar(10) not null,
    type integer,
    dates date,
    foreign key(idBrocker) references brocker(idBrocker),
    foreign key(idSociete) references societe(idsociete),
    foreign key(idClient) references Client(idclient)
);

create sequence idOrdre;

create table titre_vendu (
    id varchar(10) primary key,
    idTitre varchar(10) not null,
    idProprietaire varchar(10) not null,
    foreign key (idTitre) references Titre(idTitre),    
    foreign key (idProprietaire) references Client(idClient)    
);

create sequence id;

create table transaction (
    idTransac varchar(10) primary key,
    dateTransac date,
    idOrdreVente varchar(10) not null,
    idOrdreAchat varchar(10) not null,
    montantBrocker1 decimal,
    montantBrocker2 decimal,
    foreign key (idOrdreVente) references ordre(idOrdre),
    foreign key (idOrdreAchat) references ordre(idOrdre)
);

create sequence idTransac;
