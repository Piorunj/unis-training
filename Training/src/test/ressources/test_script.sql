-- RESET BDD CONTENT
TRUNCATE
UTILISATEUR,
ACHETEUR,
VENDEUR,
PRODUIT,
OFFRE,
TRANSACTION;

-- RESTART ALL SEQUENCE	
ALTER SEQUENCE utilisateur_usr_id_seq RESTART WITH 1;
ALTER SEQUENCE acheteur_ach_id_seq RESTART WITH 1;
ALTER SEQUENCE vendeur_ven_id_seq RESTART WITH 1;
ALTER SEQUENCE produit_prt_id_seq RESTART WITH 1;
ALTER SEQUENCE offre_off_id_seq RESTART WITH 1;
ALTER SEQUENCE transaction_tra_id_seq RESTART WITH 1;


-- DONNEES DE TEST

-- ---------------------------
-- Table UTILISATEUR
-- ---------------------------
INSERT INTO UTILISATEUR (usr_login, usr_password, usr_telephone) VALUES

('user1', 'pass', '0600000000'); --ID 1