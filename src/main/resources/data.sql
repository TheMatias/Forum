INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$/3ponM0jqFWHYy.3tMqq/.qfSe2MMFM1kI39pfGbQHDnQxmcnPgkK');

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);

INSERT INTO CONTATO(nome, numero, email) VALUES('Jose matias', '82987438460','matias@hotmail.com');
INSERT INTO CONTATO(nome, numero, email) VALUES('Thamiris Wevily', '82985857485','thamiris@gmail.com');
INSERT INTO CONTATO(nome, numero, email) VALUES('Amos matias', '82987455560','amos@hotmail.com');
INSERT INTO CONTATO(nome, numero, email) VALUES('Debora aurea', '82995857485','deba@gmail.com');

