-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24-Maio-2019 às 03:47
-- Versão do servidor: 10.1.39-MariaDB
-- versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bancounipaulistana`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `contas`
--

CREATE TABLE `contas` (
  `numerodaconta` int(11) NOT NULL,
  `senha` varchar(64) NOT NULL,
  `nomecompleto` varchar(128) NOT NULL,
  `saldo` double(16,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contas`
--

INSERT INTO `contas` (`numerodaconta`, `senha`, `nomecompleto`, `saldo`) VALUES
(1, '1234', 'Vitor Vasconcellos', 23212.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `previdencia`
--

CREATE TABLE `previdencia` (
  `id` int(11) NOT NULL,
  `titular` int(11) NOT NULL,
  `data_aquisicao` varchar(15) NOT NULL,
  `tempo_limite` int(2) NOT NULL,
  `id_plano` int(2) NOT NULL,
  `plano_ativo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `previdencia_planos`
--

CREATE TABLE `previdencia_planos` (
  `id` int(11) NOT NULL,
  `nome_plano` varchar(128) NOT NULL,
  `desc_plano` varchar(512) NOT NULL,
  `tempo_limite` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `previdencia_planos`
--

INSERT INTO `previdencia_planos` (`id`, `nome_plano`, `desc_plano`, `tempo_limite`) VALUES
(1, 'Básico', 'Plano básico com investimento mensal de R$500,00', 12),
(2, 'Intermediário', 'Plano intermediário com investimento mensal de R$1.000,00', 12),
(3, 'Avançado', 'Plano avançado com investimento mensal de R$2.000,00', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contas`
--
ALTER TABLE `contas`
  ADD PRIMARY KEY (`numerodaconta`);

--
-- Indexes for table `previdencia`
--
ALTER TABLE `previdencia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `previdencia_planos`
--
ALTER TABLE `previdencia_planos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contas`
--
ALTER TABLE `contas`
  MODIFY `numerodaconta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `previdencia`
--
ALTER TABLE `previdencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `previdencia_planos`
--
ALTER TABLE `previdencia_planos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
