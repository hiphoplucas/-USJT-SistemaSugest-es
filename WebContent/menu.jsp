 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>         
    <div id="barraMenuHome">    
        <div class="limitHome">            
            <ul>
                <li><a href="controller.do?command=CarregaHome">SUGESTÕES</a></li>
                <li><a href="controller.do?command=CarregaUsuario&idUsuario=${idusuario }">MEUS DADOS</a></li>
                <li><a href="algumaDuvida.jsp">ALGUMA DUVIDA ?</a></li>
                <c:if test="${tipousuario == 1 }"><li><a href="#">MINHAS SUGESTÕES</a></li></c:if>
                <c:if test="${tipousuario == 2 }"><li><a href="controller.do?command=CarregaSugestaoAvalia&IdEspecialidade=${idespecialidade }">AVALIAR SUGESTÕES</a></li></c:if>
                <c:if test="${tipousuario == 2 }"><li><a href="#">RANKING</a></li></c:if>
                <c:if test="${tipousuario == 2 }"><li><a href="#">INDICE DE APROVAÇÃO</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=ListarAvaliador">AVALIADOR</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=ListarCategoria">CATEGORIAS</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=CarregaRelParticipacao">PARTICIPAÇÃO</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="sugestoesAprovadas.jsp">SUGESTÕES APROVADAS</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="indiceGeral.jsp">ÍNDICE GERAL</a></li></c:if>
            </ul>
        </div>
    </div>