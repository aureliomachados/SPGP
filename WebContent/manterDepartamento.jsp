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
<h2>MATER DEPARTAMENTO</h2><BR>
<a>MENU</a>  
<BR>
<ul class="nav nav-list">
<li><a href="inserirDepartamento.jsp"> INCLUIR  </a></li>
<li><a href="controleDpto?acao=listarDpto"> CONSULTAR  </a></li>
</ul>
<BR>
<input name="Home" type="button"  onClick="location. href= 'homeAdm.jsp'" value="Home">  <BR>
</body>
</html>