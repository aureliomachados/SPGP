<%@page import="mvc.beans.Documento"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="validaSessao.jsp" %>  
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
</head>
<body>
<h1 align="center">Sistema de Protocolo e Gerenciamento de Processos</h1><br>
<h2 align="center">Consulta de Processo</h2> <br>
<form align="center" action="controleDocumento" method="post">
Codigo <input type="number" name="numProtocolo" required="required"> <br><br>
<input type="hidden" name="acao" value="consultarDocumento">
<input type="submit" value="Consultar">
</form>
<br>
<br>
<br>
<%
	Documento consultaDoc = (Documento) request.getAttribute("doc");

%>
<a href="controleDocumento?acao=emitirRelatorio">EMITIR RELATORIO </a> <BR>
<table align="center" border="1">
<tr>
<th>Codigo do processo</th>
<th>Interessado</th>
<th>N do Documento </th>
<th>Data do Documento</th>
<th>Tipo de Processo</th>
<th>Data de Entrada</th>
<th>Status</th>
<th>Acao </th>
</tr>
<tr>
<td><%=consultaDoc.getNumProtocolo()%></td>

<td><%=consultaDoc.getNomeInteressado()%></td>

<td><%=consultaDoc.getNumDoc()%></td>

 <td><%=consultaDoc.getDataDoc()%></td>

<td><%=consultaDoc.getTipo()%></td>

<td><%=consultaDoc.getDataEntrada()%></td>

<td><%=consultaDoc.getStatus()%></td>

<td><a href="controleDocumento?numProtocolo=<%=consultaDoc.getNumProtocolo()%>&acao=consultDetalhada">Detalhar</a>

<a href="controleDocumento?numProtocolo=<%=consultaDoc.getNumProtocolo()%>&acao=consultProc">Alterar</a></td>
</tr>
</table>
<br>
<br>
<form align="center">
<input name="Voltar" type="button"  onClick="location. href= 'homeProtocolista.jsp'" value="Voltar"><br>
</form>
</body>
</html>