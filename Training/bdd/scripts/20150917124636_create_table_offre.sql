-- // create_table_offre
-- Migration SQL that makes the change goes here.
CREATE TABLE OFFRE (
	OFF_ID SERIAL PRIMARY KEY,
	OFF_PRT_ID INTEGER REFERENCES PRODUIT(PRT_ID) NOT NULL,
	OFF_VEN_ID INTEGER REFERENCES VENDEUR(VEN_ID) NOT NULL,
	OFF_QUANTITE INTEGER NOT NULL,
	OFF_UNITE VARCHAR(10) NOT NULL,
	OFF_PRIX_UNITE INTEGER NOT NULL,
	OFF_DATE_CREATION TIMESTAMP NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE OFFRE;
