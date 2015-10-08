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

('user1', 'pass', '0600000000'), --ID 1
('user2', 'pass', '0666666666'); --ID 2

-- ---------------------------
-- Table UTILISATEUR
-- ---------------------------
INSERT INTO ACHETEUR (ach_usr_id, ach_prenom, ach_nom, ach_date_naissance) VALUES

(2, 'boby', 'bob', '1700-03-26'); --ID 1

-- ---------------------------
-- Table VENDEUR
-- ---------------------------
INSERT INTO VENDEUR (ven_usr_id, ven_nom_entreprise) VALUES

(1, 'monEntreprise'); --ID 1

-- ---------------------------
-- Table PRODUIT
-- ---------------------------
INSERT INTO PRODUIT (prt_nom) VALUES

('beta product'); --ID 1

-- ---------------------------
-- Table OFFRE
-- ---------------------------
INSERT INTO OFFRE (off_prt_id, off_ven_id, off_quantite, off_unite, off_prix_unite, off_date_creation) VALUES

(1, 1, 1, 'kg', 1, '1993-03-26'), --ID 1
(1, 1, 5, 'kg', 5, '1994-03-26'); --ID 2

-- ---------------------------
-- Table OFFRE
-- ---------------------------
INSERT INTO TRANSACTION (tra_ach_id, tra_off_id, tra_date) VALUES

(1, 1, '1993-04-26'); --ID 1