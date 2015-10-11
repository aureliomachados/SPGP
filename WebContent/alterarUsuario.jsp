<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mvc.beans.Usuario"%>
<%@include file="validaSessao.jsp" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spgp</title>
</head>
<body>
<H1  align="center">Sistema de Protocolo e Gerenciamento de Processos </H1> <br>  <br> 
<H2>Alterar Usuário</H2> <br> <br>
<%
	Usuario consultaUsr = (Usuario) request.getAttribute("user");

%>

<form action="controleUsuario" method="post">
CPF:<input type="text" name="cpf" value="<%=consultaUsr.getCpf()%>" readonly="readonly"> <br><br>
Nome:<input type="text" name="nome" value="<%=consultaUsr.getNome()%>" required="required"> <br><br>
Login:<input type="text" name="login" value="<%=consultaUsr.getLogin()%>" required="required"> <br><br>
Senha:<input type="password" name="senha" value="<%=consultaUsr.getSenha()%>" required="required"> <br><br>
Perfil:<input type="text" name="perfil" value="<%=consultaUsr.getPerfil()%>" required="required"> <br><br>
Departamento:<input type="text" name="departamento" value="<%=consultaUsr.getDepartamento()%>" required="required"> <br><br>
 
<input type="hidden" name="acao" value="alterarUsuario">
<input type="submit" value="Alterar">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>