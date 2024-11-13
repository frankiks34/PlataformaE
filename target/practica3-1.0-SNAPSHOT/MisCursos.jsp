

<%@page import="java.util.Base64"%>
<%@page import="Negocio.Curso"%>
<%@page import="Negocio.Profesor"%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.nio.file.Files"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    HttpSession misession = request.getSession();
    Profesor profesor = (Profesor)request.getSession().getAttribute("profesor");

    if (profesor == null) {
        response.sendRedirect("sinLogin.jsp");
    }
    
 %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Mis Cursos">
    <meta name="author" content="">
    <title>Mis Cursos - Dashboard del Profesor</title>
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>
    
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="ProfesorDashboard.jsp">LearnHub - Profesor</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto"> 
                <li class="nav-item"><a class="nav-link" href="MisCursos.jsp">Mis Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="MiPerfil.jsp">Mi Perfil</a></li>
                <li class="nav-item"><a class="nav-link" href="cerrar_Sesion">Cerrar Sesión</a></li>
            </ul>
        </div>
    </div>
</nav>


<header class="masthead bg-primary text-white text-center">
    <div class="container">
        <h1 class="masthead-heading text-uppercase mb-0">Mis Cursos</h1>
        <p class="masthead-subheading font-weight-light mb-0">Gestiona y Crea Nuevos Cursos</p>
    </div>
</header>

<section class="page-section" id="mis-cursos">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Cursos Actuales</h2>
            <h3 class="section-subheading text-muted">Lista de cursos que estás impartiendo</h3>
        </div>
        
   
        <div class="row">
            <% 
                int count = 0; 
                for (Curso curso : profesor.getLista()) { 
                    if (count % 3 == 0 && count != 0) { 
            %>
                </div> 
                <div class="row mt-4"> 
            <% 
                    }
  String base64Image = "";
            if (curso.getImagen() != null) {
                base64Image = Base64.getEncoder().encodeToString(curso.getImagen());
            }

            %>
           
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <img class="card-img-top img-fluid" src="data:image/jpeg;base64,<%= base64Image %>" alt="Imagen del Curso" style="height: 200px; object-fit: cover; width: 100%;">
                     
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title"><%= curso.getNombre() %></h5>
                        <p class="card-text"><%= curso.getSubtitulo() != null ? curso.getSubtitulo() : "Sin subtítulo disponible" %></p>
                        <h6 class="card-subtitle mb-2 text-muted"><%= curso.getPrecio() != null ? curso.getPrecio() + " USD" : "Precio no disponible" %></h6>
                        <a href="#" class="btn btn-warning text-white mt-auto">Administrar Curso</a>
                    </div>
                </div>
            </div>
            <% 
                count++; 
                } 
            %>
        </div> <!-- Cerrar fila -->
    </div>
</section>

        
        <footer class="footer bg-dark text-white text-center">
    <div class="container">
        <small>&copy; 2024 Mi Plataforma de Cursos - Todos los derechos reservados</small>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>