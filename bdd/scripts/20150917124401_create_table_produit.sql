-- // create_table_produit
-- Migration SQL that makes the change goes here.
CREATE TABLE PRODUIT (
	PRT_ID SERIAL PRIMARY KEY,
	PRT_NOM VARCHAR(50) NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE PRODUIT;

