USE bd_series;
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (1,'AMC',2013,2008,'Breaking Bad','A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family\'s future.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (2,'AMC',0,2010,'The Walking Dead','Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins, and must lead a group of survivors to stay alive.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (3,'AMC',0,2015,'Better Call Saul','The trials and tribulations of criminal lawyer, Jimmy McGill, in the time leading up to establishing his strip-mall law office in Albuquerque, New Mexico.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (4,'AMC',0,2015,'Fear the Walking Dead','A Walking Dead spin-off, set in Los Angeles, following two families who must band together to survive the undead apocalypse.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (5,'NETFLIX',0,2016,'Stranger Things','When a young boy disappears, his mother, a police chief, and his friends must confront terrifying forces in order to get him back.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (6,'NETFLIX',0,2015,'Lucifer','Lucifer Morningstar has decided he\'s had enough of being the dutiful servant in Hell and decides to spend some time on Earth to better understand humanity. He settles in Los Angeles - the City of Angels.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (7,'NETFLIX',0,2017,'Dark','A family saga with a supernatural twist, set in a German town, where the disappearance of two young children exposes the relationships among four families.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (8,'NETFLIX',0,2014,'BoJack Horseman','BoJack Horseman was the star of the hit TV show \"Horsin\' Around\" in the \'90s, now he\'s washed up, living in Hollywood, complaining about everything, and wearing colorful sweaters.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (9,'HBO',2019,2019,'Chernobyl','In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world\'s worst man-made catastrophes.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (10,'HBO',2019,2011,'Game of Thrones','Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (11,'HBO',0,2016,'Westworld','Set at the intersection of the near future and the reimagined past, explore a world in which every human appetite can be indulged without consequence.');
INSERT INTO `serie` (`id_serie`,`emisor`,`fecha_fin`,`fecha_inicio`,`nombre`,`sinopsis`) VALUES (12,'HBO',0,2014,'True Detective','Seasonal anthology series in which police investigations unearth the personal and professional secrets of those involved, both within and outside the law.');

INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (1,7,2008,1,1);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (2,13,2009,2,1);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (3,13,2010,3,1);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (4,13,2011,4,1);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (5,16,2012,5,1);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (6,6,2010,1,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (7,13,2011,2,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (8,16,2012,3,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (9,16,2013,4,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (10,16,2014,5,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (11,16,2015,6,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (12,16,2016,7,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (13,16,2017,8,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (14,16,2018,9,2);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (15,10,2015,1,3);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (16,10,2016,2,3);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (17,10,2017,3,3);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (18,10,2018,4,3);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (19,10,2020,5,3);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (20,6,2015,1,4);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (21,15,2016,2,4);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (22,16,2017,3,4);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (23,16,2018,4,4);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (24,16,2019,5,4);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (25,8,2016,1,5);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (26,9,2017,2,5);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (27,8,2019,3,5);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (28,13,2015,1,6);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (29,18,2016,2,6);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (30,26,2017,3,6);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (31,10,2019,4,6);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (32,10,2017,1,7);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (33,1,2019,2,7);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (34,12,2014,1,8);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (35,13,2014,2,8);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (36,12,2016,3,8);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (37,12,2017,4,8);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (38,12,2018,5,8);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (39,1,2019,6,8);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (40,5,2019,1,9);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (41,10,2011,1,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (42,10,2012,2,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (43,10,2013,3,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (44,10,2014,4,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (45,10,2015,5,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (46,10,2016,6,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (47,7,2017,7,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (48,6,2019,8,10);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (49,10,2016,1,11);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (50,10,2018,2,11);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (51,10,2020,3,11);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (52,8,2014,1,12);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (53,8,2015,2,12);
INSERT INTO `temporada` (`id_temporada`,`episodios`,`fecha_estreno`,`numero_temporada`,`id_serie`) VALUES (54,8,2019,3,12);

INSERT INTO `actor` (`id_actor`,`nombre`,`id_estadistica_tweet`) VALUES (1,'Bryan Cranston',1);
INSERT INTO `actor` (`id_actor`,`nombre`,`id_estadistica_tweet`) VALUES (2,'Anna Gunn',2);
INSERT INTO `actor` (`id_actor`,`nombre`,`id_estadistica_tweet`) VALUES (3,'Aaron Paul',3);
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (4,'Dean Norris');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (5,'Norman Reedus');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (6,'Melissa McBride');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (7,'Andrew Lincoln');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (8,'Lauren Cohan');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (9,'Bob Odenkirk');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (10,'Jonathan Banks');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (11,'Rhea Seehorn');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (12,'Patrick Fabian');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (13,'Alycia Debnam-Carey');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (14,'Colman Domingo');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (15,'Danay Garcia');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (16,'Kim Dickens');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (17,'Winona Ryder');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (18,'David Harbour');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (19,'Finn Wolfhard');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (20,'Millie Bobby Brown');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (21,'Lauren German');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (22,'Tom Ellis');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (23,'Kevin Alejandro');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (24,'D.B. Woodside');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (25,'Oliver Masucci');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (26,'Karoline Eichhorn');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (27,'Jördis Triebel');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (28,'Louis Hofmann');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (29,'Will Arnett');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (30,'Amy Sedaris');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (31,'Alison Brie');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (32,'Jared Harris');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (33,'Stellan Skarsgård');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (34,'Paul Ritter');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (35,'Jessie Buckley');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (36,'Peter Dinklage');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (37,'Lena Headey');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (38,'Emilia Clarke');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (39,'Kit Harington');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (40,'Evan Rachel Wood');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (41,'Jeffrey Wright');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (42,'Ed Harris');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (43,'Thandie Newton');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (44,'Matthew McConaughey');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (45,'Colin Farrell');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (46,'Mahershala Ali');
INSERT INTO `actor` (`id_actor`,`nombre`) VALUES (47,'Woody Harrelson');

INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (1,'Walter White',1,1);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (2,'Skyler White',2,1);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (3,'Jesse Pinkman',3,1);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (4,'Hank Schrader',4,1);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (5,'Daryl Dixon',5,2);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (6,'Carol Peletier',6,2);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (7,'Rick Grimes',7,2);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (8,'Maggie Greene',8,2);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (9,'Saul Goodman',9,3);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (10,'Mike Ehrmantraut',10,3);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (11,'Kim Wexler',11,3);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (12,'Howard Hamlin',12,3);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (13,'Alicia Clark',13,4);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (14,'Victor Strand',14,4);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (15,'Luciana Galvez',15,4);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (16,'Madison Clark',16,4);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (17,'Joyce Byers',17,5);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (18,'Jim Hopper',18,5);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (19,'Mike Wheeler',19,5);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (20,'Eleven',20,5);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (21,'Chloe Decker',21,6);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (22,'Lucifer Morningstar',22,6);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (23,'Dan Espinoza',23,6);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (24,'Amenadiel',24,6);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (25,'Ulrich Nielsen',25,7);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (26,'Charlotte Doppler',26,7);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (27,'Katharina Nielsen',27,7);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (28,'Jonas Kahnwald',28,7);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (29,'BoJack Horseman',29,8);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (30,'Princess Carolyn',30,8);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (31,'Diane Nguyen',31,8);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (32,'Todd Chavez',3,8);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (33,'Valery Legasov',32,9);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (34,'Boris Shcherbina',33,9);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (35,'Anatoly Dyatlov',34,9);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (36,'Lyudmilla Ignatenko',35,9);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (37,'Tyrion Lannister',36,10);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (38,'Cersei Lannister',37,10);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (39,'Daenerys Targaryen',38,10);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (40,'Jon Snow',39,10);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (41,'Dolores Abernathy',40,11);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (42,'Bernard Lowe',41,11);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (43,'Man in Black',42,11);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (44,'Maeve Millay',43,11);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (45,'Detective Rust Cohle',44,12);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (46,'Detective Ray Velcoro',45,12);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (47,'Detective Wayne Hays',46,12);
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_actor`,`id_serie`) VALUES (48,'Detective Marty Hart',47,12);

INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (1,'Crime');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (2,'Drama');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (3,'Thriller');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (4,'Horror');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (5,'Sci-Fi');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (6,'Fantasy');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (7,'Mystery');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (8,'Animation');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (9,'Comedy');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (10,'Action');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (11,'Adventure');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (12,'Romance');
INSERT INTO `genero` (`id_genero`,`nombre`) VALUES (13,'Western');

INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (1,1);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (1,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (1,3);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (2,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (2,4);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (2,5);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (2,3);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (3,1);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (3,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (4,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (4,4);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (4,5);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (4,3);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (5,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (5,6);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (5,4);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (5,7);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (5,5);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (5,3);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (6,1);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (6,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (6,6);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (7,1);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (7,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (7,7);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (7,5);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (7,3);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (8,8);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (8,9);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (8,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (9,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (10,10);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (10,11);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (10,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (10,6);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (10,12);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (11,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (11,7);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (11,5);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (11,13);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (12,1);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (12,2);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (12,7);
INSERT INTO `genero_serie` (`id_serie`,`id_genero`) VALUES (12,3);



INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (1, 3, 4, 2, 5);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (2, 3, 0, 4, 5);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (3, 34, 7, 54, 90);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (4,6,7,8,900);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (5,63,70,80,100);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (6,45,7,8,900);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (7,6,709,8,900);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (8,1,7,8,900);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (9,611,7,8,900);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (10,6,74,32,900);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (11,16,17,18,19);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (12,64,73,82,190);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (13,65,67,58,39);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (14,6,72,84,9);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (15,76,87,88,89);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (16,6,7,8,99);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (17,69,32,80,33);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (18,6,7,8,90);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (19,56,67,8,9);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (20,8,7,8,76);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (21,6,37,8,9);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (22,6,73,8,5);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (23,33,37,8,10);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (24,63,70,8,7);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (25,61,7,88,87);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (26,60,78,68,12);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (27,96,45,18,98);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (28,56,40,28,9);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (29,63,70,83,50);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (30,26,71,23,8);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (31,26,7,8,50);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (32,36,7,8,60);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (33,46,7,8,30);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (34,56,7,8,91);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (35,67,7,8,9);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (36,64,7,82,80);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (37,61,7,84,81);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (38,162,57,8,90);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (39,26,77,8,93);
INSERT INTO `estadistica_tweet` (`id_estadistica_tweet`,`nro_tweets`, `nro_tweets_negativos`, `nro_tweets_neutros`, `nro_tweets_positivos`) VALUES (40,16,67,81,100);
