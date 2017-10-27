DROP TABLE Requests CASCADE CONSTRAINTS;
DROP TABLE Users CASCADE CONSTRAINTS;
DROP TABLE belongsTo CASCADE CONSTRAINTS;
DROP TABLE Units CASCADE CONSTRAINTS;
DROP TABLE Words CASCADE CONSTRAINTS;
DROP TABLE Phrases CASCADE CONSTRAINTS;
DROP TABLE ownsWord CASCADE CONSTRAINTS;
DROP TABLE ownsPhrase CASCADE CONSTRAINTS;
DROP TABLE wordBelongs CASCADE CONSTRAINTS;
DROP TABLE phraseBelongs CASCADE CONSTRAINTS;


CREATE TABLE Requests(
	req_id 		INTEGER,
	req_date 	DATE,
	edit_date	DATE,
	status		VARCHAR2(20),
	user_id		INTEGER,
	
	CONSTRAINT pk_Requests PRIMARY KEY (req_id),
	CONSTRAINT fk_Requests FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Users(
	user_id 	INTEGER,
	username 	VARCHAR2(30),
	password	VARCHAR2(15),
	role		INTEGER,
);

CREATE TABLE belongsTo(
	user_id 	INTEGER,
	teacher_id 	INTEGER,
	
	CONSTRAINT pk_BelongsTo PRIMARY KEY (user_id, teacher_id),
	CONSTRAINT fk_BelongsToUser FOREIGN KEY (user_id) REFERENCES Users(user_id),
	CONSTRAINT fk_BelongsToTeacher FOREIGN KEY (teacher_id) REFERENCES Users(user_id),
);

CREATE TABLE Units(
	unit_id 	INTEGER,
	description VARCHAR2(80),
	creator		INTEGER,

	CONSTRAINT pk_Units PRIMARY KEY (unit_id),
	CONSTRAINT fk_Units FOREIGN KEY (creator) REFERENCES Users(user_id)
);

CREATE TABLE Words(
	word_id 	INTEGER,
	tGerman 	VARCHAR2(40),
	tEnglish	VARCHAR2(40),
	variety		VARCHAR2(10),
	poS			VARCHAR2(10),
	usage		VARCHAR2(40),
	
	CONSTRAINT pk_Words PRIMARY KEY (word_id)
);

CREATE TABLE Phrases(
	phrase_id 	INTEGER,
	tGerman 	VARCHAR2(40),
	tEnglish	VARCHAR2(40),
	word_id 	INTEGER,
	
	CONSTRAINT pk_Phrases PRIMARY KEY (phrase_id),
	CONSTRAINT fk_PhrasesWord FOREIGN KEY (word_id) REFERENCES Word(word_id)
);

CREATE TABLE ownsWord(
	id			INTEGER,
	user_id		INTEGER,
	word_id		INTEGER,
	lastRevised	DATE,
	accuracy	FLOAT,
	
	CONSTRAINT pk_OwnsWord PRIMARY KEY (id),
	CONSTRAINT fk_OwnsWordUser FOREIGN KEY (user_id) REFERENCES Users(user_id),
	CONSTRAINT fk_OwnsWordWord FOREIGN KEY (word_id) REFERENCES Word(word_id),
);

CREATE TABLE ownsPhrase(
	id			INTEGER,
	user_id		INTEGER,
	phrase_id	INTEGER,
	lastRevised	DATE,
	accuracy	FLOAT,
	
	CONSTRAINT pk_OwnsPhrase PRIMARY KEY (id),
	CONSTRAINT fk_OwnsPhraseUser FOREIGN KEY (user_id) REFERENCES Users(user_id),
	CONSTRAINT fk_OwnsPhrasePhrase FOREIGN KEY (phrase_id) REFERENCES Phrases(word_id)
);

CREATE TABLE wordBelongs(
	word_id		INTEGER,
	unit_id		INTEGER,
	
	CONSTRAINT pk_WordBelongs PRIMARY KEY (word_id, unit_id),
	CONSTRAINT fk_WordBelongsWord FOREIGN KEY (word_id) REFERENCES Words(word_id),
	CONSTRAINT fk_WordBelongsUnit FOREIGN KEY (unit_id) REFERENCES Unit(unit_id)
);

CREATE TABLE phraseBelongs(
	phrase_id	INTEGER,
	unit_id		INTEGER,
	
	CONSTRAINT pk_PhraseBelongs PRIMARY KEY (phrase_id, unit_id),
	CONSTRAINT fk_PhraseBelongsPhrase FOREIGN KEY (phrase_id) REFERENCES Phrases(phrase_id),
	CONSTRAINT fk_PhraseBelongsUnit FOREIGN KEY (unit_id) REFERENCES Unit(unit_id)
);