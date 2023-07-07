INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO users (id, username, email, password, role_id) VALUES (5, 'Nick', 'nick@mail.com', '$2y$16$Nqle7jBFUektjiBrKAyHieT9ii22A1s4Sz8sI0dYYa.vKPvHNmxF6', 2);
INSERT INTO users (id, username, email, password, role_id) VALUES (6, 'Nora', 'nora@mail.com', '$2y$16$713Dl0H9ngj6ETvXJLaEFuSBXPc5DEqiGoVC8aTh7QaCCcaAAfkmO', 1);

INSERT INTO contacts (id, name, owner_id) VALUES (1, 'Contact 1', 5);
INSERT INTO contacts (id, name, owner_id) VALUES (2, 'Contact 2', 5);
INSERT INTO contacts (id, name, owner_id) VALUES (3, 'Contact 3', 6);

INSERT INTO emails (id, name) VALUES (1, 'email1@example.com');
INSERT INTO emails (id, name) VALUES (2, 'email2@example.com');
INSERT INTO emails (id, name) VALUES (3, 'email3@example.com');

INSERT INTO contact_emails (contact_id, email_id) VALUES (1, 1);
INSERT INTO contact_emails (contact_id, email_id) VALUES (2, 2);
INSERT INTO contact_emails (contact_id, email_id) VALUES (3, 3);

INSERT INTO phones (id, phone_number) VALUES (1, '+1234567890');
INSERT INTO phones (id, phone_number) VALUES (2, '+9876543210');
INSERT INTO phones (id, phone_number) VALUES (3, '+1112223333');

INSERT INTO contact_phones (contact_id, phone_id) VALUES (1, 1);
INSERT INTO contact_phones (contact_id, phone_id) VALUES (2, 2);
INSERT INTO contact_phones (contact_id, phone_id) VALUES (3, 3);