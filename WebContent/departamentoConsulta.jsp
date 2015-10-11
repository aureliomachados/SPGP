<%@page import="mvc.beans.Departamento"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="validaSessao.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
</head>
<body>
<h1 align="center">Sistema de Protocolo e Gerenciamento de Processos</h1><br>
<h2>Consulta de Departamento</h2> <br> 
<br>

<%
	Departamento consultaDpt = (Departamento) request.getAttribute("consDpto");

%>
<table border="1">
<tr>
<th>Codigo</th>
<th>Nome</th>
<th>Acoes </th>
</tr>
<tr>
<td><%=consultaDpt.getCodDpto()%></td>
<td><%=consultaDpt.getNome()%></td>
<td><a href="controleDpto?nome=<%=consultaDpt.getNome()%>&acao=excluirDepartamento">Excluir</a>
	<a href="controleDpto?nome=<%=consultaDpt.getNome()%>&acao=consultarDp">Alterar</a>  </td>
</tr>
</table>
<br>
<input type="button" value="Voltar" onClick="history.go(-1)"> <br>
</body>
</html>