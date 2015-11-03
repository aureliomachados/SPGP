<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2 align="center">Relatorio de Processo</h2> <br>
<br>
<br>

<%
   ResultSet listagem = (ResultSet)session.getAttribute("relatorioDoc");
%>
<table align="center" border="1">
<tr>

<th>Codigo do processo</th>
<th>Interessado</th>
<th>N do Documento </th>
<th>Data do Documento</th>
<th>Tipo de Processo</th>
<th>Data de Entrada</th>
<th>Status</th>

</tr>

 <% if (listagem!=null){
	  while (listagem.next()) {
	  %> 
 <tr>
 <td><%=listagem.getInt("cod_doc")%></td>

<td><%=listagem.getString("nome_interessado")%></td>

<td><%=listagem.getInt("num_doc")%></td>

 <td><%=listagem.getString("data_doc")%></td>

<td><%=listagem.getString("tipo_doc")%></td>

<td><%=listagem.getString("data_entrada")%></td>

<td><%=listagem.getString("status")%></td>
   
  <%}
	  }%>
</tr>
</table>
<br>
<br>
<form align="center">
<input type="button" value="Voltar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>