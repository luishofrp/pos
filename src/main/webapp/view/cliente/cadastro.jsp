<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<tag:maintemplate title="Cadastrar Novo Cliente">
    <form name="cadCliente" action="/cliente" method="post" class"form-horizontal">
    <fieldset>
       <div class = "form-group row">
            <label class="col-md-4 text-right"
            > Código: </label>
                <div class="col-md-1">
                    <input class="form-control input-md" readonly name="codigo" value="<c:out value="${cliente.codigo}" />" />
                </div>
        </div>

         <div class = "form-group row">
            <label class="col-md-4 text-right"> Nome: </label>
               <div class="col-md-4">
                      <input class="form-control input-md" name="nome" value="<c:out value="${cliente.nome}" />" />
                </div>
        </div>

        <div class="form-group row">
        <label class="col-md-4 text-right"> Cpf: </label>
         <div class="col-md-4">
        <input class="form-control input-md" name="cpf" value="<c:out value="${cliente.cpf}" />" />
        </div>
        </div>

        <div class="form-group row">
        <label class="col-md-4 text-right"> Telefone: </label>
        <div class="col-md-4">
        <input class="form-control input-md"  name="telefone" value="<c:out value="${cliente.telefone}" />" />
        </div>
        </div>

        <div class="form-group row">
        <label class="col-md-4 text-right"> E-mail: </label>
        <div class="col-md-4">
        <input class="form-control input-md" name="email" value="<c:out value="${cliente.email}" />" />
        </div>
        </div>



      <div class="form-group col-md-8 text-right">
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </div>
    </fieldset>
</form>
</tag:maintemplate>


