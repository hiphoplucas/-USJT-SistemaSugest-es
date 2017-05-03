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
            <div class="col-md-10">
                 <select name="categoria">
                	        <option value="#">*Selecione o Departamento*</option>
                    <c:if test="${not empty lista}">
                        <c:forEach var="categoria" items="${lista}">                    
                            <option value="${categoria.id }">${categoria.categoria }</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
                <div class="col-md-2">
                    <a href="novaSugestao.jsp"><button class="botao">+ NOVA SUGESTÃO</button></a>
                </div>
            </div>    
        </div>
            <div class="limitSugestao">
                <div class="container-fluid">
                    <div class="col-md-8" id=sugestao>
                    	
                    </div>
                    <div class="col-md-4">
                        <div class="boxPopulares">
                            <div class="tPopulares">
                                Populares
                            </div>
                                 <c:if test="${not empty lista}">
                                    <c:forEach var="sugestao" items="${listaTop}">                    
                                        <div class="subPopulares">
                                            ${sugestao.titulo } 
                                        </div>
                                        <div class="pSugestao">
                                            ${sugestao.sugestao }
                                        </div>
                                        <div class="pData">
                                            ${sugestao.data } | ${sugestao.nomeEspecialidade } | <spam class="pVerMai"><a href="#">Ver Mais</a></spam> <br><br>
                                        </div>
                                    </c:forEach>
                                </c:if>
                        </div>
                    </div>            
            </div>  
            </div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>