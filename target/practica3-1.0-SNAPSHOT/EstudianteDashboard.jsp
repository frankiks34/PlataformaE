


<%@page import="Negocio.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


   <% HttpSession misession = request.getSession();
    Estudiante estudiante =(Estudiante)request.getSession().getAttribute("estudiante");
    
    if (estudiante==null) {
            response.sendRedirect("sinLogin.jsp");
        }
    
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Dashboard del Estudiante">
    <meta name="author" content="">
    <title>Dashboard del Estudiante</title>
    <!-- Bootstrap CSS -->
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
                <li class="nav-item"><a class="nav-link" href="MisCursosEstudiante.jsp">Mis Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="Cursos.jsp">Explorar Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="miPerfilE.jsp">Mi Perfil</a></li>
                <li class="nav-item"><a class="nav-link" href="BolsaCompras.jsp">Bolsa de Compras</a></li>
                <li class="nav-item"><a class="nav-link" href="cerrar_Sesion">Cerrar Sesión</a></li>
            </ul>
        </div>
    </div>
</nav>


<header class="masthead bg-primary text-white text-center">
    <div class="container d-flex align-items-center flex-column">
        <h1 class="masthead-heading text-uppercase mb-0">Bienvenido, Estudiante</h1>
        <p class="masthead-subheading font-weight-light mb-0">Accede a tus cursos y explora nuevas oportunidades de aprendizaje</p>
    </div>
</header>


<section class="page-section bg-light text-center">
    <div class="container">
        <h2 class="section-heading text-uppercase">Opciones Rápidas</h2>
        <div class="row">
            <div class="col-md-4">
                <a href="MisCursosEstudiante.jsp" class="btn btn-primary btn-lg">Mis Cursos</a>
            </div>
            <div class="col-md-4">
                <a href="Cursos.jsp" class="btn btn-secondary btn-lg">Explorar Cursos</a>
            </div>
            <div class="col-md-4">
                <a href="BolsaCompras.jsp" class="btn btn-warning btn-lg">Bolsa de Compras</a>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="footer bg-dark text-white text-center">
    <div class="container">
        <small>&copy; 2024 Mi Plataforma de Cursos - Todos los derechos reservados</small>
    </div>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>