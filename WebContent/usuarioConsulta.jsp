<%@page import="mvc.beans.Usuario"%>
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
<h2 align="center">Consulta de Usuário</h2> <br>
<form align="center" action="controleUsuario" method="post" >
Login: <input type="text" name="login" required="required"> <br><br>
<input type="hidden" name="acao" value="consultarUsuario">
<input type="submit" value="Consultar">
</form>
<br> <br>
<%
	Usuario consultaUsr = (Usuario) request.getAttribute("user");

%>

<table align="center" border="1">
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
<td><a href="controleUsuario?login=<%=consultaUsr.getLogin()%>&acao=desabilitarUsuario">Desabilitar</a>
<a href="controleUsuario?login=<%=consultaUsr.getLogin()%>&acao=habilitarUsuario">Habilitar</a>
<a href="controleUsuario?login=<%=consultaUsr.getLogin()%>&acao=consultarUsr">Alterar</a></td>
</tr>
</table>
<br>
<br>
<form align="center">
<input name="Voltar" type="button"  onClick="location. href= 'manterUsuario.jsp'" value="Voltar"><br>
</form>
</body>
</html>