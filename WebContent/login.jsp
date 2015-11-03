<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> SPGP</title>
<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">

<jsp:include page="partes/cabecalho.jsp"></jsp:include>
</head>
<body>
	<br>

	<div class="container">

		<div class="jumbotron">
			<h3 align="center">Sistema de Protocolo e Gerenciamento de
				Processos</h3>
		</div>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">

				<form class="form-horizontal" action="controleLogin" method="post">
					<fieldset>

						<!-- Form Name -->
						<legend>Fazer login</legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="login">Login</label>
							<div class="col-md-4">
								<input id="login" name="login" type="text"
									placeholder="Digite o seu login" class="form-control input-md"
									required="">

							</div>
						</div>

						<!-- Password input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="senha">Senha</label>
							<div class="col-md-4">
								<input id="senha" name="senha" type="password"
									placeholder="Digite sua senha" class="form-control input-md"
									required="">

							</div>
						</div>

						<!-- Button (Double) -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="entrar"></label>
							<div class="col-md-8">
								<button type="submit" id="entrar" name="entrar"
									class="btn btn-success">Entrar</button>
								<button type="reset" id="cancelar" name="cancelar"
									class="btn btn-danger">Cancelar</button>
							</div>
						</div>

					</fieldset>
				</form>
			</div>
		</div>
	</div>	
</body>
</html>