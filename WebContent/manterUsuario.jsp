<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="validaSessao.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
</head>
<body>
<h1 align="center">Sistema de Protocolo e Gerenciamento de Processos</h1><br>
<h2> MATER USUARIO</h2><BR>
<a>MENU</a>  
<BR>
<ul class="nav nav-list">
<li><a href="inserirUsuario.jsp"> INCLUIR </a></li>
<li><a href="controleUsuario?acao=listar"> CONSULTAR  </a></li>
</ul>
<BR>
<BR>
<input name="Home" type="button"  onClick="location. href= 'homeAdm.jsp'" value="Home">

</body>
</html>