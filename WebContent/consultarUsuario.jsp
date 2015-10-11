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
<h2 align="center">Consulta de Usuário</h2> <br>
<form align="center" action="controleUsuario" method="post">
Login: <input type="text" name="login" required="required"> <br><br>
<input type="hidden" name="acao" value="consultarUsuario">
<input type="submit" value="Consultar">
</form>
<br>
<br>
<br>

<%
   ResultSet listagem = (ResultSet)session.getAttribute("lista");
%>
<table align="center" border="1">
<tr>
<th>CPF</th>
<th>Nome</th>
<th>Login</th>
<th>Perfil </th>
<th>Departamento </th>
<th>Situação </th>
<th>Ação </th>

</tr>

 <% if (listagem!=null){
	  while (listagem.next()) {
	  %> 
 <tr>
 <td><%=listagem.getString("cpf")%></td>

<td><%=listagem.getString("nome")%></td>

<td><%=listagem.getString("login")%></td>

 <td><%=listagem.getString("perfil")%></td>

<td><%=listagem.getString("dpto_usuario")%></td>

<td><%=listagem.getString("situacao")%></td>

<td> 
<a href="controleUsuario?login=<%=listagem.getString("login")%>&acao=desabilitarUsuario">Desabilitar</a>
<a href="controleUsuario?login=<%=listagem.getString("login")%>&acao=habilitarUsuario">Habilitar</a>
<a href="controleUsuario?login=<%=listagem.getString("login")%>&acao=consultarUsr">Alterar</a></td>
   
  <%}
	  }%>
</tr>
</table>
<br>
<br>
<form align="center">
<input name="Voltar" type="button"  onClick="location. href= 'manterUsuario.jsp'" value="Voltar"><br>
</form>
</body>
</html>