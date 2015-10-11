<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mvc.beans.Departamento"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="validaSessao.jsp" %> 
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP </title>
</head>
<body>
<h1 align="center">Sistema de Protocolo e Gerenciamento de Processos</h1><br>
<h2>Consulta de Departamento</h2> <br> 
<form action="controleDpto" method="post">
Nome <input type="text" name="nome" required="required"> <br><br>
<input type="hidden" name="acao" value="consultarDepartamento">
<input type="submit" value="Consultar">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>

<br>
<%
   ResultSet listagem = (ResultSet)session.getAttribute("listaDpto");
%>
<table border="1">
<tr>
<th>Codigo</th>
<th>Nome</th>
<th>Ação</th>

</tr>

 <% if (listagem!=null){
	  while (listagem.next()) {
	  %> 
 <tr>
 	<td><%=listagem.getInt("cod_dpto")%></td>
	 <td><%=listagem.getString("nome_dpto")%></td>
	<td><a href="controleDpto?nome=<%=listagem.getString("nome_dpto")%>&acao=excluirDepartamento">Excluir</a>
	<a href="controleDpto?nome=<%=listagem.getString("nome_dpto")%>&acao=consultarDp">Alterar</a></td>
   
  <%}
	  }%>
</tr>
</table>
</body>
</html>