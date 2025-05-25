-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into estado ( nome, sigla) values ( 'Tocantins', 'TO');
insert into estado ( nome, sigla) values ( 'São Paulo', 'SP');
insert into estado ( nome, sigla) values ( 'Rio de Janeiro', 'RJ');
insert into estado ( nome, sigla) values ( 'Minas Gerais', 'MG');
insert into estado ( nome, sigla) values ( 'Bahia', 'BA');
insert into estado ( nome, sigla) values ( 'Paraná', 'PR');
insert into estado ( nome, sigla) values ( 'Rio Grande do Sul', 'RS');
insert into estado ( nome, sigla) values ( 'Pernambuco', 'PE');
insert into estado ( nome, sigla) values ( 'Ceará', 'CE');
insert into estado ( nome, sigla) values ( 'Pará', 'PA');


insert into municipio (nome, sigla, estadoMunicipio_id) values ( 'Palmas', 'PMW', 1);
insert into municipio (nome, sigla, estadoMunicipio_id) values ( 'Araguaína', 'ARA', 1);
insert into municipio ( nome, sigla, estadoMunicipio_id) values ( 'Gurupi', 'GRP', 1);
insert into municipio ( nome, sigla, estadoMunicipio_id) values ( 'Porto Nacional', 'PNC', 1);
insert into municipio ( nome, sigla, estadoMunicipio_id) values ( 'Paraíso do Tocantins', 'PDT', 1);


INSERT INTO generojogo (nome) VALUES ('FPS');
INSERT INTO generojogo (nome) VALUES ('RPG');
INSERT INTO generojogo (nome) VALUES ('Ação');
INSERT INTO generojogo (nome) VALUES ('Aventura');
INSERT INTO generojogo (nome) VALUES ('Esporte');
INSERT INTO generojogo (nome) VALUES ('Simulação');
INSERT INTO generojogo (nome) VALUES ('Estratégia');
INSERT INTO generojogo (nome) VALUES ('Puzzle');
INSERT INTO generojogo (nome) VALUES ('Corrida');
INSERT INTO generojogo (nome) VALUES ('Luta');
INSERT INTO generojogo (nome) VALUES ('Terror');
INSERT INTO generojogo (nome) VALUES ('MOBA');
INSERT INTO generojogo (nome) VALUES ('Battle Royale');
INSERT INTO generojogo (nome) VALUES ('Plataforma');
INSERT INTO generojogo (nome) VALUES ('Sandbox');


INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Call of Duty', 300, 1);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('The Witcher 3', 250, 2);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Devil May Cry', 180, 3);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Uncharted', 220, 4);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('FIFA 24', 500, 5);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('The Sims 4', 350, 6);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Civilization VI', 150, 7);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Tetris', 800, 8);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Forza Horizon 5', 400, 9);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Tekken 7', 270, 10);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Resident Evil Village', 320, 11);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('League of Legends', 1000, 12);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Fortnite', 1200, 13);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Super Mario Bros', 700, 14);
INSERT INTO jogo (nome, quantidade, jogoGenero_id) VALUES ('Minecraft', 1500, 15);

