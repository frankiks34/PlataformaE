<%@page import="Negocio.Profesor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <% HttpSession misession = request.getSession();
    Profesor profesor =(Profesor)request.getSession().getAttribute("profesor");
    
    if (profesor==null) {
            response.sendRedirect("sinLogin.jsp");
        }
    
    %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Dashboard del Profesor">
    <meta name="author" content="">
    <title>Dashboard del Profesor</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
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
    <div class="container d-flex align-items-center flex-column">
        <h1 class="masthead-heading text-uppercase mb-0">Bienvenido, Profesor</h1>
        <p class="masthead-subheading font-weight-light mb-0">Administra tus cursos y perfil</p>
    </div>
</header>


<section class="page-section bg-light text-center">
    <div class="container">
        <h2 class="section-heading text-uppercase">Opciones Rápidas</h2>
        <div class="row">
    
            <div class="col-md-4">
                <div class="card shadow-sm mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Crear Curso</h5>
                        <p class="card-text">Aquí puedes crear un nuevo curso, agregar lecciones y establecer el precio.</p>
                        <a href="CrearCurso.jsp" class="btn btn-primary">Crear Curso</a>
                    </div>
                </div>
            </div>
       
            <div class="col-md-4">
                <div class="card shadow-sm mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Mis Cursos</h5>
                        <p class="card-text">Gestiona tus cursos, edita contenido o revisa el estado de los inscritos.</p>
                        <a href="MisCursos.jsp" class="btn btn-secondary">Ver Mis Cursos</a>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card shadow-sm mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Mis Ganancias</h5>
                        <p class="card-text">Consulta el total de ingresos generados por tus cursos hasta la fecha.</p>
                        <a href="MisGanancias.jsp" class="btn btn-success">Ver Mis Ganancias</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<footer class="footer bg-dark text-white text-center">
    <div class="container">
        <small>&copy; 2024 Mi Plataforma de Cursos - Todos los derechos reservados</small>
    </div>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>