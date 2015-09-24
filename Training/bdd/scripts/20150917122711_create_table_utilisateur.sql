-- // create_table_user
-- Migration SQL that makes the change goes here.
CREATE TABLE UTILISATEUR (
	USR_ID SERIAL PRIMARY KEY,
	USR_LOGIN VARCHAR(50) NOT NULL,
	USR_PASSWORD VARCHAR(50) NOT NULL,
	USR_TELEPHONE VARCHAR(20)
);



-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE UTILISATEUR;

