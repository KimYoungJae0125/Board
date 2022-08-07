DROP TABLE IF EXISTS Products;

CREATE TABLE Products
(
    id            BIGINT          AUTO_INCREMENT
  , name          VARCHAR(255)    NOT NULL
  , price         INT             NOT NULL
  , content       VARCHAR(4000)
  , creation_time TIMESTAMP
  , user_id       BIGINT
  , PRIMARY KEY(id)
);