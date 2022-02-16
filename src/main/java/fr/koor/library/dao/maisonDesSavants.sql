-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de donnÃ©es                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS maisonSavants;
CREATE DATABASE maisonSavants;
USE maisonSavants;


-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
	IdUser  int(4)	 AUTO_INCREMENT	 PRIMARY KEY ,
	Login  varchar(20)	NOT NULL,
	Email varchar(50) NOT NULL,
	Password  varchar(20)	NOT NULL,
	ConnectionNumber  int(4)		NOT NULL DEFAULT 0
) ENGINE = InnoDB;

INSERT INTO T_Users (IdUser, Login,Email, Password) VALUES ( 1, 'Anderson', 'toto@gmail.com',	'Neo' );

--SELECT * FROM T_Users;
--
---- -----------------------------------------------------------------------------
---- - Construction de la table des administrateurs                            ---
---- -----------------------------------------------------------------------------
--
--CREATE TABLE T_Admins (
--	IdUser int(4) NOT NULL REFERENCES T_Users(IdUser),
--	Rights varchar(10) NOT NULL
--) ENGINE = InnoDB;
--
--INSERT INTO T_Admins VALUES ( 1, "-RWX------" );
--INSERT INTO T_Admins VALUES ( 5, "-RWK------" );
--
---- -----------------------------------------------------------------------------
---- - Construction de la tables des articles en vente                         ---
---- -----------------------------------------------------------------------------
--CREATE TABLE T_Articles (
--	IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
--	Description text NOT NULL,
--	Brand text NOT NULL,
--	UnitaryPrice float(8) NOT NULL
--) ENGINE = InnoDB;
--
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Souris',					'Logitoch',				65 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Clavier',					'Microhard',			49.5 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Systeme d''exploitation',	'Fenetres Vistouille',	150 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Tapis souris', 			'Evolution MM',			5 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Cle USB 8 To', 			'Syno',					8 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Laptop', 					'PH',					1199 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'CD x 500', 				'CETME',				250 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD-R x 100', 			'CETME',				99 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD+R x 100', 			'CETME',				105 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Batterie Laptop', 		'PH',					80 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Casque Audio', 			'Syno',					105 );
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'WebCam', 					'Logitoch',				755 );
--
--SELECT * FROM T_Articles;
--
---- -----------------------------------------------------------------------------
---- - Construction de la tables des commandes                                 ---
---- -----------------------------------------------------------------------------
--CREATE TABLE T_Commands (
--	IdCommand int(4) PRIMARY KEY AUTO_INCREMENT,
--	IdUser int(4) NOT NULL REFERENCES T_Users(IdUser),
--    CommandDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
--) ENGINE = InnoDB;
--
--CREATE TABLE T_CommandLines (
--	IdCommandLine int(4) PRIMARY KEY AUTO_INCREMENT,
--	IdCommand int(4) NOT NULL REFERENCES T_Commands(IdCommand),
--	IdArticle int(4) NOT NULL REFERENCES T_Articles(IdCommand),
--	Quantity int(4) NOT NULL
--) ENGINE = InnoDB;
--
---- Une premiÃ¨re commande
--INSERT INTO T_Commands (IdUser, CommandDate) VALUES ( 2, now() ); 
--INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (1, 1, 5); 
--INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (1, 3, 3);
--
---- Une seconde commande, pour un admin
--INSERT INTO T_Commands (IdUser, CommandDate) VALUES ( 1, now() ); 
--INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (2, 2, 4); 
--INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (2, 3, 1);
--INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (2, 4, 1);
--

--CREATE USER 'webstore'@'localhost' IDENTIFIED BY 'password';
--GRANT ALL ON *.* TO 'webstore'@'localhost';

CREATE TABLE savants (
	idSavant int(4) NOT NULL AUTO_INCREMENT	 PRIMARY KEY,
	nom varchar(50) NOT NULL,
	pays varchar(20) NOT NULL,
	domaine varchar(50) NOT NULL,
	siecle varchar(50) NOT NULL
) ENGINE = InnoDB;

ALTER TABLE savants ADD COLUMN nom VARCHAR(50) AFTER idSavant;

INSERT INTO savants ( nom, pays, domaine, siecle ) VALUES ( 'Ibn Taymiyya','Harran','theologien','13' );
INSERT INTO savants ( nom, pays, domaine, siecle ) VALUES ( 'Ibn Qayyim al-Jawziyya','Damas','theologien','13');


CREATE TABLE oeuvres (
	Id int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idSavant int(4) NOT NULL REFERENCES savants(idSavant),
	livres text NOT NULL
) ENGINE = InnoDB;

INSERT INTO oeuvres ( idSavant, livres ) VALUES ( 2,'La Voie de la patience');
INSERT INTO oeuvres ( idSavant, livres ) VALUES ( 2,'Péchés et guérison');
INSERT INTO oeuvres ( idSavant, livres ) VALUES ( 2,'Zad Al Maad - Se préparer pour l Au-dela en adoptant la conduite du Prophete');
INSERT INTO oeuvres ( idSavant, livres ) VALUES ( 2,'La medecine des coeurs');
INSERT INTO oeuvres ( idSavant, livres ) VALUES ( 2,'La Saveur de la Prière');













