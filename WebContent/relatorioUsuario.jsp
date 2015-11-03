<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="validaSessao.jsp"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>

<jsp:include page="partes/cabecalho.jsp"></jsp:include>

<script type="text/javascript">
	print();
</script>
</head>
<body>
	<jsp:include page="partes/menuAdm.jsp"></jsp:include>

	<div class="container">
	<div>
			<h3 align="center">Relatorio de Usuario</h3>
		</div>
		<br>
		<div class="col-md-9">


			<%
				ResultSet listagem = (ResultSet) session.getAttribute("relatorioUs");
			%>
			<table class="table table-bordered table-hover table-striped">
				<tr>
					<th>CPF</th>
					<th>Nome</th>
					<th>Login</th>
					<th>Perfil</th>
					<th>Departamento</th>
					<th>Situação</th>

				</tr>

				<%
					if (listagem != null) {
						while (listagem.next()) {
				%>
				<tr>
					<td><%=listagem.getString("cpf")%></td>

					<td><%=listagem.getString("nome")%></td>

					<td><%=listagem.getString("login")%></td>

					<td><%=listagem.getString("perfil")%></td>

					<td><%=listagem.getString("dpto_usuario")%></td>

					<td><%=listagem.getString("situacao")%></td>


					<%
						}
						}
					%>
				</tr>
			</table>
			<br> <br>
		</div>
		
		<form align="center">
		<input name="Voltar" type="button"
			onClick="history.go(-1)" value="Voltar" class="btn btn-success"><br>
	</form>
	</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
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
</body>
</html>