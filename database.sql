--makes it so that anyone can copy and paste into their db no matter 
--if they already have the db made

DROP SCHEMA IF EXISTS quizbuzz CASCADE;

CREATE SCHEMA quizbuzz AUTHORIZATION postgres;


-- DROP SCHEMA quizbuzz;

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
	quiz_tag_id serial NOT null,
	tag_id int4 NOT NULL,
	quiz_id int4 NOT NULL,
	CONSTRAINT quiz_tags_pk PRIMARY KEY (quiz_tag_id)
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

-- quizbuzz.answers_answer_id_seq definition

-- DROP SEQUENCE quizbuzz.answers_answer_id_seq;

ALTER SEQUENCE quizbuzz.answers_answer_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.questions_question_id_seq definition

-- DROP SEQUENCE quizbuzz.questions_question_id_seq;

ALTER SEQUENCE quizbuzz.questions_question_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.quizzes_quiz_id_seq definition

-- DROP SEQUENCE quizbuzz.quizzes_quiz_id_seq;

ALTER SEQUENCE quizbuzz.quizzes_quiz_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.tags_tag_id_seq definition

-- DROP SEQUENCE quizbuzz.tags_tag_id_seq;

ALTER SEQUENCE quizbuzz.tags_tag_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- quizbuzz.user_scores_score_id_seq definition

-- DROP SEQUENCE quizbuzz.user_scores_score_id_seq;

ALTER SEQUENCE quizbuzz.user_scores_score_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- quizbuzz.users_user_id_seq definition

-- DROP SEQUENCE quizbuzz.users_user_id_seq;

ALTER SEQUENCE quizbuzz.users_user_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
	
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
	 ('admin', '1234', 'Monty', 'Java',0,0,0),
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
	 ('Arithmetic'),
	 ('Basic Concepts');
	 
INSERT INTO quizbuzz.quizzes (user_id,"name",description,total_score,created_date,date_modified) VALUES
	 (1,'Test Quiz','A Quiz to test the system',100,'2021-09-08 13:25:16.142367',NULL),
	 (3,'Quiz A','A Quiz A to test the system',80,'2021-09-08 13:25:16.142367',NULL),
	 (3,'Sample Quiz','A Sample Quiz to test the system',120,'2021-09-08 13:25:16.142367',NULL),
	 (2,'Java Quiz','A simple quiz on java concepts',100,'2020-10-10 8:15:16.142367',NULL),
	 (1,'Spring Quiz','A simple quiz about spring concepts',150,'2020-03-20 12:45:14.142367',NULL);

INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(1,1,100,'2021-09-08 13:26:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(1,2,40,'2021-09-10 13:30:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) values(2,1,70,'2021-09-08 13:26:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) values(3,1,90,'2021-09-08 13:26:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(4,4,124,'2021-10-10 16:20:45.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(3,4,90,'2021-10-12 18:10:35.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(3,5,100,'2021-10-12 18:10:35.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(4,5,140,'2021-10-13 10:00:15.194406');
INSERT INTO quizbuzz.user_scores (quiz_id,user_id,user_score,completed_on) VALUES(4,2,130,'2021-10-13 10:00:10.194406');

INSERT INTO quizbuzz.questions (quiz_id,question,possible_points,question_type) VALUES
	 (1,'What is your name?',1.0,'multiplechoice'),
	 (1,'What is your quest?',1.0,'multiplechoice'),
	 (1,'What is the airspeed velocity of an unladen swallow?',1.0,'multiplechoice'),
	 (2,'3+4=?',10.0,'multiplechoice'),
	 (2,'1+4=?',15.0,'multiplechoice'),
	 (2,'2+4=?',13.0,'multiplechoice'),
	 (3,'6+4=?',18.0,'multiplechoice'),
	 (3,'7+4=?',19.0,'multiplechoice'),
	 (3,'9+4=?',16.0,'multiplechoice'),
	 (4,'What is Java',25.0,'multiplechoice'),
	 (4,'What is the difference between a runtime error and a compilation error',25.0,'multiplechoice'),
	 (4,'Where are Strings stored in Java',25.0,'multiplechoice'),
	 (4,'How would you achieve abstraction in Java',25.0,'multiplechoice'),
	 (5,'What is IOC',75.0,'multiplechoice'),
	 (5,'What is not a Spring Data Annotation',75.0,'multiplechoice');
	 
INSERT INTO quizbuzz.answers (question_id,answer,correct) VALUES
	 (1,'Arthur, King of Britons',true),
	 (1,'Black Knight',false),
	 (1,'Monty Python',false),
	 (1,'The Rabbit',false),
	 (2,'To seek the Holy Grail',true),
	 (2,'To over throw the king',false),
	 (2, 'To deliver just a scratch', false),
	 (2, 'To insult someones mother', false),
	 (3,'African or European',true),
	 (3,'Red... no, Blue',false),
	 (3,'Blue.. no Pink',false),
	 (3,'European and Asian',false),
	 (4, '7', true),
	 (4, '8', false),
	 (4, '2', false),
	 (4, 'seven', false),
	 (5, '3', false),
	 (5, '5', true),
	 (5, '10', false),
	 (5, '1', false),
	 (6, '40', false),
	 (6, '5', false),
	 (6, '6', true),
	 (6, '5', false),
	 (7, '5', false),
	 (7, '13', false),
	 (7, '10', true),
	 (7, '-2', false),
	 (8, '50', false),
	 (8, '11', true),
	 (8, '5', false),
	 (8, '10', false),
	 (9, '24', false),
	 (9, '4', false),
	 (9, '9', false),
	 (9, '13', true),
	 (10, 'It is a widely used OOP scripting Language that is used to develop backend applications with servelts and spring', false),
	 (10, 'It is a widely used OOP programming language that runs on windows devices for application development', false),
	 (10, 'It is a widely used Scripting Language and software platfrom for developing front end applications', false),
	 (10, 'It is a widely used OOP programming Language and software platform that runs on billions of devices ', true),
	 (11, 'Runtime errors are generally referred to the error corresponding to syntax or semantics. Compile-time errors on the other hand refer to the error encountered during the execution of code at compile-time.', false),
	 (11, 'Compile-time errors are generally referred to the error corresponding to syntax or semantics. Runtime errors on the other hand refer to the error encountered during the execution of code at runtime.', true),
	 (11, 'Compile-time errors are generally referred to the error corresponding faulty logic in code. Runtime errors on the other hand refer to the error encountered during the execution of code at runtime.', false),
	 (11, 'Compile-time errors refer to errors that are not handled by exceptions and runtime errors are errors that occur with faulty logic', false),
	 (12, 'String Heap', false),
	 (12, 'String Pool', true),
	 (12, 'String Basement', false),
	 (12, 'String Container', false),
	 (13, 'By attaching the Abstract keyword to methods and constructors', false),
	 (13, 'By using the abstract keyword for classes and interfaces.', true),
	 (13, 'By attaching the Abstract keyword to constructors and classes', false),
	 (13, 'By attaching the Abstract keyword to classes and projections', false),
	 (14, '@Id', false),
	 (14, '@Transient', false),
	 (14, '@Query', false),
	 (14, '@Entity', true);
	 
insert into quizbuzz.quiz_tags(tag_id, quiz_id) VALUES
(1, 1),
(2, 4),
(6, 2),
(4, 5),
(1, 3),
(7,4);