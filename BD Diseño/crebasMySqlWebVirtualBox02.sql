/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     31/10/2017 1:11:02 p. m.                     */
/*==============================================================*/


drop table if exists MAQUINA_VIRTUAL;

drop table if exists USUARIOS_SISTEMA;

/*==============================================================*/
/* Table: MAQUINA_VIRTUAL                                       */
/*==============================================================*/
create table MAQUINA_VIRTUAL
(
   ID                   int not null,
   USU_ID               varchar(60) not null,
   USO_MEMORIA          float(30),
   USO_CPU              float(30),
   USO_PROCESAMIENTO    float(30),
   primary key (ID)
);

/*==============================================================*/
/* Table: USUARIOS_SISTEMA                                      */
/*==============================================================*/
create table USUARIOS_SISTEMA
(
   ID                   varchar(60) not null,
   IDENTIFICACION       int,
   NOMBRES              varchar(60),
   APELLIDOS            varchar(60),
   EMAIL                varchar(30),
   CELULAR              int,
   TELEFONO             int,
   TIPOUSUARIO          varchar(20),
   CONTRASENA           varchar(240),
   primary key (ID)
);

alter table MAQUINA_VIRTUAL add constraint FK_RELATIONSHIP_1 foreign key (USU_ID)
      references USUARIOS_SISTEMA (ID) on delete restrict on update restrict;

