INSERT INTO Users VALUES(SEQ_USERID.nextVal, 'Herbot', 'herbot', 0);
INSERT INTO Users VALUES(SEQ_USERID.nextVal, 'Sunny', 'sunny', 0);
INSERT INTO Users VALUES(SEQ_USERID.nextVal, 'Pascal', 'pascal', 0);


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

INSERT INTO Phrases (phrase_id, tGerman, tEnglish, word_id) VALUES(SEQ_PHRASES.nextVal, 'I agree with you.', 'Ich stimme dir zu.');
INSERT INTO Phrases (phrase_id, tGerman, tEnglish, word_id) VALUES(SEQ_PHRASES.nextVal, 'It is a proven fact that', 'Es ist eine bewiesene Tatsache, dass', 6);

INSERT INTO Units VALUES(SEQ_UNITS.nextVal, 'Animals', 3);
INSERT INTO Units VALUES(SEQ_UNITS.nextVal, 'Long time not revised', 3);


INSERT INTO wordBelongs VALUES(1, 1);
INSERT INTO wordBelongs VALUES(2, 1);
INSERT INTO wordBelongs VALUES(3, 1);

INSERT INTO phraseBelongs VALUES()