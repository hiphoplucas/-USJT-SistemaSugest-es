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
                <div class="col-md-9"><div id="tituloHome">Novo Avaliador</div></div>
                <c:import url="menu.jsp"/>
    </div>
    
    <div class="limitHome">
    <form action="ManterUsuarioAvaliador.do" name="form" method="post">    
        <div class="conteudo">
        <ul>
            <li>
                <div class="sT">Editando os meus dados.</div>
            </li>
            <li>
                <input name="nome" type="text" placeholder=" Nome Completo"> </li>
            <li>
                <select>
                    <option value="#">*Selecione a Categoria do avaliador*</option>
                    <option value="1">Financeiro</option>
                    <option value="2">TI</option>
                    <option value="3">Segurança</option>
                    <option value="4">Administração</option>
                    <option value="5">Limpeza</option>
                </select>
            <li>
            <li>
                <input name="email"  type="text" placeholder=" Email"> </li>
            <li>
                <input name="senha" type="text" placeholder=" Senha"> </li>
            <li>
                <input name="cpf" type="text" placeholder=" CPF"> </li>                
            <li>
                <input type="submit" name="acao" value="SALVAR" class="botao">
            </li>
        </ul>    
        </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>