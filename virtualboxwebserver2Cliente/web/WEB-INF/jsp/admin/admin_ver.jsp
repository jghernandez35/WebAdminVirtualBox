<%-- 
    Document   : admin_ver
    Created on : 5/11/2017, 09:05:18 PM
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
			<h1 class="logo"><a href="indexa.html">Inicio</a></h1>
			<i class="fa fa-times menu-close"></i>
			<a href="admin_usuarios.html" class="smoothScroll">Usuarios</a>
                        <a href="index.html" class="smoothScroll">Salir</a>
		</div>
		
		<!-- Menu button -->
		<div id="menuToggle"><i class="fa fa-bars"></i></div> 
	</nav>
        <!-- Menu -->
        <!-- Formularo para agregar un usuario -->
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
                                <h1>Ver Información del usuario</h1>
                                <h3>____________________</h3> 
                                <form action="admin_usuarios.html" class="form-horizontal">
                                
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="id">Id:</label>
                                    <div class="col-sm-10">
                                        <input readonly="true" type="text" class="form-control"  name="id" placeholder="${usuario.id}">
                                    </div>
                                  </div>
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="identificacion">Identificación:</label>
                                    <div class="col-sm-10">
                                      <input readonly="true" type="text" class="form-control" name="identificacion" placeholder="${usuario.identificacion}">
                                    </div>
                                  </div>                           
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="nombres">Nombres:</label>
                                    <div class="col-sm-10">
                                      <input readonly="true" type="text" class="form-control" name="nombres" placeholder="${usuario.nombres}">
                                    </div>
                                  </div>                             
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="apellidos">Apellidos:</label>
                                    <div class="col-sm-10">
                                      <input readonly="true" type="text" class="form-control" name="apellidos" placeholder="${usuario.apellidos}">
                                    </div>
                                  </div>                              
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Usuario:</label>
                                    <div class="col-sm-10">
                                      <input readonly="true" type="text" class="form-control" name="email" placeholder="${usuario.email}">
                                    </div>
                                  </div>
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="celular">celular:</label>
                                    <div class="col-sm-10">
                                      <input readonly="true" type="text" class="form-control" name="celular" placeholder="${usuario.celular}">
                                    </div>
                                  </div>                                    
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="telefono">Telefono:</label>
                                    <div class="col-sm-10">
                                      <input readonly="true" type="text" class="form-control" name="telefono" placeholder="${usuario.telefono}">
                                    </div>
                                  </div>                           
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="tipousuario">Tipousuario:</label>
                                    <div class="col-sm-10">
                                      <input readonly="true" type="text" class="form-control" name="tipousuario" placeholder="${usuario.tipousuario}">
                                    </div>
                                  </div>                                                                                                                                                 
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="contrasena">Password:</label>
                                    <div class="col-sm-10"> 
                                      <input readonly="true" type="text" class="form-control" name="contrasena" placeholder="******************">
                                    </div>
                                  </div>
                                  <div class="form-group"> 
                                    <div class="col-sm-offset-2 col-sm-10">
                                      <button readonly="true" type="submit" class="btn btn-default">Atras</button>
                                    </div>
                                  </div>
                                
                                </form>                                    
				</div>
			</div><! --/row -->
		</div><! --/container -->        
        
    
        <!-- Formularo para agregar un usuario -->
        
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
