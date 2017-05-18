<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
	<c:import url="icon.jsp"/>
    <link rel="stylesheet" href="css/styleHome.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>USJT - SISTEMA SUGESTÕES - AVALIADOR</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Avaliadores</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    
    
    <div class="container-fluid">
    <div class="limitHome">
        <div class="conteudoCadastro">
        <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>E-mail</th>
                                    <th>Especialidade</th>
                                    <th class="actions">Opções</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="usuario" items="${lista}">
                                       <tr>
                                            <td>
                                               ${usuario.id }
                                            </td>
                                            <td>
                                                ${usuario.nome }
                                            </td>
                                            <td>
                                                ${usuario.email }
                                            </td>
                                            <td>
                                                ${usuario.nomeEspecialidade }
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarCliente&id=${cliente.id }">Editar</a>
                                                <button id="btn${usuario.id }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${usuario.id }">Excluir</button>
                                            </td>
                                        </tr>             
                            </c:forEach>

                            </tbody>
                        </table>
                        <a href="controller.do?command=ListarCategoriaAvaliador"><input type="submit" value="NOVO AVALIADOR" class="botao"></a>
                    </div>
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