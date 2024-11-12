

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
    <meta name="description" content="Perfil del Estudiante">
    <meta name="author" content="">
    <title>Mi Perfil - Dashboard del Estudiante</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
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
    <div class="container">
        <h1 class="masthead-heading text-uppercase mb-0">Mi Perfil</h1>
        <p class="masthead-subheading font-weight-light mb-0">Visualiza y actualiza tu información personal y académica</p>
    </div>
</header>

<section class="page-section" id="mi-perfil">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Detalles del Perfil</h2>
            <h3 class="section-subheading text-muted">Información del Estudiante</h3>
        </div>
        
  
        <form action="editarprofe" method="POST">
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="nombreEstudiante" class="form-label">Nombre Completo</label>
                    <input type="text" class="form-control" id="nombreEstudiante" name="nombre" value="<%=estudiante.getNombre() %>" disabled>
                </div>
                <div class="col-md-6">
                    <label for="apellidoEstudiante" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellidoEstudiante" name="apellido" value="<%=estudiante.getApellido() %>" disabled>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="emailEstudiante" class="form-label">Correo Electrónico</label>
                    <input type="email" class="form-control" id="emailEstudiante" name="email" value="<%=estudiante.getEmail() %>" disabled>
                     <input type="hidden" name="id" value="1">
                </div>
                <div class="col-md-6">
                    <label for="universidadEstudiante" class="form-label">Universidad</label>
                    <input type="text" class="form-control" id="universidadEstudiante" name="universidad" value="<%=estudiante.getUniversidad() %>" disabled>
                </div>
            </div>

            <div class="text-center">
                <button type="button" class="btn btn-secondary" id="editButton">Editar Información</button>
                <button type="submit" class="btn btn-primary" id="saveButton" style="display:none;">Guardar Cambios</button>
            </div>
        </form>
    </div>
</section>

<!-- Footer -->
<footer class="footer bg-dark text-white text-center">
    <div class="container">
        <small>&copy; 2024 Mi Plataforma de Cursos - Todos los derechos reservados</small>
    </div>
</footer>

<script>
document.getElementById('editButton').addEventListener('click', () => {

    document.getElementById('nombreEstudiante').disabled = false;
    document.getElementById('apellidoEstudiante').disabled = false;
    document.getElementById('emailEstudiante').disabled = false;
    document.getElementById('universidadEstudiante').disabled = false;


    document.getElementById('saveButton').style.display = 'inline-block';
    document.getElementById('editButton').style.display = 'none';
});

document.getElementById('saveButton').addEventListener('click', () => {
  
    document.getElementById('nombreEstudiante').disabled = false;
    document.getElementById('apellidoEstudiante').disabled = false;
    document.getElementById('emailEstudiante').disabled = false;
    document.getElementById('universidadEstudiante').disabled = false;
    
    document.querySelector('form').submit();
});
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>