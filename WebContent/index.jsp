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
	<c:import url="icon.jsp"/>
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

    <div class="conteudo">
        <div class="limit">
            <div class="menu">
                <div class="opcoes" id="esquerdo">
                    <form action="controller.do" method="post">
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
                                <input name="senha" type="password" placeholder=" Senha"> </li>
                            <li>
                                <input type="password" placeholder=" Confirme a Senha"> </li>
                            <li>
                                <button type="submit" id="cadastrar" name="command" value="CriarUsuario">SALVAR</button>
                            </li>
                        </ul>
                     </form>
                    </div>
               
                <div class="opcoes" id="direito">
                    <form action="controller.do" method="post">
                    <input type="hidden" name="command" value="Login">
                        <ul>
                            <li>
                                <div class="menuTitulo">Login</div>
                            </li>
                            <li>
                                <div class="menuSubTitulo">Entre com usuário e senha para ver suas sugestões.</div>
                            </li>
                            <li>
                                <li>
                                    <input type="text" name="email" placeholder=" Email"> </li>
                                <li>
                                    <input type="password" name="senha" placeholder=" Senha "> </li>
                                <li>
                                    <button type="submit">LOGIN</button>
                                </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
   
</body>
</html>