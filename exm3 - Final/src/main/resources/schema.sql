CREATE TABLE IF NOT EXISTS usuario(
  username VARCHAR(50) PRIMARY KEY, 
  fullname VARCHAR(150), 
  password VARCHAR(150), 
  birthday DATE, 
  pets INTEGER, 
  status BOOLEAN, 
  role VARCHAR(1500)
);