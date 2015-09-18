-- // create_table_vendeur
-- Migration SQL that makes the change goes here.
CREATE TABLE VENDEUR (
	VEN_ID SERIAL PRIMARY KEY,
	VEN_USR_ID INTEGER REFERENCES UTILISATEUR(USR_ID) NOT NULL,
	VEN_NOM_ENTREPRISE VARCHAR(50) NOT NULL,
	VEN_TELEPHONE VARCHAR(20)
);


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE VENDEUR;

