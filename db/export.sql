--------------------------------------------------------
--  Datei erstellt -Donnerstag-J�nner-25-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BELONGSTO
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."BELONGSTO" 
   (	"USER_ID" NUMBER(*,0), 
	"TEACHER_ID" NUMBER(*,0), 
	"CLASS" VARCHAR2(10 BYTE)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOG
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."LOG" 
   (	"MESSAGE" VARCHAR2(255 BYTE), 
	"TIME" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table OWNSPHRASE
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."OWNSPHRASE" 
   (	"ID" NUMBER(*,0), 
	"USER_ID" NUMBER(*,0), 
	"PHRASE_ID" NUMBER(*,0), 
	"LASTREVISED" DATE, 
	"ACCURACY" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table OWNSWORD
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."OWNSWORD" 
   (	"ID" NUMBER(*,0), 
	"USER_ID" NUMBER(*,0), 
	"WORD_ID" NUMBER(*,0), 
	"LASTREVISED" DATE, 
	"ACCURACY" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PHRASEBELONGS
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."PHRASEBELONGS" 
   (	"PHRASE_ID" NUMBER(*,0), 
	"UNIT_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PHRASES
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."PHRASES" 
   (	"PHRASE_ID" NUMBER(*,0), 
	"TGERMAN" VARCHAR2(40 BYTE), 
	"TENGLISH" VARCHAR2(40 BYTE), 
	"WORD_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REQUESTS
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."REQUESTS" 
   (	"REQ_ID" NUMBER(*,0), 
	"REQ_DATE" DATE, 
	"EDIT_DATE" DATE, 
	"STATUS" VARCHAR2(20 BYTE), 
	"USER_ID" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table UNITS
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."UNITS" 
   (	"UNIT_ID" NUMBER(*,0), 
	"DESCRIPTION" VARCHAR2(80 BYTE), 
	"CREATOR" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."USERS" 
   (	"USER_ID" NUMBER(*,0), 
	"USERNAME" VARCHAR2(30 BYTE), 
	"PASSWORD" VARCHAR2(15 BYTE), 
	"ROLE" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table WORDBELONGS
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."WORDBELONGS" 
   (	"WORD_ID" NUMBER(*,0), 
	"UNIT_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table WORDS
--------------------------------------------------------

  CREATE TABLE "BOOSTL"."WORDS" 
   (	"WORD_ID" NUMBER(*,0), 
	"TGERMAN" VARCHAR2(40 BYTE), 
	"TENGLISH" VARCHAR2(40 BYTE), 
	"VARIETY" VARCHAR2(10 BYTE), 
	"POS" VARCHAR2(10 BYTE), 
	"USAGE" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BOOSTL.BELONGSTO
SET DEFINE OFF;
REM INSERTING into BOOSTL.LOG
SET DEFINE OFF;
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('16.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('16.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('16.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('16.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('16.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('16.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('18.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('18.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('18.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('18.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('18.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('18.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('21.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('21.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('21.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('21.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('21.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('21.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('22.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('22.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('22.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('22.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('22.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('22.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('23.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('23.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('23.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('23.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('23.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('23.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('25.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('25.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('25.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('25.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('25.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('25.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('27.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('27.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('27.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('27.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('27.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('27.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('28.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('28.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('28.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('28.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('28.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('28.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('29.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('29.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('29.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('29.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('29.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('29.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('31.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('31.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('31.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('31.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('31.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('31.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('01.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('01.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('01.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('01.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('01.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('01.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('03.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('03.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('03.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('03.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('03.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('03.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('05.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('05.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('05.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('05.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('05.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('05.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('16.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('16.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('16.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('16.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('16.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('16.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('24.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('24.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('24.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('24.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('24.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('24.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('19.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('19.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('19.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('19.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('19.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('19.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('30.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('30.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('30.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('30.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('30.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('30.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('10.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('10.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('10.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('10.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('10.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('10.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('11.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('11.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('11.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('11.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('11.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('11.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('19.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('19.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('19.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('19.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('19.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('19.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('09.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('15.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('15.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('15.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('15.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('15.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('18.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('09.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('09.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('09.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('09.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('09.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('15.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('18.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('18.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('18.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('18.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('18.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('21.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('21.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('21.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('21.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('21.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('21.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('25.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('25.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('25.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('25.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('25.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('25.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('08.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('08.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('08.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('08.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('08.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('12.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('20.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('20.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('20.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('20.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('20.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('20.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('08.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('12.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('12.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('12.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('12.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('12.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('22.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('22.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('22.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('22.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('22.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('22.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('23.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('23.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('23.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('23.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('23.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('23.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('15.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('15.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('15.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('15.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('15.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('15.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('17.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('17.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('17.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('17.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('17.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('17.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('24.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('24.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('24.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('24.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('24.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('24.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('26.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('26.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('26.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('26.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('26.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('26.12.17','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('02.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('02.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('02.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('02.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('02.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('02.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('04.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('04.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('04.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('04.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('04.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('04.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('06.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('06.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('06.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('06.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('06.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('06.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('07.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('07.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('07.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('07.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('07.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('07.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('13.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('13.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('13.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('13.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('13.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('13.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('14.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('14.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('14.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('14.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('14.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('14.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('17.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('17.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('17.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('17.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('17.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('17.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 1 from 80 to 75',to_date('20.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 3 from 80 to 75',to_date('20.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 5 from 80 to 75',to_date('20.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 6 from 80 to 75',to_date('20.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 11 from 80 to 75',to_date('20.01.18','DD.MM.RR'));
Insert into BOOSTL.LOG (MESSAGE,TIME) values ('decreased acc of word: 13 from 90 to 85',to_date('20.01.18','DD.MM.RR'));
REM INSERTING into BOOSTL.OWNSPHRASE
SET DEFINE OFF;
Insert into BOOSTL.OWNSPHRASE (ID,USER_ID,PHRASE_ID,LASTREVISED,ACCURACY) values ('1','2','1',to_date('19.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSPHRASE (ID,USER_ID,PHRASE_ID,LASTREVISED,ACCURACY) values ('2','2','2',to_date('22.11.17','DD.MM.RR'),'0');
REM INSERTING into BOOSTL.OWNSWORD
SET DEFINE OFF;
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('1','1','1',to_date('20.11.17','DD.MM.RR'),'80');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('2','1','2',to_date('22.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('3','1','3',to_date('19.11.17','DD.MM.RR'),'80');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('4','1','4',to_date('22.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('5','1','5',to_date('19.11.17','DD.MM.RR'),'80');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('6','2','6',to_date('19.11.17','DD.MM.RR'),'80');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('7','2','7',to_date('22.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('8','2','8',to_date('22.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('9','2','9',to_date('22.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('10','3','10',to_date('22.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('11','3','11',to_date('19.11.17','DD.MM.RR'),'80');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('12','3','12',to_date('22.11.17','DD.MM.RR'),'0');
Insert into BOOSTL.OWNSWORD (ID,USER_ID,WORD_ID,LASTREVISED,ACCURACY) values ('13','3','13',to_date('20.11.17','DD.MM.RR'),'90');
REM INSERTING into BOOSTL.PHRASEBELONGS
SET DEFINE OFF;
Insert into BOOSTL.PHRASEBELONGS (PHRASE_ID,UNIT_ID) values ('2','1');
Insert into BOOSTL.PHRASEBELONGS (PHRASE_ID,UNIT_ID) values ('2','2');
REM INSERTING into BOOSTL.PHRASES
SET DEFINE OFF;
Insert into BOOSTL.PHRASES (PHRASE_ID,TGERMAN,TENGLISH,WORD_ID) values ('1','I agree with you.','Ich stimme dir zu.',null);
Insert into BOOSTL.PHRASES (PHRASE_ID,TGERMAN,TENGLISH,WORD_ID) values ('2','It is a proven fact that','Es ist eine bewiesene Tatsache, dass','6');
REM INSERTING into BOOSTL.REQUESTS
SET DEFINE OFF;
REM INSERTING into BOOSTL.UNITS
SET DEFINE OFF;
Insert into BOOSTL.UNITS (UNIT_ID,DESCRIPTION,CREATOR) values ('1','Agreeing','3');
Insert into BOOSTL.UNITS (UNIT_ID,DESCRIPTION,CREATOR) values ('2','Animals','3');
REM INSERTING into BOOSTL.USERS
SET DEFINE OFF;
Insert into BOOSTL.USERS (USER_ID,USERNAME,PASSWORD,ROLE) values ('1','Herbot','herbot','0');
Insert into BOOSTL.USERS (USER_ID,USERNAME,PASSWORD,ROLE) values ('2','Sunny','sunny','0');
Insert into BOOSTL.USERS (USER_ID,USERNAME,PASSWORD,ROLE) values ('3','Pascal','pascal','0');
Insert into BOOSTL.USERS (USER_ID,USERNAME,PASSWORD,ROLE) values ('4','Marco','pascal','0');
REM INSERTING into BOOSTL.WORDBELONGS
SET DEFINE OFF;
Insert into BOOSTL.WORDBELONGS (WORD_ID,UNIT_ID) values ('1','1');
Insert into BOOSTL.WORDBELONGS (WORD_ID,UNIT_ID) values ('2','1');
Insert into BOOSTL.WORDBELONGS (WORD_ID,UNIT_ID) values ('3','1');
REM INSERTING into BOOSTL.WORDS
SET DEFINE OFF;
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('1','Dog','Hund',null,'Noun','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('2','Cat','Katze',null,'Noun','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('3','Bird','Vogel',null,'Noun','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('4','proof','Beweis',null,'Noun','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('5','House','Haus',null,'Noun','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('6','People','Leute, Menschen',null,'Noun (P)','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('7','proven','bewiesen',null,'Adjective','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('8','pretty','h�bsch',null,'Adjective','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('9','delightful','entz�ckend',null,'Adjective','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('10','pretty','ziemlich',null,'Adverb','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('11','prove','beweisen',null,'Verb','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('12','know','wissen',null,'Verb','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('13','start','starten',null,'Verb','common');
Insert into BOOSTL.WORDS (WORD_ID,TGERMAN,TENGLISH,VARIETY,POS,USAGE) values ('14','stop','stoppen',null,'Verb','common');
--------------------------------------------------------
--  DDL for Index PK_BELONGSTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_BELONGSTO" ON "BOOSTL"."BELONGSTO" ("USER_ID", "TEACHER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_OWNSPHRASE
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_OWNSPHRASE" ON "BOOSTL"."OWNSPHRASE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_OWNSWORD
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_OWNSWORD" ON "BOOSTL"."OWNSWORD" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PHRASEBELONGS
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_PHRASEBELONGS" ON "BOOSTL"."PHRASEBELONGS" ("PHRASE_ID", "UNIT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PHRASES
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_PHRASES" ON "BOOSTL"."PHRASES" ("PHRASE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_REQUESTS
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_REQUESTS" ON "BOOSTL"."REQUESTS" ("REQ_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_UNITS
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_UNITS" ON "BOOSTL"."UNITS" ("UNIT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_USERS
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_USERS" ON "BOOSTL"."USERS" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_WORDBELONGS
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_WORDBELONGS" ON "BOOSTL"."WORDBELONGS" ("WORD_ID", "UNIT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_WORDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOSTL"."PK_WORDS" ON "BOOSTL"."WORDS" ("WORD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BELONGSTO
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."BELONGSTO" ADD CONSTRAINT "PK_BELONGSTO" PRIMARY KEY ("USER_ID", "TEACHER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table OWNSPHRASE
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."OWNSPHRASE" ADD CONSTRAINT "PK_OWNSPHRASE" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table OWNSWORD
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."OWNSWORD" ADD CONSTRAINT "PK_OWNSWORD" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PHRASEBELONGS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."PHRASEBELONGS" ADD CONSTRAINT "PK_PHRASEBELONGS" PRIMARY KEY ("PHRASE_ID", "UNIT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PHRASES
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."PHRASES" ADD CONSTRAINT "PK_PHRASES" PRIMARY KEY ("PHRASE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REQUESTS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."REQUESTS" ADD CONSTRAINT "PK_REQUESTS" PRIMARY KEY ("REQ_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table UNITS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."UNITS" ADD CONSTRAINT "PK_UNITS" PRIMARY KEY ("UNIT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."USERS" ADD CONSTRAINT "PK_USERS" PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table WORDBELONGS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."WORDBELONGS" ADD CONSTRAINT "PK_WORDBELONGS" PRIMARY KEY ("WORD_ID", "UNIT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table WORDS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."WORDS" ADD CONSTRAINT "PK_WORDS" PRIMARY KEY ("WORD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BELONGSTO
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."BELONGSTO" ADD CONSTRAINT "FK_BELONGSTOTEACHER" FOREIGN KEY ("TEACHER_ID")
	  REFERENCES "BOOSTL"."USERS" ("USER_ID") ENABLE;
 
  ALTER TABLE "BOOSTL"."BELONGSTO" ADD CONSTRAINT "FK_BELONGSTOUSER" FOREIGN KEY ("USER_ID")
	  REFERENCES "BOOSTL"."USERS" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OWNSPHRASE
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."OWNSPHRASE" ADD CONSTRAINT "FK_OWNSPHRASEPHRASE" FOREIGN KEY ("PHRASE_ID")
	  REFERENCES "BOOSTL"."PHRASES" ("PHRASE_ID") ENABLE;
 
  ALTER TABLE "BOOSTL"."OWNSPHRASE" ADD CONSTRAINT "FK_OWNSPHRASEUSER" FOREIGN KEY ("USER_ID")
	  REFERENCES "BOOSTL"."USERS" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OWNSWORD
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."OWNSWORD" ADD CONSTRAINT "FK_OWNSWORDUSER" FOREIGN KEY ("USER_ID")
	  REFERENCES "BOOSTL"."USERS" ("USER_ID") ENABLE;
 
  ALTER TABLE "BOOSTL"."OWNSWORD" ADD CONSTRAINT "FK_OWNSWORDWORD" FOREIGN KEY ("WORD_ID")
	  REFERENCES "BOOSTL"."WORDS" ("WORD_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PHRASEBELONGS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."PHRASEBELONGS" ADD CONSTRAINT "FK_PHRASEBELONGSPHRASE" FOREIGN KEY ("PHRASE_ID")
	  REFERENCES "BOOSTL"."PHRASES" ("PHRASE_ID") ENABLE;
 
  ALTER TABLE "BOOSTL"."PHRASEBELONGS" ADD CONSTRAINT "FK_PHRASEBELONGSUNIT" FOREIGN KEY ("UNIT_ID")
	  REFERENCES "BOOSTL"."UNITS" ("UNIT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PHRASES
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."PHRASES" ADD CONSTRAINT "FK_PHRASESWORD" FOREIGN KEY ("WORD_ID")
	  REFERENCES "BOOSTL"."WORDS" ("WORD_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REQUESTS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."REQUESTS" ADD CONSTRAINT "FK_REQUESTS" FOREIGN KEY ("USER_ID")
	  REFERENCES "BOOSTL"."USERS" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table UNITS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."UNITS" ADD CONSTRAINT "FK_UNITS" FOREIGN KEY ("CREATOR")
	  REFERENCES "BOOSTL"."USERS" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WORDBELONGS
--------------------------------------------------------

  ALTER TABLE "BOOSTL"."WORDBELONGS" ADD CONSTRAINT "FK_WORDBELONGSUNIT" FOREIGN KEY ("UNIT_ID")
	  REFERENCES "BOOSTL"."UNITS" ("UNIT_ID") ENABLE;
 
  ALTER TABLE "BOOSTL"."WORDBELONGS" ADD CONSTRAINT "FK_WORDBELONGSWORD" FOREIGN KEY ("WORD_ID")
	  REFERENCES "BOOSTL"."WORDS" ("WORD_ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRI_SAVE_STATISTIC_PHRASE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOOSTL"."TRI_SAVE_STATISTIC_PHRASE" 
BEFORE UPDATE ON OWNSPHRASE 
BEGIN
  NULL;
END;
/
ALTER TRIGGER "BOOSTL"."TRI_SAVE_STATISTIC_PHRASE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRI_SAVE_STATISTIC_WORD
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOOSTL"."TRI_SAVE_STATISTIC_WORD" 
BEFORE UPDATE ON OWNSWORD 
BEGIN
  NULL;
END;
/
ALTER TRIGGER "BOOSTL"."TRI_SAVE_STATISTIC_WORD" ENABLE;
