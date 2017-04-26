<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styleHome.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Nova Categoria</title>
</head>

<body>
    <body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Nova Categoria</div></div>
                <c:import url="menu.jsp"/>
    </div>
    
    <div class="limitHome">
        <form action="controller.do"  method="post">
        <div class="conteudo">
        <ul>
            <li>
                <div class="sT">Categoria.</div>
            </li>
            <li>
                <input name="categoria" type="text" placeholder=" Nome da Categoria"> </li>
            <li>
                <input name="cor"  type="text" placeholder=" Cor da Categoria"> </li>
            <li>
                <input type="submit" name="command" value="CriarCategoria" class="botao">
            </li>
        </ul>    
        </div>
        </form>
    </div>
    
</body>

</html>