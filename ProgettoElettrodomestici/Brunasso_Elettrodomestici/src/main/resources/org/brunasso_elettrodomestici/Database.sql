create database elettrodomestici;

use elettrodomestici;

create table Ricambi (
     Codice int primary key,
     Nome   varchar(40),
     Marca  varchar(40),
     Categoria varchar(40),
     Fornitore varchar(40),
     Descrizione varchar(200),
     Scorta int,
     Prezzo decimal(4,2),
     PercentualeSconto int
);

create table Utenti (
    Username varchar(30) primary key,
    Password varchar(255) not null
);

create table Carrelli (
      IdCarrello int primary key auto_increment,
      CostoTotale decimal(4,2) not null,
      Username varchar(30) not null,
      constraint FK_Carrelli foreign key(Username) references Utenti(Username)
);

create table Aggiungi (
      IdCarrello int,
      Codice int,
      Data date not null,
      constraint PK_Aggiungi primary key(IdCarrello, Codice),
      constraint FK1_Aggiungi foreign key(IdCarrello) references Carrelli(IdCarrello),
      constraint FK2_Aggiungi foreign key(Codice) references Ricambi(Codice)
);