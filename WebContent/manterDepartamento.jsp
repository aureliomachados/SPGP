<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="validaSessao.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPGP</title>
<jsp:include page="partes/cabecalho.jsp"></jsp:include>
</head>
<body>
<jsp:include page="partes/menuAdm.jsp"></jsp:include>
		<div class="container">

		<div>
			<h3 align="center">Manter Departamento</h3>
		</div>
<br><br><br><br>
<div class="col-md-3">
			<div class="panel panel-default">
				<div class="panel-heading panel-title text-center">Menu</div>
				<div class="panel-body"> 
				<ul class="nav nav-list">
				<li><a href="inserirDepartamento.jsp"> INCLUIR </a></li>
				<li><a href="controleDpto?acao=listarDpto"> CONSULTAR  </a></li>
				</ul>		
				</div>
		</div>
	</div>
</div>	
<br><br><br><br><br><br><br><br><br><br>
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