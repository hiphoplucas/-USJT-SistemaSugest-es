-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 18-Maio-2017 às 03:38
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarios`
--

CREATE TABLE `comentarios` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idSugestao` int(11) DEFAULT NULL,
  `comentario` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `comentarios`
--

INSERT INTO `comentarios` (`id`, `idUsuario`, `idSugestao`, `comentario`) VALUES
(13, 21, 2, 'Concordo totalmente, temos o mesmo problema no quarto andar.'),
(14, 20, 6, 'Também estou com o mesmo problema. Poderiam me indicar como posso resolver isso?'),
(18, 18, 1, 'boa sugestão!');

-- --------------------------------------------------------

--
-- Estrutura da tabela `especialidade`
--

CREATE TABLE `especialidade` (
  `idEspecialidade` int(11) NOT NULL,
  `nomeEspecialidade` varchar(100) NOT NULL,
  `corEspecialidade` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `especialidade`
--

INSERT INTO `especialidade` (`idEspecialidade`, `nomeEspecialidade`, `corEspecialidade`) VALUES
(1, 'Financeiro', '#00bf93'),
(2, 'TI', '#005ebf'),
(3, 'Segurança', '#7600bf'),
(4, 'Administração', '#00e6e6'),
(5, 'Limpeza', '#e0e0e0');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sugestao`
--

CREATE TABLE `sugestao` (
  `idSugestao` int(11) NOT NULL,
  `Colaborador` int(11) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `Sugestao` text,
  `Avaliador` int(11) DEFAULT NULL,
  `Especialidade` int(11) DEFAULT NULL,
  `Positivos` int(11) DEFAULT NULL,
  `Negativos` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `Data` datetime NOT NULL,
  `FeedBack` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `sugestao`
--

INSERT INTO `sugestao` (`idSugestao`, `Colaborador`, `titulo`, `Sugestao`, `Avaliador`, `Especialidade`, `Positivos`, `Negativos`, `status`, `Data`, `FeedBack`) VALUES
(1, 1, 'Qualquer um pode entrar na universidade', 'Por falta de um sistema de validação de alunos, qualquer pessoal pode entrar na faculdade hoje. O que se torna muito perioso. Recomendo um sistema de catraca aonde somente quem tiver a carterinha da faculdade poderá entrar.', NULL, 3, NULL, NULL, 'ativo', '2016-11-06 18:59:29', NULL),
(2, 1, 'O wi-fi não funciona no segundo andar da faculdade.', 'A utilização da internet via wi-fi no segundo andar da universidade é muito ruim. Não conseguimos acessar e quando conseguimos a navegação é muito ruim. Acredito que disponibilizar um roteador para cada andar seja mais adequado para o melhor uso do recurso.', NULL, 2, NULL, NULL, 'ativo', '2016-11-06 00:00:00', NULL),
(4, 18, 'Impossivel de usar os banheiros', 'A cada dia os banheiros estão mais sujos. Em alguns dias a utilização fica impossível. Acredito que seria muito bom se o mesmo fosse limpado mais de uma vez por dia, devido ao número alto de pessoas que utilizam.', NULL, 5, NULL, NULL, 'recusado', '2016-11-06 00:00:00', 'Infelizmente não temos essa possibilidade no momento. Hoje fazemos 3 turnos de limpeza em todos os banheiros na univesidade, um de manhã um a tarde e um a noite.'),
(5, 1, 'Dificuldade para baixar os boletos do SOL', 'Estamos tendo dificuldades para baixar os boletos via sistema SOL. Acredito que seria mais interessante se todo dia primeiro, os boletos fossem encaminhados para os e-mails dos alunos.', NULL, 1, NULL, NULL, 'ativo', '2016-11-06 19:35:43', NULL),
(6, 15, 'Dificuldade para entrega dos documentos.', 'Fiquei devendo alguns documentos no momento da matrícula e não estou conseguindo informações sobre como devo fazer para entregar os documentos. Me parece recomendavel um novo treinamento da equipe do CAA.', NULL, 4, NULL, NULL, 'ativo', '2016-11-13 19:50:36', NULL),
(13, 20, 'foi essa preula', 'hu3 hu3 hu3', NULL, 1, NULL, NULL, 'ativo', '2017-05-17 21:57:06', 'Sua sugestão foi recusada pelo avaliador.'),
(14, 20, 'wefwe', 'fwefwefwefwfwe', NULL, 1, NULL, NULL, 'inativo', '2017-05-17 22:07:54', NULL),
(15, 21, 'wdqqwdq', 'dqwdqwdqwd', NULL, 1, NULL, NULL, 'inativo', '2017-05-17 22:29:04', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `curso` varchar(100) DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `cpf` varchar(30) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  `idEspecialidade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nome`, `curso`, `senha`, `Email`, `cpf`, `tipo`, `idEspecialidade`) VALUES
(10, 'Lucas dos Reis', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'adm@adm.com', '38242227871', 3, NULL),
(12, 'Bruno Borges', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'limpeza@adm.com', '10507058313', 2, 5),
(13, 'Thiago Carpes', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'administracao@adm.com', '14267592314', 2, 4),
(15, 'Ray Kennedy', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'ti@adm.com', '38242227870', 2, 2),
(16, 'Vinicius Fernando', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'financeiro@adm.com', '38242227870', 2, 1),
(17, 'Lucas dos Reis', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'seguranca@adm.com', '38242227870', 2, 3),
(18, 'Marcos Antônio', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'marcosa@gmail.com', '38242227870', 1, NULL),
(20, 'Carlos Eduardo', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'caedu@gmail.com', '38242227870', 1, NULL),
(21, 'Marcos Paulo', NULL, 'c4ca4238a0b923820dcc509a6f75849b', 'mpaulo@gmail.com', '38242227870', 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `especialidade`
--
ALTER TABLE `especialidade`
  ADD PRIMARY KEY (`idEspecialidade`);

--
-- Indexes for table `sugestao`
--
ALTER TABLE `sugestao`
  ADD PRIMARY KEY (`idSugestao`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `especialidade`
--
ALTER TABLE `especialidade`
  MODIFY `idEspecialidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `sugestao`
--
ALTER TABLE `sugestao`
  MODIFY `idSugestao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
