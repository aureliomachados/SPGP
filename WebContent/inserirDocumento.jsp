<%@page import="mvc.DAO.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mvc.beans.Departamento"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="validaSessao.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
</head>
<body>

<%
UsuarioDAO usuarioDAO = new UsuarioDAO();

ResultSet rs =  usuarioDAO.listarUsuario();
%>


<H1>Sistema de Protocolo e Gerenciamento de Processos </H1> <br> 
<h2>Cadastro de Documento</h2> <br> <br>

<form action="controleDocumento" method="post">

Nome:<input type="text" name="nome" required="required"> <br><br>
CPF/CNPJ:<input type="text" name="cpf_cnpj" required="required" min="11" maxlength="16"> <br><br>
Numero do Documento: <input type="number" name="numDoc" required="required"> <br><br>
Data do Documento: <input type="date" name="dataDoc" required="required"> <br><br>
Assunto: <input type="text" name="assunto" required="required"> <br><br>
Data da Entrada: <input type="date" name="dataEntrada" required="required"> <br><br>
Tipo: <input type="text" name="tipo" required="required"> <br><br>	
Status: <input type="text" name="status" required="required"> <br><br>



Analista: <select name="analista">
<% while(rs.next()){ %>
	<option value="<%=rs.getInt("id")%>"><%=rs.getString("nome")%></option>
<% }%>

</select> 
<br>
<br>

<br>
<input type="hidden" name="acao" value="inserirDocumento">
<input type="submit" value="Inserir">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>