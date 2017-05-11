<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/styleHome.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Sugestão</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Ver Sugestão</div></div>
                <c:import url="logoInterno.jsp"/>
				<div class="col-md-1"><a href="index.jsp">Sair</a></div>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    <div class="limitHome">
    	<div class="vSugestao">
    	<div class="container-fluid">
    		<div class="col-md-8" id=sugestao>
    			<div class="tPopulares">
    				Título
    			</div>
    			<div class="vsTitulo">
    			${sugestao.titulo }
    			</div>
    			<div class="tPopulares">
    				Sugestão
    			</div>
    			<div class="vsSugestao">
    			${sugestao.sugestao }
    			</div>
    			<div class="vsAcao">
    				<form action="controller.do"  method="post">
    					<input type="hidden" name="idSugestao" value="${sugestao.idSugestao }">
    					<input type="hidden" name="idUsuario" value="${idusuario }">
    					<input type="text" placeholder=" Faça aqui seu comentário sobre essa sugestão" name="comentario"> <br>
    					<button type="submit" class="botao" name="command" value="CriarComentario">SALVAR</button>
    				</form>
    			</div>
    		</div>
    		<div class="col-md-4">
    			<div class="tPopulares">
    				Comentários<br>
    			</div>
    			<c:if test="${not empty listaComentario}">
                	<c:forEach var="comentario" items="${listaComentario}">                    
                		<div class="vsUsuario">
                			Usuário: ${comentario.usuario } 
                		</div>
                		<div class="vsSugestao">
                			${comentario.comentario } <br>
                		</div>
                	</c:forEach>
                </c:if>    			
    		</div>
    	</div>
    	</div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>