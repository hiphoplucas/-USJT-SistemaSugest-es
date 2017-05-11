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
                <div class="col-md-9"><div id="tituloHome">Categorias</div></div>
                <c:import url="logoInterno.jsp"/>
				<div class="col-md-1"><a href="index.jsp">Sair</a></div>

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
                                    <th>Categoria</th>
                                    <th>Cor</th>
                                    <th class="actions">Opções</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="categoria" items="${lista}">
                                       <tr>
                                            <td>
                                               ${categoria.id }
                                            </td>
                                            <td>
                                                ${categoria.categoria }
                                            </td>
                                            <td>
                                                ${categoria.cor }
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarCliente&id=${cliente.id }">Editar</a>
                                                <button id="btn${cliente.id }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${cliente.id }">Excluir</button>
                                            </td>
                                        </tr>             
                            </c:forEach>

                            </tbody>
                        </table>
                        <a href="novaCategoria.jsp"><input type="submit" value="NOVO CATEGORIA" class="botao"></a>
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