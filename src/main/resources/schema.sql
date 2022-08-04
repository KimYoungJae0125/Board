DROP TABLE IF EXISTS Products;

CREATE TABLE Products
(
    id            BIGINT          AUTO_INCREMENT
  , name          VARCHAR(255)    NOT NULL
  , price         INT             NOT NULL
  , content       VARCHAR(4000)
  , writer        VARCHAR(10)
  , creation_time TIMESTAMP
  , PRIMARY KEY(id)
);