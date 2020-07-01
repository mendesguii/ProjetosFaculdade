CREATE TABLE `armazem` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `endereco` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefone` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefone` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `partNumber` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `descricao` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `unidadeDeMedida` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idFornecedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `movimentacao` (
  `id` int(11) NOT NULL,
  `idItem` int(11) DEFAULT NULL,
  `idArmazem` int(11) DEFAULT NULL,
  `quantidade` float DEFAULT NULL,
  `preco` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


ALTER TABLE `armazem`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idFornecedor` (`idFornecedor`);

ALTER TABLE `movimentacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idItem` (`idItem`),
  ADD KEY `idArmazem` (`idArmazem`);


ALTER TABLE `armazem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `movimentacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `item_ibfk_2` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`id`);

ALTER TABLE `movimentacao`
  ADD CONSTRAINT `movimentacao_ibfk_1` FOREIGN KEY (`idItem`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `movimentacao_ibfk_2` FOREIGN KEY (`idArmazem`) REFERENCES `armazem` (`id`);
