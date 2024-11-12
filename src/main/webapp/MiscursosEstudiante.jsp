<%@page import="java.util.Base64"%>
<%@page import="Negocio.Estudiante"%>
<%@page import="Negocio.Curso"%>
<%@page import="Negocio.Inscripcion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession misession = request.getSession();
    Estudiante estudiante = (Estudiante) request.getSession().getAttribute("estudiante");

    if (estudiante == null) {
        response.sendRedirect("sinLogin.jsp");
    }

    List<Inscripcion> inscripciones = estudiante.getInscripcion();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Cursos Inscritos">
    <title>Mis Cursos Inscritos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="EstudianteDashboard.jsp">LearnHub - Estudiante</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="MiscursosEstudiante.jsp">Mis Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="Motrar_cursos">Explorar Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="miPerfilE.jsp">Mi Perfil</a></li>
                <li class="nav-item"><a class="nav-link" href="Bolsa">Bolsa de Compras</a></li>
                <li class="nav-item"><a class="nav-link" href="cerrar_Sesion">Cerrar Sesión</a></li>
            </ul>
        </div>
    </div>
</nav>

<header class="masthead bg-primary text-white text-center">
    <div class="container d-flex align-items-center flex-column">
        <h1 class="masthead-heading text-uppercase mb-0">Mis Cursos Inscritos</h1>
        <p class="masthead-subheading font-weight-light mb-0">Accede a tus cursos o consulta todas tus boletas</p>
    </div>
</header>

<section class="page-section bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <h2 class="section-heading text-center text-uppercase">Cursos Inscritos</h2>
                <div class="row">
                    <% if (inscripciones != null && !inscripciones.isEmpty()) { 
                        for (Inscripcion inscripcion : inscripciones) { 
                            Curso curso = inscripcion.getCurso();
                            String base64Image = curso.getImagen() != null ? Base64.getEncoder().encodeToString(curso.getImagen()) : "";
                    %>
                        <div class="col-md-4 mb-4">
                            <div class="card h-100">
                                <img class="card-img-top img-fluid" src="data:image/jpeg;base64,<%= base64Image %>" alt="Imagen del curso" style="height: 200px; object-fit: cover; width: 100%;">
                                <div class="card-body">
                                    <h5 class="card-title"><%= curso.getNombre() %></h5>
                                    <p class="card-text"><%= curso.getDescripcion() %></p>
                                </div>
                                <div class="card-footer text-center">
                                    <a href="VerCurso.jsp?cursoId=<%= curso.getCodigo() %>" class="btn btn-primary">Ir a Curso</a>
                                </div>
                            </div>
                        </div>
                    <% } } else { %>
                        <p class="text-center">No tienes cursos inscritos actualmente.</p>
                    <% } %>
                </div>
            </div>
            <!-- Botón de Ver Boletas al lado derecho -->
            <div class="col-md-3 text-center align-self-center">
                <a href="VerBoletas.jsp" class="btn btn-lg btn-secondary">Ver Boletas</a>
            </div>
        </div>
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