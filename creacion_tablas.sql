/*****************************************/
/*Drops previos en caso de existir tablas*/
/*****************************************/
/*****************************************/
/*Drops previos en caso de existir tablas*/
/*****************************************/
DROP SCHEMA IF EXISTS `bd_series`;
CREATE SCHEMA IF NOT EXISTS`bd_series`;
USE `bd_series`;
DROP TABLE IF EXISTS Tweet;
DROP TABLE IF EXISTS Palabra_clave;
DROP TABLE IF EXISTS Temporada;
DROP TABLE IF EXISTS Actor;
DROP TABLE IF EXISTS Personaje;
DROP TABLE IF EXISTS Serie;
DROP TABLE IF EXISTS Estadistica_tweets;

CREATE TABLE Tweet(
	ID_tweet INTEGER PRIMARY KEY,
    tweet varchar(280),
    fecha_hora date,
    geolocalizacion varchar(255)
);

CREATE TABLE Actor(
  ID_actor INTEGER PRIMARY KEY,
  nombre varchar(32),
  sexo INTEGER
);

CREATE TABLE Serie(
	ID_serie INTEGER PRIMARY KEY,
	emisor varchar(64),
  plataforma INTEGER,
	nombre varchar(50),
	fecha_inicio date,
  fecha_fin date,
  sinopsis varchar(1024)
);

CREATE TABLE Temporada(
	ID_temporada INTEGER PRIMARY KEY,
  ID_serie INTEGER,
	numero_temporada int,
  episodios int,
	fecha_estreno date,
  FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie)
	);

CREATE TABLE Personaje(
  ID_personaje INTEGER PRIMARY KEY,
  ID_serie INTEGER,
  ID_actor INTEGER,
  nombre varchar(32),
  sexo INTEGER,
  FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie),
  FOREIGN KEY (ID_actor) REFERENCES Actor(ID_actor)
);

CREATE TABLE Palabra_clave(
	  ID_palabra INTEGER PRIMARY KEY,
		ID_actor INTEGER,
		ID_serie INTEGER,
		ID_personaje INTEGER,
    palabra varchar(32),
    FOREIGN KEY (ID_actor) REFERENCES Actor(ID_actor),
    FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie),
		FOREIGN KEY (ID_personaje) REFERENCES Personaje(ID_personaje)
);

CREATE TABLE Genero(
	ID_genero INTEGER PRIMARY KEY,
	nombre varchar(32)
);
CREATE TABLE Estadistica_tweets(
	ID_estadistica INTEGER PRIMARY KEY,
  ID_serie INTEGER,
  ID_personaje INTEGER,
  ID_actor INTEGER,
	numero_tweets INTEGER,
	numero_tweets_positivos INTEGER,
	numero_tweets_negativos INTEGER,
	numero_tweets_neutros INTEGER,
  FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie),
  FOREIGN KEY (ID_personaje) REFERENCES Personaje(ID_personaje),
  FOREIGN KEY (ID_actor) REFERENCES Actor(ID_actor)
);

CREATE TABLE Serie_genero(
	ID_serie_genero INTEGER PRIMARY KEY,
	ID_serie INTEGER,
	ID_genero INTEGER,
	FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie),
	FOREIGN KEY (ID_genero) REFERENCES Genero(ID_genero)
);

CREATE TABLE Tweet_palabraClave(
	ID_tweet_palabra INTEGER PRIMARY KEY,
	ID_tweet INTEGER,
	ID_palabra INTEGER,
	FOREIGN KEY (ID_tweet) REFERENCES Tweet(ID_tweet)
);
