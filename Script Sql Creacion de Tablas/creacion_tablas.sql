/*****************************************/
/*Drops previos en caso de existir tablas*/
/*****************************************/
DROP TABLE IF EXISTS Tweet;
DROP TABLE IF EXISTS Palabra_clave;
DROP TABLE IF EXISTS Temporada;
DROP TABLE IF EXISTS Episodio;
DROP TABLE IF EXISTS Actor;
DROP TABLE IF EXISTS Personaje;
DROP TABLE IF EXISTS Serie;
DROP TABLE IF EXISTS Episodio;
DROP TABLE IF EXISTS Estadistica_tweets;
DROP TABLE IF EXISTS Emisor;

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

CREATE TABLE Emisor(
  ID_emisor INTEGER PRIMARY KEY,
  nombre varchar(64),
  plataforma INTEGER
);

CREATE TABLE Serie(
	ID_serie INTEGER PRIMARY KEY,
	ID_emisor INTEGER,
	nombre varchar(50),
	fecha_inicio date,
  fecha_fin date,
  sinopsis varchar(1024),
  FOREIGN KEY (ID_emisor) REFERENCES Emisor(ID_emisor)
);

CREATE TABLE Temporada(
	ID_temporada INTEGER PRIMARY KEY,
  ID_serie INTEGER,
	numero_temporada int,
	fecha_estreno date,
  FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie)
	);

CREATE TABLE Episodio(
  ID_episodio INTEGER PRIMARY KEY,
	ID_temporada INTEGER,
  numero_episodio INTEGER,
  titulo varchar(32),
  fecha_estreno date,
  FOREIGN KEY (ID_temporada) REFERENCES Temporada(ID_temporada)
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
		ID_episodio INTEGER,
		ID_personaje INTEGER,
    palabra varchar(32),
    FOREIGN KEY (ID_actor) REFERENCES Actor(ID_actor),
    FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie),
    FOREIGN KEY (ID_episodio) REFERENCES Episodio(ID_episodio),
		FOREIGN KEY (ID_personaje) REFERENCES Personaje(ID_personaje)
);

CREATE TABLE Genero(
	ID_genero INTEGER PRIMARY KEY,
	nombre varchar(32)
);
CREATE TABLE Estadistica_tweets(
	ID_estadistica INTEGER PRIMARY KEY,
  ID_serie INTEGER,
  ID_episodio INTEGER,
  ID_personaje INTEGER,
  ID_actor INTEGER,
	numero_tweets INTEGER,
	numero_tweets_positivos INTEGER,
	numero_tweets_negativos INTEGER,
	numero_tweets_neutros INTEGER,
  FOREIGN KEY (ID_serie) REFERENCES Serie(ID_serie),
  FOREIGN KEY (ID_episodio) REFERENCES Episodio(ID_episodio),
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
	FOREIGN KEY (ID_tweet) REFERENCES Tweet(ID_tweet),
	FOREIGN KEY (ID_palabra) REFERENCES Palabra_clave(ID_palabra)
);
