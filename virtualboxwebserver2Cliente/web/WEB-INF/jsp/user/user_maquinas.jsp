<%-- 
    Document   : admin_maquinas
    Created on : 9/11/2017, 12:12:07 AM
    Author     : AcerF5w10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href=<c:url value="resources/assets/ico/favicon.ico"/>>

    <title>VBWS Administrador</title>

    <!-- Bootstrap core CSS -->
    <link href=<c:url value="resources/assets/css/bootstrap.css"/> rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href=<c:url value="resources/assets/css/style.css"/> rel="stylesheet">
    <link href=<c:url value="resources/assets/css/font-awesome.min.css"/> rel="stylesheet">
    <link href=<c:url value="resources/assets/js/fancybox/jquery.fancybox.css"/> rel="stylesheet" />
    <!-- Tabla Bootstrap core CSS -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
    
  </head>

  <body data-spy="scroll" data-offset="0" data-target="#theMenu">

	<!-- Menu -->
	<nav class="menu" id="theMenu">
		<div class="menu-wrap">
			<h1 class="logo"><a href="">Inicio</a></h1>
			<i class="fa fa-times menu-close"></i>
                        <a href="user_maquina_usuario.html?id=${id}" class="smoothScroll">Mis maquinas</a>
                        <a href="index.html" class="smoothScroll">Salir</a>
		</div>
		
		<!-- Menu button -->
		<div id="menuToggle"><i class="fa fa-bars"></i></div>
	</nav>
        <!-- Menu -->
        <!-- Tabla -->

        <div class="container">
          <h2>Maquinas virtuales **** </h2>
          <p>Estas son las maquinas virtuales encontradas:</p>
          
          <div class="table-responsive">          
          <table class="table">
            <thead>
              <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Index</th>
                <th>Memoria</th>
                <th>CPU</th>
                <th>Procesamiento</th>
                <th>Usuario</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${userlist}" var="u">
              <tr>
                <td>${u.id}</td>
                <td>${u.usuNombre}</td>
                <td>${u.usuIndex}</td>
                <td>${u.usoMemoria}</td>
                <td>${u.usoCpu}</td>
                <td>${u.usoProcesamiento}</td>
                <td>${u.usuId}</td>
                <td>
                    <a href="user_ver_maquina.html?id=${u.id}" class="btn btn-info  btn-sm">Ver</a>
                    
                    
                    <a href="user_start.html?nombre=${u.usuNombre}" class="btn btn-success  btn-sm">Iniciar</a>
                    <a href="user_stop.html?nombre=${u.usuNombre}" class="btn btn-success  btn-sm">Detener</a>
                </td>
              </tr>              
              </c:forEach>
                <div class="alert alert-success">
                  <strong>${mensaje}</strong>
                </div>
            </tbody>
          </table>
              
          </div>
        </div>        

        <!-- Tabla -->
        
    </body>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"/>></script>
    <script src=<c:url value="resources/assets/js/classie.js"/>/>></script>
<script src=<c:url value="resources/assets/js/bootstrap.min.js"/>></script>
        <script src=<c:url value="resources/assets/js/smoothscroll.js"/>></script>
        <script src=<c:url value="resources/assets/js/jquery.stellar.min.js"/>></script>
            <script src=<c:url value="resources/assets/js/fancybox/jquery.fancybox.js"/>></script>    
            <script src=<c:url value="resources/assets/js/main.js"/>></script>
		<script>
		$(function(){
			$.stellar({
				horizontalScrolling: false,
				verticalOffset: 40
			});
		});
		</script>
		
		<script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });
	   </script>    
</html>