--------------------------------------------------------
--  Datei erstellt -Donnerstag-November-23-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure PRO_LOG
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOOSTL"."PRO_LOG" 
(
  MESSAGE IN VARCHAR2 
) AS 
BEGIN
  INSERT INTO Log VALUES(MESSAGE, SYSDATE);
END PRO_LOG;

/
--------------------------------------------------------
--  DDL for Procedure PRO_SET_ACCURACY_PHRASES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOOSTL"."PRO_SET_ACCURACY_PHRASES" 
( days IN INTEGER DEFAULT 2,
  decrease IN INTEGER DEFAULT 5)
AS 
CURSOR cPhrases IS
    SELECT ID, LASTREVISED
    FROM OWNSPHRASE
    WHERE (trunc(SYSDATE) - trunc(lastrevised)) > days AND accuracy >= decrease;
BEGIN
  FOR phrase in cPhrases
   LOOP
      --UPDATE OWNSPHRASE SET accuracy = accuracy - decrease WHERE id = phrase.ID;
      PRO_LOG('decreased acc of phrase: ' || phrase.ID);
   END LOOP;
   commit;
END PRO_SET_ACCURACY_PHRASES;

/
--------------------------------------------------------
--  DDL for Procedure PRO_SET_ACCURACY_WORDS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOOSTL"."PRO_SET_ACCURACY_WORDS" 
( days IN INTEGER DEFAULT 2,
  decrease IN INTEGER DEFAULT 5)
AS 
CURSOR cWords IS
    SELECT ID, LASTREVISED
    FROM OWNSWORD
    WHERE (trunc(SYSDATE) - trunc(lastrevised)) > days AND accuracy >= decrease;
BEGIN  
  FOR word in cWords
   LOOP
      --UPDATE OWNSWORD SET accuracy = accuracy - decrease WHERE id = word.ID;
      PRO_LOG('decreased acc of word: ' || word.ID);
   END LOOP;
   commit;
END PRO_SET_ACCURACY_WORDS;

/
--------------------------------------------------------
--  DDL for Procedure PRO_SET_ACURACY_WORDS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOOSTL"."PRO_SET_ACURACY_WORDS" 
( days IN INTEGER DEFAULT 2,
  decrease IN INTEGER DEFAULT 5)
AS 
CURSOR cWords IS
    SELECT ID, LASTREVISED
    FROM OWNSWORD
    WHERE (trunc(SYSDATE) - trunc(lastrevised)) > days AND accuracy >= decrease;
BEGIN  
  FOR word in cWords
   LOOP
      --UPDATE OWNSWORD SET accuracy = accuracy - decrease WHERE id = word.ID;
      PRO_LOG('decreased acc of word: ' || word.ID);
   END LOOP;
   commit;
END PRO_SET_ACURACY_WORDS;

/
