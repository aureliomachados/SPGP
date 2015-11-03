<%@page import="mvc.beans.Usuario"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="validaSessao.jsp" %>  
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>

<jsp:include page="partes/cabecalho.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partes/menuAdm.jsp"></jsp:include>

	<div class="container">

		<div class="col-md-3">
			<div class="panel panel-default">
				<div class="panel-heading panel-title text-center">Consulta de
					Usuário</div>
					
					<div class="panel-body">

					<form align="center" action="controleUsuario" method="post"
						class="form-vertical">
						<div class="form-group">
							Login: <input type="text" name="login" required="required" class="form-control">
						</div>
						<input type="hidden" name="acao"
							value="consultarUsuario">
							
							 <input type="submit"
							value="Consultar" class="btn btn-success">
					</form>					
				</div>
			</div>
		</div>
		<div class="col-md-9">
			<form align="height">
			<input name="emitirRelatorio" type="button"
			onClick="location. href= 'controleUsuario?acao=emitirRelatorioUs'" value="Emitir Relatorio" class="btn btn-success"><br>
			</form>
				<br>

				<%
					Usuario consultaUsr = (Usuario) request.getAttribute("user");
				
				%>

			<table class="table table-bordered table-hover table-striped">
				<tr>
					<th>CPF</th>
					<th>Nome</th>
					<th>Login</th>
					<th>Perfil </th>
					<th>Departamento </th>
					<th>Situacao </th>
					<th>Acoes </th>
				</tr>
				<tr>
					<td><%=consultaUsr.getCpf()%></td>
					
					<td><%=consultaUsr.getNome()%></td>
					
					<td><%=consultaUsr.getLogin()%></td>
					
					 <td><%=consultaUsr.getPerfil()%></td>
					
					<td><%=consultaUsr.getDepartamento()%></td>
					
					<td><%=consultaUsr.getSituacao()%></td>
					<td><a href="controleUsuario?login=<%=consultaUsr.getLogin()%>&acao=desabilitarUsuario" class="btn btn-sm btn-default">Desabilitar</a>
					<a 
					href="controleUsuario?login=<%=consultaUsr.getLogin()%>&acao=habilitarUsuario" class="btn btn-sm btn-primary">Habilitar</a>
					<a 
					href="controleUsuario?login=<%=consultaUsr.getLogin()%>&acao=consultarUsr" class="btn btn-sm btn-warning">Alterar</a></td>
				</tr>
			</table>
		<br>
		<br>
	</div>
		<form align="center">
		<input name="Voltar" type="button"
			onClick="location. href= 'manterUsuario.jsp'" value="Voltar" class="btn btn-success"><br>
		</form>
	</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<footer>
    <div class="container">
        <hr>
        <div class="row">
            <div align="center" class="col-lg-12 footer-below">
                <p>Criado por Bruno Martins e Carlos Guerra.
                <br>                2015</p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>