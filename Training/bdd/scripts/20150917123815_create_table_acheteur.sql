-- // create_table_acheteur
-- Migration SQL that makes the change goes here.
CREATE TABLE ACHETEUR (
	ACH_ID SERIAL PRIMARY KEY,
	ACH_USR_ID INTEGER REFERENCES UTILISATEUR(USR_ID) NOT NULL,
	ACH_PRENOM VARCHAR(50) NOT NULL,
	ACH_NOM VARCHAR(50) NOT NULL,
	ACH_DATE_NAISSANCE DATE NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE ACHETEUR;

