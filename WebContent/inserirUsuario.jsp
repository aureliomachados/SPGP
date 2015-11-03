<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="validaSessao.jsp" %> 
<%@page import="mvc.DAO.DepartamentoDAO"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
<jsp:include page="partes/cabecalho.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partes/menuAdm.jsp"></jsp:include>
	<div class="container">
<%
DepartamentoDAO departamentoDAO = new DepartamentoDAO();

ResultSet rs =  departamentoDAO.listarDepartamento();
%>	
	<div class="col-md-10">
			<div  class="panel panel-default">
				<div class="panel-heading panel-title text-center">Cadastro de Usuário</div>

				<div class="panel-body">
			
					<form action="controleUsuario" method="post"
						class="form-vertical">
						<div class="form-group">
							CPF: <input type="text" name="cpf" required="required" min="11" maxlength="11"> <br>
							<br>
							Nome: <input type="text" name="nome" required="required"> <br>
							<br>
							Login: <input type="text" name="login" required="required"> <br>
							<br>
							Senha: <input type="password" name="senha" required="required"> <br>
							<br>
							Perfil: <select name="perfil">
							<option value= null>Selecione</option>
							<option value="Administrado">Administrado</option>
							<option value="Analista">Analista</option>
							<option value="Protocolista">Protocolista</option>
							</select><br>
							<br>
							Departamento: <select name="departamento">
							<option value= null>Selecione</option>
							<% while(rs.next()){ %>
								<option value="<%=rs.getInt("cod_dpto")%>"><%=rs.getString("nome_dpto")%></option>
							<% }%>
							</select><br>
							<br>
							Situacao: <select name="situacao">
							<option value= null>Selecione</option>
							<option value="Ativo">Ativo</option>
							<option value="Desativado">Desativado</option>
							</select><br>
							<br><br>
							</div>
								<input type="hidden" name="acao"
								value="inserirUsuario">
								
								 <input type="submit"
								value="Inserir" class="btn btn-success">
								
								 <input type="submit"
								value="Cancelar" onClick="history.go(-1)" class="btn btn-sm btn-default">
					</form>					
				</div>
			</div>
			<br>
		</div>
		</div>
<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
<br><br><br><br><br>
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
</body>
</html>