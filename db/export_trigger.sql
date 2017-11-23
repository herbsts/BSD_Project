--------------------------------------------------------
--  Datei erstellt -Donnerstag-November-23-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger TRI_SAVE_STATISTIC_PHRASE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "D5B12"."TRI_SAVE_STATISTIC_PHRASE" 
BEFORE UPDATE ON OWNSPHRASE 
BEGIN
  NULL;
END;
/
ALTER TRIGGER "D5B12"."TRI_SAVE_STATISTIC_PHRASE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRI_SAVE_STATISTIC_WORD
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "D5B12"."TRI_SAVE_STATISTIC_WORD" 
BEFORE UPDATE ON OWNSWORD 
BEGIN
  NULL;
END;
/
ALTER TRIGGER "D5B12"."TRI_SAVE_STATISTIC_WORD" ENABLE;
