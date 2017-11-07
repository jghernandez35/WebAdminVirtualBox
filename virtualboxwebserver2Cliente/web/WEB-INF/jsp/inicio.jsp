<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  <link rel="shortcut icon" href=<c:url value="resources/assets/ico/favicon.ico"/>>

    <title>VirtualBox WebServer</title>

    <!-- Bootstrap core CSS -->
    <link href=<c:url value="resources/assets/css/bootstrap.css"/> rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href=<c:url value="resources/assets/css/style.css"/> rel="stylesheet">
    <link href=<c:url value="resources/assets/css/font-awesome.min.css"/> rel="stylesheet">
    <link href=<c:url value="resources/assets/js/fancybox/jquery.fancybox.css"/> rel="stylesheet" />

  </head>

  <body data-spy="scroll" data-offset="0" data-target="#theMenu">

	<section id="home" name="home"></section>
	<div id="headerwrap">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
                                    <form class="login" action="iniciarsesion.html" modelAttribute="sesion">
                                        <h2 class="login-title">Inicio de sesión</h2>
                                        <input type="text" name="email" class="login-input" placeholder="Usuario" autofocus>
                                        <input type="password" name="contrasena" class="login-input" placeholder="Contraseña">
                                        <input type="submit" value="Continuar" class="login-button">
                                      <p class="login-lost"><a href="index.html">Cancelar</a></p>
                                    </form>                                    
				</div>
			</div><! --/row -->
		</div><! --/container -->
	</div><! --/headerwrap -->
    </body>
</html>
