<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mvc.beans.Documento"%>
<%@include file="validaSessao.jsp" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
</head>
<body>
<H1  align="center">Sistema de Protocolo e Gerenciamento de Processos </H1> <br>  <br> 
<H2>Alterar Ducumento</H2> <br> <br>
<%
	Documento consuDoc = (Documento) request.getAttribute("prot");

%>

<form action="controleDocumento" method="post">

Codigo do Processo: <input type="number" name="numProtocolo" value="<%=consuDoc.getNumProtocolo()%>" readonly="readonly"><br><br>
Nome:<input type="text" name="nomeInteressado" value="<%=consuDoc.getNomeInteressado()%>" required="required"> <br><br>
CPF/CNPJ:<input type="text" name="cpf_cnpj" value="<%=consuDoc.getCpf_cnpj()%>" required="required" min="11" maxlength="16"> <br><br>
Numero do Documento: <input type="number" name="numDoc" value="<%=consuDoc.getNumDoc()%>" required="required"> <br><br>
Data do Documento: <input type="date" name="dataDoc" value="<%=consuDoc.getDataDoc()%>" required="required"> <br><br>
Assunto: <input type="text" name="assunto" value="<%=consuDoc.getAssunto()%>" required="required"> <br><br>
Tipo: <input type="text" name="tipo" value="<%=consuDoc.getTipo()%>" required="required"> <br><br>	
Status: <input type="text" name="status" value="<%=consuDoc.getStatus()%>" required="required"> <br><br>
Analista: <input type="text" name="analista" value="<%=consuDoc.getAnalista()%>" required="required"> <br><br>
Providencia: <input type="text" name="providencia" value="<%=consuDoc.getProvidencia()%>" required="required">
<br>
<br>
<input type="hidden" name="acao" value="alterarDocumento">
<input type="submit" value="Alterar">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>