<%@page import="Negocio.Profesor"%>
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
    <meta name="description" content="Crear Curso">
    <meta name="author" content="">
    <title>Crear Curso - Plataforma de Cursos</title>
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
    <div class="container">
        <h1 class="masthead-heading text-uppercase mb-0">Crear Nuevo Curso</h1>
        <p class="masthead-subheading font-weight-light mb-0">Diseña y publica un nuevo curso</p>
    </div>
</header>

<section class="page-section" id="crear-curso">
    <div class="container">
        <form action="CrearCurso" method="POST" enctype="multipart/form-data">
            
            <div class="mb-3">
                <label for="nombreCurso" class="form-label">Nombre del Curso</label>
                <input type="text" class="form-control" id="nombreCurso" name="nombre" placeholder="Nombre del curso" required>
            </div>
            <div class="mb-3">
                <label for="precioCurso" class="form-label">Precio</label>
                <input type="number" class="form-control" id="precioCurso" name="precio" placeholder="Precio del curso"  required>
            </div>
            <div class="mb-3">
            <label for="profesorCurso" class="form-label">Descripcion</label>
            <input type="text" class="form-control" id="descripcioncurso" name="descripcion" value="">
            </div> 
             <div class="mb-3">
                <label for="subtituloCurso" class="form-label">Subtítulo</label>
                <input type="text" class="form-control" id="subtituloCurso" name="subtitulo" placeholder="Subtítulo del curso" required>
            </div>
            <div class="mb-3">
                <label for="imagenCurso" class="form-label">Imagen</label>
                <input type="file" class="form-control" id="imagenCurso" name="imagen" accept="image/*" required>
            </div>
            
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Publicar Curso</button>
            </div>
        </form>
    </div>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
