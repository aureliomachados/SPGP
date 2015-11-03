<%@page import="mvc.DAO.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="validaSessao.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
<jsp:include page="partes/cabecalho.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partes/menu.jsp"></jsp:include>

<%
UsuarioDAO usuarioDAO = new UsuarioDAO();

ResultSet rs =  usuarioDAO.listarUsuario();
%>
<div class="col-md-10">
			<div  class="panel panel-default">
				<div class="panel-heading panel-title text-center">Cadastro de Documento</div>

				<div class="panel-body">
			
					<form action="controleDocumento" method="post"
						class="form-vertical">
						<div class="form-group">
							Nome: <input type="text" name="nome" required="required"> <br>
							<br>
							CPF/CNPJ: <input type="text" name="cpf_cnpj" required="required" min="11" maxlength="16"> <br>
							<br>
							Tipo: <select name="tipo" required="required">
								<option>Selecione</option>
								<option>Oficio</option>
								<option>Requerimento</option>
								<option>Carta</option>
								<option>Outro</option>
							</select><br>
							<br>	
							Numero do Documento: <input type="number" name="numDoc" required="required"> <br>
							<br>
							Data do Documento: <input type="date" name="dataDoc" required="required"> <br>
							<br>
							Assunto: <input type="text" name="assunto" required="required"> <br>
							<br>
							Data da Entrada: <input type="date" name="dataEntrada" required="required"> <br>
							<br>
							Analista: <select name="analista">
							<% while(rs.next()){ %>
								<option value="<%=rs.getInt("id")%>"><%=rs.getString("nome")%></option>
							<% }%>
							
							</select> <br>								
						</div>
						<input type="hidden" name="acao"
							value="inserirDocumento">
							
							 <input type="submit"
							value="Inserir" class="btn btn-success">
							
							 <input type="submit"
							value="Cancelar" onClick="history.go(-1)" class="btn btn-sm btn-default">
					</form>					
				</div>
			</div>
			<br>
		</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<footer>
    <div class="container">
        <hr>
        <div class="row">
            <div align="center" class="col-lg-12 footer-below">
                <p>Criado por Bruno Martins e Carlos Guerra.
                <br>                2015</p>
            </div>
        </div>
    </div>
</footer>
</body>		
</html>