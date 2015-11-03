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
<H2>Inserir Providencia</H2> <br> <br>
<%
	Documento consulDoc = (Documento) request.getAttribute("provideDeta");

%>

<form action="controleDocumento" method="post">

Codigo do Processo: <input type="number" name="numProtocolo" value="<%=consulDoc.getNumProtocolo()%>" readonly="readonly">
Nome: <%=consulDoc.getNomeInteressado()%><br><br>     
CPF/CNPJ: <%=consulDoc.getCpf_cnpj()%> <br><br>
Tipo: <%=consulDoc.getTipo()%> <br><br>
Numero do Documento: <%=consulDoc.getNumDoc()%> <br><br>
Data do Documento: <%=consulDoc.getDataDoc()%> <br><br>
Assunto: <%=consulDoc.getAssunto()%><br><br>
Data da Entrada: <%=consulDoc.getDataEntrada()%> <br><br>
Status: <%=consulDoc.getStatus()%> <br><br>
Data de Encerramento: <%=consulDoc.getDataEncerramento()%> <br><br>
Analista: <%=consulDoc.getAnalista()%><br><br>
Providencia: <input type="text" name="providencia" value="<%=consulDoc.getProvidencia()%>" required="required">
<br>
<br>
<input type="hidden" name="acao" value="inserirProvidenc">
<input type="submit" value="OK">
<input type="button" value="Cancelar" onClick="history.go(-1)"> <br>
</form>
</body>
</html>