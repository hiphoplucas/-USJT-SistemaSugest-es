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
                <c:import url="menu.jsp"/>
    </div>
    <div class="limitHome">
    	<div class="vSugestao">
    	<div class="container-fluid">
    		<div class="col-md-8" id=sugestao>
    			<div class="tPopulares">
    				Título
    			</div>
    			<div class="vsTitulo">
    			${sugestao.idSugestao } | ${comentario.idSugestao } | ${sugestao.titulo }
    			</div>
    			<div class="tPopulares">
    				Sugestão
    			</div>
    			<div class="vsSugestao">
    			${sugestao.sugestao }
    			</div>
    			<div class="vsAcao">
    				<input type="text" placeholder=" Faça aqui seu comentário sobre essa sugestão"> <br>
    				<button>SALVAR</button>
    			</div>
    		</div>
    		<div class="col-md-4">
    			<div class="tPopulares">
    				Comentários ${sugestao.idSugestao }<br>
    			</div>
    			<c:if test="${not empty listaComentario}">
                	<c:forEach var="comentario" items="${listaComentario}">                    
                		<div class="vsUsuario">
                			Usuário: ${comentario.nomeColaborador } 
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