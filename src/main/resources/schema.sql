DROP TABLE IF EXISTS Products;

CREATE TABLE Products
(
    id     IDENTITY        PRIMARY KEY
  , name   VARCHAR(255)    NOT NULL
  , price  INT             NOT NULL
);