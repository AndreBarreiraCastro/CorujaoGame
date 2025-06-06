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


-- Tocantins
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Palmas', 'PMW', 1);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Paraíso do Tocantins', 'PDT', 1);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Gurupi', 'GRP', 1);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Araguaína', 'ARA', 1);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Porto Nacional', 'PNC', 1);

-- São Paulo
insert into municipio (nome, sigla, estadoMunicipio_id) values ('São Paulo', 'SP', 2);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Campinas', 'CPQ', 2);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Santos', 'STS', 2);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Sorocaba', 'SRC', 2);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Ribeirão Preto', 'RP', 2);

-- Rio de Janeiro
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Rio de Janeiro', 'RJ', 3);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Niterói', 'NIT', 3);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Nova Iguaçu', 'NI', 3);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Duque de Caxias', 'DC', 3);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Campos dos Goytacazes', 'CG', 3);

-- Minas Gerais
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Belo Horizonte', 'BH', 4);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Uberlândia', 'UBL', 4);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Juiz de Fora', 'JF', 4);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Contagem', 'CTG', 4);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Betim', 'BTM', 4);

-- Bahia
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Salvador', 'SSA', 5);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Feira de Santana', 'FS', 5);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Vitória da Conquista', 'VC', 5);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Camaçari', 'CMC', 5);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Itabuna', 'ITB', 5);

-- Paraná
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Curitiba', 'CTBA', 6);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Londrina', 'LDA', 6);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Maringá', 'MGA', 6);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Ponta Grossa', 'PG', 6);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Foz do Iguaçu', 'FI', 6);

-- Rio Grande do Sul
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Porto Alegre', 'POA', 7);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Caxias do Sul', 'CS', 7);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Pelotas', 'PTS', 7);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Santa Maria', 'SM', 7);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Novo Hamburgo', 'NH', 7);

-- Pernambuco
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Recife', 'REC', 8);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Olinda', 'OLD', 8);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Caruaru', 'CRU', 8);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Petrolina', 'PET', 8);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Jaboatão', 'JAB', 8);

-- Ceará
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Fortaleza', 'FOR', 9);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Juazeiro do Norte', 'JN', 9);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Sobral', 'SBL', 9);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Maracanaú', 'MCN', 9);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Caucaia', 'CCA', 9);

-- Pará
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Belém', 'BEL', 10);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Ananindeua', 'ANA', 10);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Santarém', 'STM', 10);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Marabá', 'MAR', 10);
insert into municipio (nome, sigla, estadoMunicipio_id) values ('Parauapebas', 'PRP', 10);


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

INSERT INTO perfil (id, label) VALUES (1, 'Adm');
INSERT INTO perfil (id, label) VALUES (2, 'User');

INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('André', 'Barreira de Castro', '63985139583', '02641728176', 'andrghoul18@gmail', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Lucas', 'Silva Santos', '11987654321', '12345678901', 'lucas.silva@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Maria', 'Oliveira Lima', '21998765432', '23456789012', 'maria.oliveira@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('João', 'Souza Pereira', '31987654321', '34567890123', 'joao.souza@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Ana', 'Costa Almeida', '41987654321', '45678901234', 'ana.costa@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Carlos', 'Ferreira Santos', '51987654321', '56789012345', 'carlos.ferreira@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Patrícia', 'Rodrigues Souza', '61987654321', '67890123456', 'patricia.rodrigues@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Felipe', 'Almeida Costa', '71987654321', '78901234567', 'felipe.almeida@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Fernanda', 'Lima Silva', '81987654321', '89012345678', 'fernanda.lima@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Gabriel', 'Santos Pereira', '91987654321', '90123456789', 'gabriel.santos@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Juliana', 'Souza Oliveira', '11912345678', '11223344556', 'juliana.souza@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Ricardo', 'Pereira Lima', '21912345678', '22334455667', 'ricardo.pereira@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Tatiane', 'Costa Silva', '31912345678', '33445566778', 'tatiane.costa@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Eduardo', 'Almeida Souza', '41912345678', '44556677889', 'eduardo.almeida@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Beatriz', 'Ferreira Santos', '51912345678', '55667788990', 'beatriz.ferreira@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Vinícius', 'Rodrigues Lima', '61912345678', '66778899001', 'vinicius.rodrigues@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Larissa', 'Souza Almeida', '71912345678', '77889900112', 'larissa.souza@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Marcelo', 'Oliveira Silva', '81912345678', '88990011223', 'marcelo.oliveira@example.com', 2);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Aline', 'Pereira Costa', '91912345678', '99001122334', 'aline.pereira@example.com', 1);
INSERT INTO usuario (nome, sobrenome, telefone, cpf, email, perfilusuario_id) VALUES ('Rafael', 'Santos Almeida', '11987651234', '10111213141', 'rafael.santos@example.com', 2);
