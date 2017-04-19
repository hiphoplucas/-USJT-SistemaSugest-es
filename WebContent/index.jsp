<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>USJT - SISTEMA SUGESTÕES</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilo.css" rel="stylesheet">
</head>
<header>
    <div class="top">
        <div class="limit">
            <div class="titulos">
                <div id="titulo">Faça Sua Sugestão</div>
                <div id="subTitulo"> Nos ajude a melhorar, sua opinião é muito importante para nós</div> <img src="imagens/logo.png" alt="" id="logo"> </div>
        </div>
    </div>
</header>
<body>
<form action="ManterUsuario.do" name="form" method="post">
    <div class="conteudo">
        <div class="limit">
            <div class="menu">
                <div class="opcoes" id="esquerdo">
                    
                        <ul>
                            <li>
                                <div class="menuTitulo">Cadastre-se</div>
                            </li>
                            <li>
                                <div class="menuSubTitulo">Preencha os campos abaixo para fazer a sua sugestão.</div>
                            </li>
                            <li>
                                <input name="nome" type="text" placeholder=" Nome Completo"> </li>
                            <li>
                                <input name="email"  type="text" placeholder=" Email"> </li>
                            <li>
                                <input name="cpf" type="text" placeholder=" CPF"> </li>
                            <li>
                                <input name="senha" type="text" placeholder=" Senha"> </li>
                            <li>
                                <input type="text" placeholder=" Confirme a Senha"> </li>
                            <li>
                                <input type="submit" name="acao" value="CADASTRAR" id="cadastrar">
                            </li>
                        </ul>
                    </div>
               
                <div class="opcoes" id="direito">
                    
                        <ul>
                            <li>
                                <div class="menuTitulo">Login</div>
                            </li>
                            <li>
                                <div class="menuSubTitulo">Entre com usuário e senha para ver suas sugestões.</div>
                            </li>
                            <li>
                                <li>
                                    <input type="text" placeholder=" Email"> </li>
                                <li>
                                    <input type="text" placeholder=" Senha "> </li>
                                <li>
                                    <button type="button">LOGIN</button>
                                </li>
                        </ul>
                    
                </div>
            </div>
        </div>
    </div>
   </form>
</body>
</html>