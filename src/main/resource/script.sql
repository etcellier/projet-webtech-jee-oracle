-- Création de la table Address
CREATE TABLE address (
        id INT NOT NULL,
        street TEXT NOT NULL,
        city TEXT NOT NULL,
        zip TEXT NOT NULL,
        country TEXT NOT NULL,
        PRIMARY KEY (id)
);

-- Création de la table User
CREATE TABLE role (
        id INT NOT NULL,
        name TEXT NOT NULL,
        PRIMARY KEY (id)
);

-- Création de la table Role
CREATE TABLE user (
        id INT NOT NULL,
        email TEXT NOT NULL,
        password TEXT NOT NULL,
        id_address INT NOT NULL,
        id_role INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_address) REFERENCES address(id),
        FOREIGN KEY (id_role) REFERENCES role(id)
);

-- Création de la table Category
CREATE TABLE category (
        id INT NOT NULL,
        name TEXT NOT NULL,
        description TEXT,
        PRIMARY KEY (id)
);

-- Création de la table Product
CREATE TABLE product (
         id INT NOT NULL,
         name TEXT NOT NULL,
         description TEXT,
         price_pt DOUBLE NOT NULL,
         id_category INT NOT NULL,
         PRIMARY KEY (id),
         FOREIGN KEY (id_category) REFERENCES category(id),
);

-- Création de la table Item
CREATE TABLE item (
        id INT NOT NULL,
        quantity INT NOT NULL,
        unit_price DOUBLE NOT NULL,
        id_product INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_product) REFERENCES product(id)
);

-- Création de la table ShoppingCart
CREATE TABLE shopping_cart (
        id INT NOT NULL,
        total DOUBLE NOT NULL,
        id_user INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_user) REFERENCES user(id)
);

-- Création de la table ShoppingCartItem
CREATE TABLE shopping_cart_item (
        id INT NOT NULL
        id_shopping_cart INT NOT NULL,
        id_item INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_shopping_cart) REFERENCES shopping_cart(id),
        FOREIGN KEY (id_item) REFERENCES item(id)
);

-- Création de la table Quote
CREATE TABLE quote (
        id INT NOT NULL,
        date DATE NOT NULL,
        id_user INT NOT NULL,
        id_shopping_cart INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_user) REFERENCES user(id),
        FOREIGN KEY (id_shopping_cart) REFERENCES shopping_cart(id)
);

-- Création de séquences pour les identifiants
CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE item_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE shopping_cart_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE shopping_cart_item_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE address_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE role_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE quote_seq START WITH 1 INCREMENT BY 1;

-- Création des triggers pour les identifiants
CREATE OR REPLACE TRIGGER category_trigger
BEFORE INSERT ON category
FOR EACH ROW
BEGIN
SELECT category_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER product_trigger
BEFORE INSERT ON product
FOR EACH ROW
BEGIN
SELECT product_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER item_trigger
BEFORE INSERT ON item
FOR EACH ROW
BEGIN
SELECT item_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER shopping_cart_trigger
BEFORE INSERT ON shopping_cart
FOR EACH ROW
BEGIN
SELECT shopping_cart_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER shopping_cart_item_trigger
BEFORE INSERT ON shopping_cart_item
FOR EACH ROW
BEGIN
SELECT shopping_cart_item_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER address_trigger
BEFORE INSERT ON address
FOR EACH ROW
BEGIN
SELECT address_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER role_trigger
BEFORE INSERT ON role
FOR EACH ROW
BEGIN
SELECT role_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER user_trigger
BEFORE INSERT ON user
FOR EACH ROW
BEGIN
SELECT user_seq.nextval
INTO :new.id
FROM dual;
END;

CREATE OR REPLACE TRIGGER quote_trigger
BEFORE INSERT ON quote
FOR EACH ROW
BEGIN
SELECT quote_seq.nextval
INTO :new.id
FROM dual;
END;

-- Création d'une procédure pour insérer des données dans la table Category
CREATE OR REPLACE PROCEDURE generate_categories()
LANGUAGE plpgsql
AS $$
DECLARE
i INT := 1;
BEGIN
    WHILE i <= 10 LOOP
        INSERT INTO category (id, name, description)
        VALUES (NEXTVAL('category_sequence'), 'Category'  i, 'Description' || i);
        i := i + 1;
END LOOP;
END;
$$;

-- Création d'une procédure pour insérer des données dans la table Product
CREATE OR REPLACE PROCEDURE generate_articles()
LANGUAGE plpgsql
AS $$
DECLARE
i INT := 1;
j INT := 1;
BEGIN
    WHILE i <= 1000 LOOP
        INSERT INTO product (id, name, description, price_pt, id_category)
        VALUES (NEXTVAL('article_sequence'), 'Article'  i, 'Description' || i, RANDOM() * 100, j);
        IF i % 100 = 0 THEN
          j := j + 1;
        END IF;
        i := i + 1;
END LOOP;
END;
$$;

