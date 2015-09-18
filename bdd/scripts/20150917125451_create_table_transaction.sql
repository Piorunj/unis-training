-- // create_table_transaction
-- Migration SQL that makes the change goes here.
CREATE TABLE TRANSACTION (
	TRA_ID SERIAL PRIMARY KEY,
	TRA_ACH_ID INTEGER REFERENCES ACHETEUR(ACH_ID) NOT NULL,
	TRA_OFF_ID INTEGER REFERENCES OFFRE(OFF_ID) NOT NULL,
	TRA_DATE TIMESTAMP NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE TRANSACTION;

