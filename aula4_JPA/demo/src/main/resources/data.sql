CREATE TABLE usuario (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

INSERT INTO usuario (nome, email, senha) VALUES
('Admin', 'admin@email.com', '123456'),
('User', 'user@email.com', 'abcdef');
