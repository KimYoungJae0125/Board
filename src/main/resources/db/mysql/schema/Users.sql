DROP TABLE IF EXISTS Users;

CREATE TABLE Users
(
    id            BIGINT          AUTO_INCREMENT
  , name          VARCHAR(20)     NOT NULL
  , PRIMARY KEY(id)
);