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
<h2> MATER DOCUMENTO</h2><BR>
<a>MENU</a>  
<BR><BR>
<ul class="nav nav-list">
<li><a href="inserirDocumento.jsp"> INCLUIR </a></li>
<li><a href="controleDocumento?acao=listarDoc"> CONSULTAR  </a></li>
</ul>

<BR>
<BR>
<input name="Home" type="button"  onClick="location. href= 'homeProtocolista.jsp'" value="Home">

</body>
</html>