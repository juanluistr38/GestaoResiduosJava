CREATE SEQUENCE SEQ_AGENDAMENTO
   START WITH 1
   INCREMENT BY 1
   CACHE 20;

   CREATE TABLE tbl_agendamento (
    id_agendamento      INTEGER DEFAULT SEQ_AGENDAMENTO.NEXTVAL  NOT NULL,
    usuario_id          NUMBER NOT NULL,
    endereco            VARCHAR2(255) NOT NULL,
    tipo_lixo           VARCHAR2(255) ,
    data_hora_envio     TIMESTAMP NOT NULL
);

