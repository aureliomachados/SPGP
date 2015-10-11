<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mvc.beans.Departamento"%>
<%@include file="validaSessao.jsp" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spgp</title>
</head>
<body>
<H1 align="center">Sistema de Protocolo e Gerenciamento de Processos </H1><br> 
<h2>Alterar Usuário</h2><br>
<%
	Departamento consultaDpt = (Departamento) request.getAttribute("dpt");

%>
<form action="controleDpto" method="post">
Codigo:<input type="number" name="codigo" value="<%=consultaDpt.getCodDpto()%>" readonly="readonly"> <br><br>
Nome:<input type="text" name="nome" value="<%=consultaDpt.getNome()%>" required="required"> <br><br>

<input type="hidden" name="acao" value="alterarDepartamento">
<input type="submit" value="Alterar">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>