CREATE TABLE tb_pedido (
	idPedido INT PRIMARY KEY,
	numeroMesa INT NOT NULL,
	status VARCHAR(20) NOT NULL,
	observacao VARCHAR(50) NOT NULL
);
CREATE SEQUENCE idPedido MINVALUE 1 START WITH 1;



CREATE TABLE tb_produto (
    idProduto INT PRIMARY KEY,
    nomeProduto VARCHAR(50) NOT NULL,
    preco NUMBER NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    descricao VARCHAR(100)
);
CREATE SEQUENCE idProduto MINVALUE 1 START WITH 1;



CREATE TABLE tb_funcionario (
	id INT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(14),
	telefone VARCHAR(12),
	cargo VARCHAR(50),
	salario NUMBER,
	dataNascimento DATE,
	rua VARCHAR(50),
	numero NUMBER,
	cep VARCHAR(50),
	estado VARCHAR(15),
	complemento VARCHAR(50),
	bairro VARCHAR(50),
	cidade VARCHAR(50),
	pontoReferencia VARCHAR(50)
);
CREATE SEQUENCE idFuncionario MINVALUE 1 START WITH 1;