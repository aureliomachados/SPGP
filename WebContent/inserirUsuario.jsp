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
<h2>Cadastro de Usuário</h2> <br> <br>
<form action="controleUsuario" method="post">
CPF:<input type="text" name="cpf" required="required" min="11" maxlength="11"> <br><br>
Nome:<input type="text" name="nome" required="required"> <br><br>
Login:<input type="text" name="login" required="required"> <br><br>
Senha:<input type="password" name="senha" required="required"> <br><br>
Perfil:<select name="perfil">
<option value= null>Selecione</option>
<option value="Administrado">Administrado</option>
<option value="Analista">Analista</option>
<option value="Protocolista">Protocolista</option>
</select>
 <br><br>
Departamento:<select name="departamento">
<option value= null>Selecione</option>
<option value="TI">TI</option>
</select> <br><br>
Situacao:<select name="situacao">
<option value= null>Selecione</option>
<option value="Ativo">Ativo</option>
<option value="Desativado">Desativado</option>
</select>
 <br><br> <br>

<input type="hidden" name="acao" value="inserirUsuario">
<input type="submit" value="Inserir">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>