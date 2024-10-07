CREATE SEQUENCE SEQ_USUARIOS
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE TABLE tbl_usuario (
    id_usuario       INTEGER  DEFAULT SEQ_USUARIOS.NEXTVAL NOT NULL PRIMARY KEY,
    nome             VARCHAR2(100) NOT NULL,
    email            VARCHAR2(100) NOT NULL UNIQUE,
    senha            VARCHAR2(256) NOT NULL,
    role             VARCHAR2(50)
);

