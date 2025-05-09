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

create table CopieRicambi (
      Codice int,
      NumeroRicambio int,
      Stato varchar(5) not null,
      constraint PK_Copie_Ricambi primary key(Codice, NumeroRicambio),
      constraint FK_Copie_Ricambi foreign key(Codice) references Ricambi(Codice),
      constraint CHECK_STATO check(lower(Stato) in ('nuovo', 'usato'))
);

create table Utenti (
    Username varchar(30) primary key,
    Password varchar(255)
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
      NumeroRicambio int,
      Data date not null,
      constraint PK_Aggiungi primary key(IdCarrello, Codice, NumeroRicambio),
      constraint FK1_Aggiungi foreign key(IdCarrello) references Carrelli(IdCarrello),
      constraint FK2_Aggiungi foreign key(Codice, NumeroRicambio) references CopieRicambi(Codice, NumeroRicambio)
);