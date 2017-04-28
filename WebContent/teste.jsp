<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<body>
<h1>Cadastro de usuarios</h1>
<form action="controller.do" method="post">
    Nome: <input type="text" name="nome" placeholder=" Nome Completo"> <br>
    Email: <input type="text" name="email" placeholder=" E-mail"> <br>
    CPF: <input type="text" name="cpf" placeholder=" CPF"> <br>
    Senha: <input type="text" name="senha" placeholder=" Senha"> <br>
    <button type="submit" class="btn btn-primary" name="command" value="CriarUsuario">Salvar</button>
</form>
</body>
</html>