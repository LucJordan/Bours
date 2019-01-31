-- sqlplus za/za
-- create user bours identified by bours;
-- grant dba to bours
-- quitter

-- sqlplus bours/bours

DROP table ordreconclu;
create SEQUENCE idAcceptOrdre;
Drop TABLE acceptOrdre;
drop table transaction;
drop sequence idTransaction;
drop table titre_vendu;
drop sequence idTitre_vendu;
drop table titre;
drop sequence idTitre;
drop table ordre;
drop sequence idOrdre;
drop table client;
drop sequence idClient;
drop table societe;
drop sequence idSociete;
drop table brocker;
drop sequence idBrocker;

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
    argent decimal,
    delai_payement SMALLINT,
	pourcentage_penalisation DECIMAL
);
create sequence idBrocker;

create table societe(
    idSociete varchar(10) not null primary key,
    nom varchar(50),
    nbTitre integer
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
    idTitre_vendu varchar(10) primary key,
    idTitre varchar(10) not null,
    idProprietaire varchar(10) not null,
    foreign key (idTitre) references Titre(idTitre),    
    foreign key (idProprietaire) references Client(idClient)    
);

create sequence idTitre_vendu;

create table transaction (
    idTransaction varchar(10) primary key,
    dateTransac date,
    idOrdreVente varchar(10) not null,
    idOrdreAchat varchar(10) not null,
    montantBrockerV decimal,
    montantBrockerA decimal,
    foreign key (idOrdreVente) references ordre(idOrdre),
    foreign key (idOrdreAchat) references ordre(idOrdre)
);

drop sequence idTransaction;
create sequence idTransaction;

CREATE TABLE acceptOrdre(
    idAcceptOrdre varchar(10) primary key,
    idOrdre varchar(10) ,
    FOREIGN KEY (idOrdre) REFERENCES Ordre(idOrdre)
);

drop SEQUENCE idAcceptOrdre;
create SEQUENCE idAcceptOrdre;

-- Drop view ordreaccepted ;
-- CREATE view ordreaccepted as 
-- select * from ordre where idordre in (select idordre from acceptOrdre) and idOrdre not in (select idOrdreVente from transaction) and idOrdre not in (select idOrdreAchat from transaction) ;

-- DROP view ordrenotaccepted ;
-- CREATE view ordrenotaccepted as 
-- select * from ordre where idordre not in (select idordre from acceptOrdre)  and idOrdre not in (select idOrdreVente from transaction) and idOrdre not in (select idOrdreAchat from transaction) ;

-- create view info_titre as
-- select Titre_vendu.idTitre_vendu idTitre_vendu,Titre_vendu.idTitre idTitre,Titre_vendu.idProprietaire idProprietaire,Titre.prix prix,Societe.idSociete idSociete, Societe.nom nomSociete,Societe.nbTitre nbTitre
-- from Titre_vendu,Titre,Societe
-- where Titre_vendu.idTitre = Titre.idTitre and Titre.idSociete = Societe.idSociete

create table ordreconclu(
    idOrdreconclu VARCHAR(10) PRIMARY KEY,
    idBrocker VARCHAR(10),
    idOrdre0 VARCHAR(10),
    idOrdre1 VARCHAR(10),
    FOREIGN KEY (idBrocker) REFERENCES Brocker(idBrocker),
    FOREIGN KEY (idOrdre0) REFERENCES Ordre(idOrdre),
    FOREIGN KEY (idOrdre1) REFERENCES Ordre(idOrdre)
);

drop sequence idOrdreconclu;

create sequence idOrdreconclu;

drop table payement_brocker;
-- drop table payement_brocker;
create table payement_brocker(
    idPayement_brocker VARCHAR(10) PRIMARY KEY,
    idClient VARCHAR(10),
    idBrocker VARCHAR(10),
    argent decimal,--negatif pour le brocker , positif pour le client
    date_payement date,
    FOREIGN KEY (idClient) REFERENCES Client(idClient),
    FOREIGN KEY (idBrocker) REFERENCES Brocker(idBrocker)
);

drop SEQUENCE idPayement_brocker;
CREATE SEQUENCE idPayement_brocker;

---------reinitialiser
delete from transaction;
drop sequence idtransaction;
create sequence idtransaction;
delete from ordreconclu;
drop sequence idOrdreconclu;
create sequence idOrdreconclu;
delete from payement_brocker;
drop sequence idpayement_brocker;
create sequence idpayement_brocker;
update client set argent=10000 where idclient='cl_1';
update client set argent=10000 where idclient='cl_2';
commit;