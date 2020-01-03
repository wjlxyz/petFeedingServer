/* SQLEditor (Generic SQL)*/


CREATE TABLE 'user'
(
  id INTEGER DEFAULT '10000' NOT NULL AUTO_INCREMENT ,
  user_name VARCHAR(16) NOT NULL UNIQUE ,
  phone_number INTEGER(11) NOT NULL UNIQUE ,
  user_role TINYINT(1) DEFAULT '0' NOT NULL,
  user_address CHAR,
  CONSTRAINT id PRIMARY KEY (id)
);

