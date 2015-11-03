<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>

<jsp:include page="partes/cabecalho.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partes/menu.jsp"></jsp:include>

	<div class="container">

	

<form align="center" action="controleUsuario" method="post"
						class="form-vertical">
						<div class="form-group">
							Login: <input type="text" name="login" required="required" class="form-control">
							Nome: <input type="text" name="login" required="required" class="form-control">
						</div>
						<input type="hidden" name="acao"
							value="consultarUsuario">
							
							 <input type="submit"
							value="Consultar" class="btn btn-success">
					</form>
		
		
	
		
		<form align="center">
		<input name="Voltar" type="button"
			onClick="location. href= 'manterUsuario.jsp'" value="Voltar" class="btn btn-success"><br>
	</form>
	</div>
</body>
</html>