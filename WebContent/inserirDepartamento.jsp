<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="validaSessao.jsp" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
</head>
<body>
<H1>Sistema de Protocolo e Gerenciamento de Processos </H1> <br> 
Cadastro de Departamento <br> <br>
<form action="controleDpto" method="post">
Nome:<input type="text" name="nome" required="required"> <br><br>
<input type="hidden" name="acao" value="inserirDepartamento">
<input type="submit" value="Inserir">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>