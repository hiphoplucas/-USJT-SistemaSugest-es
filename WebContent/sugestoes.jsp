<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/styleHome.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Sugestões</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Sugestões</div></div>
                <c:import url="menu.jsp"/>
    </div>
    <div class="limitHome">
        <div class="container-fluid">
            <div class="menuSugestoes">
            <div class="col-md-8">
                <button>testex</button>
            </div>
            <div class="col-md-4">
                <a href="novaSugestao.jsp"><button class="botao">+ Nova Sugestão</button></a>
            </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>