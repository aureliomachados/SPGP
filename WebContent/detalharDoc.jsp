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
<H2>Detalhamento</H2> <br> <br>
<%
	Documento consulDoc = (Documento) request.getAttribute("procDeta");

%>
Codigo do Processo: <%=consulDoc.getNumProtocolo()%><br><br>
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
Providencia: <%=consulDoc.getProvidencia()%>
<br>
<br>
<a href="controleDocumento?numProtocolo=<%=consulDoc.getNumProtocolo()%>&acao=consProvi">Inserir Providencia</a><br>
<br><br>
<input type="button" value="Voltar" onClick="history.go(-1)"> <br>
</body>
</html>