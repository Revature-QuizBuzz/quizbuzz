--makes it so that anyone can copy and paste into their db no matter 
--if they already have the db made

DROP SCHEMA IF EXISTS quizbuzz CASCADE;

CREATE SCHEMA quizbuzz AUTHORIZATION postgres;


-- DROP SCHEMA quizbuzz;

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
	tag_id serial UNIQUE NOT NULL ,
	"name" varchar(30) NOT NULL,
	CONSTRAINT tags_pk PRIMARY KEY (tag_id)
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
	total_possible_points int not null default 0,
	point_percentage decimal not null default 0,
	CONSTRAINT users_pk PRIMARY KEY (user_id)
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



CREATE or replace function update_total_scores()
returns trigger 
LANGUAGE plpgsql
AS $$
begin

UPDATE quizbuzz.users u
set total_points = total_points + user_score
FROM 
    quizbuzz.user_scores s
WHERE 
    u.user_id = s.user_id
and s.score_id = (select max(score_id) from quizbuzz.user_scores );


UPDATE quizbuzz.users u
set total_possible_points = total_possible_points + total_score
FROM 
    quizbuzz.user_scores s, quizbuzz.quizzes q
WHERE 
    u.user_id = s.user_id
and s.quiz_id = q.quiz_id
and s.score_id = (select max(score_id) from quizbuzz.user_scores );


UPDATE quizbuzz.users u
set point_percentage = ROUND(((u.total_points::decimal/ u.total_possible_points::decimal) * 100), 2)
from quizbuzz.user_scores us
where u.user_id = us.user_id;

return null;
end;
$$;



DROP TRIGGER IF exists update_score_on_insert on quizbuzz.user_scores;

create trigger update_score_on_insert after
insert
    on
    quizbuzz.user_scores for each row execute function update_total_scores();
   
  


INSERT INTO quizbuzz.users (username,"password",f_name,l_name,total_points, total_possible_points, point_percentage) VALUES
	 ('test','1234','test','tester',0,0,0),
	 ('red','red123','Crimson','Red',0,0,0),
	 ('orange','orange123','Clemintine','Orange',0,0,0),
	 ('yellow','yellow123','Sunflower','Yellow',0,0,0),
	 ('green','green123','Grass','Green',0,0,0);
	 
INSERT INTO quizbuzz.tags ("name") VALUES
	 ('Test Tag'),
	 ('Java'),
	 ('Angular'),
	 ('Spring Boot'),
	 ('Hibernate'),
	 ('Arithmetic');
	 
INSERT INTO quizbuzz.quizzes (user_id,"name",description,total_score,created_date,date_modified) VALUES
	 (1,'Test Quiz','A Quiz to test the system',100,'2021-09-08 13:25:16.142367',NULL),
	 (3,'Quiz A','A Quiz A to test the system',80,'2021-09-08 13:25:16.142367',NULL),
	 (3,'Sample Quiz','A Sample Quiz to test the system',120,'2021-09-08 13:25:16.142367',NULL);

INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(1,1,100,'2021-09-08 13:26:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(1,2,40,'2021-09-10 13:30:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) values(2,1,70,'2021-09-08 13:26:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) values(3,1,90,'2021-09-08 13:26:45.194406');


INSERT INTO quizbuzz.questions (quiz_id,question,possible_points,question_type) VALUES
	 (1,'What is your name?',1.0,'multiplechoice'),
	 (1,'What is your quest?',1.0,'multiplechoice'),
	 (1,'What is the airspeed velocity of an unladen swallow?',1.0,'multiplechoice'),
	 (2,'3+4=?',10.0,'multiplechoice'),
	 (2,'1+4=?',15.0,'multiplechoice'),
	 (2,'2+4=?',13.0,'multiplechoice'),
	 (3,'6+4=?',18.0,'multiplechoice'),
	 (3,'7+4=?',19.0,'multiplechoice'),
	 (3,'9+4=?',16.0,'multiplechoice');
	 
INSERT INTO quizbuzz.answers (question_id,answer,correct) VALUES
	 (1,'Arthur, King of Britons',true),
	 (1,'Black Knight',false),
	 (2,'To seek the Holy Grail',true),
	 (2,'To over throw the king',false),
	 (3,'African or European',true),
	 (3,'Red... no, Blue',false);
	 