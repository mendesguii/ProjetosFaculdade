-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 23-Nov-2019 às 15:32
-- Versão do servidor: 8.0.13-4
-- versão do PHP: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jwrrWpsA7f`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome`, `email`, `senha`) VALUES
(2, 'Guilherme Mendes', 'guilhermemendes789@gmail.com', '123456'),
(3, 'teste', 'teste', 'a1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `email`
--

CREATE TABLE `email` (
  `id_email` int(11) NOT NULL,
  `id_cliente_destino` int(11) DEFAULT NULL,
  `id_cliente_origem` int(11) DEFAULT NULL,
  `id_mensagem` int(11) DEFAULT NULL,
  `data_envio` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `email`
--

INSERT INTO `email` (`id_email`, `id_cliente_destino`, `id_cliente_origem`, `id_mensagem`, `data_envio`) VALUES
(2, 2, 3, 16, '2019-11-22 22:56:11'),
(3, 3, 3, 17, '2019-11-22 23:45:53'),
(4, 3, 3, 18, '2019-11-22 23:46:14'),
(5, 3, 3, 19, '2019-11-22 23:56:00'),
(6, 3, 3, 20, '2019-11-23 00:22:07'),
(7, 2, 2, 21, '2019-11-23 00:25:00'),
(8, 3, 3, 22, '2019-11-23 06:33:24'),
(9, 3, 3, 23, '2019-11-23 14:28:09'),
(10, 2, 3, 24, '2019-11-23 14:40:11'),
(11, 3, 3, 25, '2019-11-23 15:29:06');

-- --------------------------------------------------------

--
-- Estrutura da tabela `mensagem`
--

CREATE TABLE `mensagem` (
  `id_mensagem` int(11) NOT NULL,
  `assunto` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mensagem` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `mensagem`
--

INSERT INTO `mensagem` (`id_mensagem`, `assunto`, `mensagem`) VALUES
(16, 'EmailTeste', 'esse é o email teste'),
(17, 'teste', 'teste'),
(19, 'Assunto', 'Texto do corpo'),
(21, 'Outro email', 'asijdiasjdiasjdaisdjas'),
(22, 'toppsss', 'QUeh daskl'),
(24, 'Demonstrativos de Pagamento', 'Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, \ne vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja \nde tipos.'),
(25, 'ushdiuashduiashdhasdhas', 'iuhduiashduiashiudhasuidhasasdasd\nsa\ndsa\nd\nas\nd\nasd\nsa\nd\nas\nd\nas\ndas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`id_email`);

--
-- Indexes for table `mensagem`
--
ALTER TABLE `mensagem`
  ADD PRIMARY KEY (`id_mensagem`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `id_email` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `mensagem`
--
ALTER TABLE `mensagem`
  MODIFY `id_mensagem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
