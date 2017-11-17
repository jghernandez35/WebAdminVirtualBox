<%-- 
    Document   : admin_agregar_maquina
    Created on : 9/11/2017, 09:45:13 AM
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
                        <a href="admin_maquinas.html" class="smoothScroll">Maquinas Virtuales</a>
                        <a href="index.html" class="smoothScroll">Salir</a>
		</div>
		
		<!-- Menu button -->
		<div id="menuToggle"><i class="fa fa-bars"></i></div>
	</nav>
        <!-- Menu -->
        <!-- Formularo para agregar una maquina -->
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
                                <h1>Agregar nueva maquina virtual</h1>
                                <h3>____________________</h3> 
                                <form action="admin_agregar_maquina2.html" class="form-horizontal"  modelAttribute="maquina">
                                  <span><label for="camposid">Campos Obligatorios (*)</label></span>
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="id">Id *:</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control"  name="id" placeholder="Ingrese el id" required="true">
                                    </div>
                                  </div>                          
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="usuNombre">Nombres *:</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" name="usuNombre" placeholder="Ingrese el nombre de la maquina virtual" required="true">
                                    </div>
                                  </div>                             
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="usuIndex">Index *:</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" name="usuIndex" placeholder="Ingrese el index de la maquina virtual" required="true" >
                                    </div>
                                  </div>                              
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="usoMemoria">Memoria *:</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control" name="usoMemoria" placeholder="Ingrese el uso de memoria" required="true">
                                    </div>
                                  </div>
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="usoCpu">CPU *:</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control" name="usoCpu" placeholder="Ingrese el uso de CPU" required="true">
                                    </div>
                                  </div>                                    
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="usoProcesamiento">Procesamiento *:</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control" name="usoProcesamiento" placeholder="Ingrese el uso de procesamiento" required="true">
                                    </div>
                                  </div>         
                                  <div class="form-group">
                                    <label class="control-label col-sm-2" for="usuId">Usuario *:</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control" name="usuId" placeholder="Ingrese el usuario propietario" required="true">
                                    </div>
                                  </div>                                   
                                  <div class="form-group"> 
                                    <div class="col-sm-offset-2 col-sm-10">
                                      <button type="submit" class="btn btn-default">Agregar Maquina</button>
                                      <a href="admin_maquinas.html" class="btn btn-default">Cancelar</a>
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
