DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  date_of_birth VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name,date_of_birth) VALUES ("yuya","1990/03/25");
INSERT INTO users (name,date_of_birth) VALUES ("taka","1992/05/10");
INSERT INTO users (name,date_of_birth) VALUES ("hiro","1995/12/23");