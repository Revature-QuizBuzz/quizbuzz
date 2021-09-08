-- DROP SCHEMA quizbuzz;

CREATE SCHEMA quizbuzz AUTHORIZATION postgres;

-- quizbuzz.answers_answer_id_seq definition

-- DROP SEQUENCE quizbuzz.answers_answer_id_seq;

CREATE SEQUENCE quizbuzz.answers_answer_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.questions_question_id_seq definition

-- DROP SEQUENCE quizbuzz.questions_question_id_seq;

CREATE SEQUENCE quizbuzz.questions_question_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.quizzes_quiz_id_seq definition

-- DROP SEQUENCE quizbuzz.quizzes_quiz_id_seq;

CREATE SEQUENCE quizbuzz.quizzes_quiz_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.tags_tag_id_seq definition

-- DROP SEQUENCE quizbuzz.tags_tag_id_seq;

CREATE SEQUENCE quizbuzz.tags_tag_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.user_scores_score_id_seq definition

-- DROP SEQUENCE quizbuzz.user_scores_score_id_seq;

CREATE SEQUENCE quizbuzz.user_scores_score_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.users_user_id_seq definition

-- DROP SEQUENCE quizbuzz.users_user_id_seq;

CREATE SEQUENCE quizbuzz.users_user_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
	
	
-- quizbuzz.answers definition

-- Drop table

-- DROP TABLE quizbuzz.answers;

CREATE TABLE quizbuzz.answers (
	answer_id serial NOT NULL,
	question_id int4 NOT NULL,
	answer varchar(200) NOT NULL,
	correct bool NOT NULL,
	CONSTRAINT answers_pk PRIMARY KEY (answer_id)
);


-- quizbuzz.questions definition

-- Drop table

-- DROP TABLE quizbuzz.questions;

CREATE TABLE quizbuzz.questions (
	question_id serial NOT NULL,
	quiz_id int4 NOT NULL,
	question varchar(200) NOT NULL,
	possible_points float4 NOT NULL,
	CONSTRAINT questions_pk PRIMARY KEY (question_id)
);


-- quizbuzz.quiz_tags definition

-- Drop table

-- DROP TABLE quizbuzz.quiz_tags;

CREATE TABLE quizbuzz.quiz_tags (
	tag_id int4 NOT NULL,
	quiz_id int4 NOT NULL,
	CONSTRAINT quiz_tags_pk PRIMARY KEY (tag_id)
);


-- quizbuzz.quizzes definition

-- Drop table

-- DROP TABLE quizbuzz.quizzes;

CREATE TABLE quizbuzz.quizzes (
	quiz_id serial NOT NULL,
	user_id int4 NOT NULL,
	"name" varchar(15) NOT NULL,
	description text NULL,
	total_score int4 NOT NULL,
	CONSTRAINT quizzes_pk PRIMARY KEY (quiz_id)
);


-- quizbuzz.tags definition

-- Drop table

-- DROP TABLE quizbuzz.tags;

CREATE TABLE quizbuzz.tags (
	tag_id serial NOT NULL,
	"name" varchar(30) NOT NULL,
	CONSTRAINT tags_pk PRIMARY KEY (tag_id)
);


-- quizbuzz.user_scores definition

-- Drop table

-- DROP TABLE quizbuzz.user_scores;

CREATE TABLE quizbuzz.user_scores (
	score_id serial NOT NULL,
	quiz_id int4 NOT NULL,
	user_id int4 NOT NULL,
	user_score int4 NOT NULL,
	CONSTRAINT user_scores_pk PRIMARY KEY (score_id)
);


-- quizbuzz.users definition

-- Drop table

-- DROP TABLE quizbuzz.users;

CREATE TABLE quizbuzz.users (
	user_id serial NOT NULL,
	username varchar(20) NOT NULL,
	"password" varchar(50) NOT NULL,
	f_name varchar(40) NOT NULL,
	l_name varchar(40) NOT NULL,
	total_points int4 NOT NULL DEFAULT 0,
	CONSTRAINT users_pk PRIMARY KEY (user_id)
);

-- quizbuzz.user_scores foreign keys

ALTER TABLE quizbuzz.user_scores ADD CONSTRAINT user_scores_fk FOREIGN KEY (user_id) REFERENCES quizbuzz.users(user_id);
ALTER TABLE quizbuzz.user_scores ADD CONSTRAINT user_scores_fk_1 FOREIGN KEY (quiz_id) REFERENCES quizbuzz.quizzes(quiz_id);

-- quizbuzz.quizzes foreign keys

ALTER TABLE quizbuzz.quizzes ADD CONSTRAINT quizzes_fk FOREIGN KEY (user_id) REFERENCES quizbuzz.users(user_id);

-- quizbuzz.quiz_tags foreign keys

ALTER TABLE quizbuzz.quiz_tags ADD CONSTRAINT quiz_tags_fk FOREIGN KEY (quiz_id) REFERENCES quizbuzz.quizzes(quiz_id);
ALTER TABLE quizbuzz.quiz_tags ADD CONSTRAINT quiz_tags_fk_2 FOREIGN KEY (tag_id) REFERENCES quizbuzz.tags(tag_id);

-- quizbuzz.questions foreign keys

ALTER TABLE quizbuzz.questions ADD CONSTRAINT questions_fk FOREIGN KEY (quiz_id) REFERENCES quizbuzz.quizzes(quiz_id);

-- quizbuzz.answers foreign keys

ALTER TABLE quizbuzz.answers ADD CONSTRAINT answers_fk FOREIGN KEY (question_id) REFERENCES quizbuzz.questions(question_id);



ALTER TABLE quizbuzz.user_scores ADD completed_on timestamp NOT NULL;
ALTER TABLE quizbuzz.quizzes ADD created_date timestamp NOT NULL;
ALTER TABLE quizbuzz.quizzes ADD date_modified timestamp NULL;
ALTER TABLE quizbuzz.questions ADD question_type varchar(30) NOT NULL;

