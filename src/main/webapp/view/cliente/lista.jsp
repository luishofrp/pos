<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<tag:maintemplate title="Lista de Clientes">

    <table class="table">
        <thead>
            <tr>
              <th scope="col">Codigo</th>
              <th scope="col">Nome</th>
              <th scope="col">CPF</th>
              <th scope="col">Telefone</th>
              <th scope="col">E-mail</th>
              <th scope="col">-</th>
              <th scope="col">-</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td><c:out value="${cliente.codigo}" /></td>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.cpf}" /></td>
                    <td><c:out value="${cliente.telefone}" /></td>
                    <td><c:out value="${cliente.email}" /></td>


                    <td><a href="<c:url value="/cliente?codigo=${cliente.codigo}"/>"><button class="btn btn-primary">Editar</button></a></td>
                    <td><a href="<c:url value="/excluircliente?codigo=${cliente.codigo}"/>"><button class="btn btn-danger">Excluir</button></a></td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>

</tag:maintemplate>