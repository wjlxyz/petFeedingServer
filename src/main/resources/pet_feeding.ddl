/* SQLEditor (MySQL (2))*/


CREATE TABLE user
(
  user_id INTEGER(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE ,
  user_name VARCHAR(16) NOT NULL UNIQUE ,
  password VARCHAR(64) NOT NULL,
  gender TINYINT(1) NOT NULL DEFAULT 0,
  phone_number INTEGER(11) UNSIGNED NOT NULL UNIQUE ,
  user_role TINYINT(1) NOT NULL DEFAULT 0,
  avatar VARCHAR(255),
  user_address VARCHAR(256),
  create_at DATETIME NOT NULL,
  update_at DATETIME NOT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB;

CREATE TABLE `order`
(
  order_id INTEGER(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE ,
  customer_id INTEGER(11) UNSIGNED NOT NULL,
  servant_id INTEGER(11) UNSIGNED NOT NULL,
  order_status TINYINT(1) UNSIGNED NOT NULL DEFAULT 0,
  distance INTEGER(4) UNSIGNED NOT NULL,
  pet_number INTEGER(4) UNSIGNED NOT NULL DEFAULT 1,
  feeding_cost FLOAT UNSIGNED NOT NULL,
  payment_mode VARCHAR(10),
  satisfaction INTEGER(1) UNSIGNED NOT NULL DEFAULT 5,
  evaluation VARCHAR(255),
  create_at DATETIME NOT NULL,
  update_at DATETIME NOT NULL,
  PRIMARY KEY (order_id)
) ENGINE=InnoDB;

ALTER TABLE `order` ADD FOREIGN KEY customer_id_idxfk (customer_id) REFERENCES user (user_id);

ALTER TABLE `order` ADD FOREIGN KEY servant_id_idxfk (servant_id) REFERENCES user (user_id);
