CREATE TABLE produto (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          preco DOUBLE NOT NULL,
                          preco_final DOUBLE NOT NULL,
                          estoque INT NOT NULL
);

CREATE TABLE pessoa (
    id VARCHAR(36) PRIMARY KEY,
    nome_completo VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(11) NOT NULL
);
