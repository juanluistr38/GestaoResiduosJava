
CREATE SEQUENCE SEQ_TBL_CAMINHAO
    START WITH 1
    INCREMENT BY 1
    CACHE 20;

CREATE TABLE tbl_caminhoes (
    id_caminhao   INTEGER DEFAULT SEQ_TBL_CAMINHAO.NEXTVAL  NOT NULL PRIMARY KEY,
    placa         VARCHAR2(10) NOT NULL UNIQUE,
    modelo        VARCHAR2(100),
    capacidade    NUMBER NOT NULL,
    status        VARCHAR2(20) NOT NULL,
    latitude      NUMBER,
    longitude     NUMBER,
    rota_atual    VARCHAR2(255)
);

