INSERT INTO USER_MODEL(name, email, password) VALUES('Aluno', 'aluno@email.com', '123456');

INSERT INTO COURSE_MODEL(name, category) VALUES('Spring Boot', 'Programação');
INSERT INTO COURSE_MODEL(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPIC_MODEL(title, message, create_date, status, author_id, course_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPIC_MODEL(title, message, create_date, status, author_id, course_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPIC_MODEL(title, message, create_date, status, author_id, course_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);