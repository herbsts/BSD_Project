DELETE FROM Users;
DELETE FROM Words;
DELETE FROM Phrases;
DELETE FROM Units;
DELETE FROM wordBelongs;
DELETE FROM phraseBelongs;
DELETE FROM ownsWord;
DELETE FROM ownsPhrase;


INSERT INTO Users VALUES(SEQ_USERID.nextVal, 'Herbot', 'herbot', 0);
INSERT INTO Users VALUES(SEQ_USERID.nextVal, 'Sunny', 'sunny', 0);
INSERT INTO Users VALUES(SEQ_USERID.nextVal, 'Pascal', 'pascal', 0);
INSERT INTO Users VALUES(SEQ_USERID.nextVal, 'Marco', 'pascal', 0);


INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'Dog', 'Hund', 'Noun', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'Cat', 'Katze', 'Noun', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'Bird', 'Vogel', 'Noun', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'proof', 'Beweis', 'Noun', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'House', 'Haus', 'Noun', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'People', 'Leute, Menschen', 'Noun (P)', 'common');

INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'proven', 'bewiesen', 'Adjective', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'pretty', 'hübsch', 'Adjective', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'delightful', 'entzückend', 'Adjective', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'pretty', 'ziemlich', 'Adverb', 'common');

INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'prove', 'beweisen', 'Verb', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'know', 'wissen', 'Verb', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'start', 'starten', 'Verb', 'common');
INSERT INTO Words (word_id, tGerman, tEnglish, poS, usage) VALUES(SEQ_WORDS.nextVal, 'stop', 'stoppen', 'Verb', 'common');

INSERT INTO Phrases (phrase_id, tGerman, tEnglish) VALUES(SEQ_PHRASES.nextVal, 'I agree with you.', 'Ich stimme dir zu.');
INSERT INTO Phrases (phrase_id, tGerman, tEnglish, word_id) VALUES(SEQ_PHRASES.nextVal, 'It is a proven fact that', 'Es ist eine bewiesene Tatsache, dass', 6);

INSERT INTO Units VALUES(SEQ_UNITS.nextVal, 'Animals', 3);
INSERT INTO Units VALUES(SEQ_UNITS.nextVal, 'Agreeing', 3);


INSERT INTO wordBelongs VALUES(1, 1);
INSERT INTO wordBelongs VALUES(2, 1);
INSERT INTO wordBelongs VALUES(3, 1);


INSERT INTO phraseBelongs VALUES(2, 1);
INSERT INTO phraseBelongs VALUES(2, 2);


INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 1, 1, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 1, 2, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 1, 3, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 1, 4, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 1, 5, SYSDATE, 0);

INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 2, 6, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 2, 7, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 2, 8, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 2, 9, SYSDATE, 0);

INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 3, 10, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 3, 11, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 3, 12, SYSDATE, 0);
INSERT INTO ownsWord VALUES(SEQ_OWNSWORD.nextVal, 3, 13, SYSDATE, 0);

INSERT INTO ownsPhrase VALUES(SEQ_OWNSPHRASE.nextVal, 2, 1, SYSDATE, 0);
INSERT INTO ownsPhrase VALUES(SEQ_OWNSPHRASE.nextVal, 2, 2, SYSDATE, 0);
