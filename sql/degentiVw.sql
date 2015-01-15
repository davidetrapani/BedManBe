--------------------------------------------------------
--  File creato - giovedì-gennaio-15-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View DEGENTI_VW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "SCOTT"."DEGENTI_VW" ("DEG_ID", "DEG_STANZA", "DEG_LETTO", "DEG_STR_STR", "DEG_RIC_ANNO", "DEG_RIC_CARTELLA", "DEG_ASS_IPCA", "DEG_ASS_COGN", "DEG_ASS_NOME", "DEG_ASS_DATNA", "DEG_REPARTO_ASS", "DEG_DESC_REP_ASS") AS 
  select TO_NUMBER(TO_CHAR(DEG_STR_STR)||TO_CHAR(DEG_RIC_aNNO)||TO_CHAR(DEG_RIC_CARTELLA)||to_char((deg_letto_ini - to_date('01011970','ddmmyyyy'))*86400)) DEG_ID, "DEG_STANZA","DEG_LETTO","DEG_STR_STR","DEG_RIC_ANNO","DEG_RIC_CARTELLA","DEG_ASS_IPCA","DEG_ASS_COGN","DEG_ASS_NOME","DEG_ASS_DATNA","DEG_REPARTO_ASS","DEG_DESC_REP_ASS" from degenti;
