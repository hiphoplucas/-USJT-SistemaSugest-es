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
                <div class="col-md-9"><div id="tituloHome">Participações</div></div>
                <c:import url="logoInterno.jsp"/>
				<div class="col-md-1"><a href="index.jsp">Sair</a></div>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    </div>
    <div class="container-fluid">
    <div class="limitHome">
        <div class="conteudoCadastro">
        
        
        	<c:if test="${not empty listaParticipacao}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>Participante</th>
                                    <th>Quantidade de Sugestões</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="sugetao" items="${listaParticipacao}">
                                       <tr>
                                            <td>
                                               ${sugestao.nomecolaborador }
                                            </td>
                                            <td>
                                                ${sugestao.pquantidade }
                                            </td>
                                </tr>             
                            </c:forEach>

                            </tbody>
                        </table>                 </div>
                </div>
                <!-- /#list -->
               </c:if>
    
        </div>
    </div>
    
    
    
    
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>