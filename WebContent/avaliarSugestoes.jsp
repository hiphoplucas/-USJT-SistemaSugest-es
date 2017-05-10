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
                <div class="col-md-9"><div id="tituloHome">Avaliar Sugestão</div></div>
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
    				</form>
    			</div>
    		</div>
    		<div class="col-md-4">
    			<div class="tPopulares">
    				Ações<br>
    			</div>
    			<a href="controller.do?command=AprovaSugestao&idSugestao=${sugestao.idSugestao }"><button type="button" class="botaoVerde">APROVAR</button></a></spam>
    			<button type="submit" class="botaoCinza" name="command" value="CriarUsuario">INATIVAR</button><br>
    			<div class="tPopulares">
    				Recusar<br>
    			</div>    		
    			<input type="text" placeholder=" Deixe um feedback para o colaborador" name="comentario" class="feedback"> <br>
    			<button type="submit" class="botaoVermelho" name="command" value="CriarUsuario">RECUSAR</button><br>	
    		</div>
    	</div>
    	</div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>