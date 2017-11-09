<%-- 
    Document   : ausuarios
    Created on : 5/11/2017, 11:57:25 AM
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
        <!-- Tabla -->

        <div class="container">
          <h2>Usuarios del Sistema</h2>
          <p>Estos son los usuarios registrados en el sistema:</p>
          <a href="admin_agregar.html" class="btn btn-primary">Agregar usuario</a>
          <div class="table-responsive">          
          <table class="table">
            <thead>
              <tr>
                <th>Id</th>
                <th>Identificacion</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Usuario</th>
                <th>celular</th>
                <th>Telefono</th>
                <th>Tipo Usuario</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${userlist}" var="u">
              <tr>
                <td>${u.id}</td>
                <td>${u.identificacion}</td>
                <td>${u.nombres}</td>
                <td>${u.apellidos}</td>
                <td>${u.email}</td>
                <td>${u.celular}</td>
                <td>${u.telefono}</td>
                <td>${u.tipousuario}</td>
                <td>
                    <a href="admin_ver.html?email=${u.email}" class="btn btn-info  btn-sm">Ver</a>
                    <a href="admin_actualizar.html?email=${u.email}" class="btn btn-warning  btn-sm">Actualizar</a>
                    <a href="admin_eliminar.html?id=${u.id}" class="btn btn-danger  btn-sm">Eliminar</a>
                </td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
              <a href="indexa.html" class="btn btn-primary">Inicio</a>
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
