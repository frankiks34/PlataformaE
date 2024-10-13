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
    <meta name="description" content="Perfil del Profesor">
    <meta name="author" content="">
    <title>Mi Perfil - Dashboard del Profesor</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="ProfesorDashboard.jsp">LearnHub - Profesor</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="ProfesorDashboard.jsp">Dashboard</a></li>
                <li class="nav-item"><a class="nav-link" href="MisCursos.jsp">Mis Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="cerrar_Sesion">Cerrar Sesión</a></li>
            </ul>
        </div>
    </div>
</nav>

<header class="masthead bg-primary text-white text-center">
    <div class="container">
        <h1 class="masthead-heading text-uppercase mb-0">Mi Perfil</h1>
        <p class="masthead-subheading font-weight-light mb-0">Visualiza y actualiza tu información personal y profesional</p>
    </div>
</header>

<section class="page-section" id="mi-perfil">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Detalles del Perfil</h2>
            <h3 class="section-subheading text-muted">Información del Profesor</h3>
        </div>
        
        <!-- Información del Perfil -->
        <form action="editarprofe" method="POST">
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="nombreProfesor" class="form-label">Nombre Completo</label>
                    <input type="text" class="form-control" id="nombreProfesor" name="nombre" value=" <%=profesor.getNombre() %>" disabled>
                </div>
                <div class="col-md-6">
                    <label for="apellidoProfesor" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellidoProfesor" name="apellido" value="<%=profesor.getApellido() %>" disabled>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="emailProfesor" class="form-label">Correo Electrónico</label>
                    <input type="email" class="form-control" id="emailProfesor" name="email" value="<%=profesor.getEmail() %>" disabled>
                    <input type="hidden" name="id" value="2">
                </div>
              
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="experienciaProfesor" class="form-label">Años de Experiencia</label>
                    <input type="number" class="form-control" id="experienciaProfesor" value="<%=profesor.getExperiancia() %>" disabled>
                </div>
                <div class="col-md-6">
                    <label for="carreraProfesor" class="form-label">Carrera</label>
                    <input type="text" class="form-control" id="carreraProfesor" value="<%=profesor.getCarrera() %>" disabled>
                    
                   
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

<!-- JavaScript para habilitar la edición -->
<script>
document.getElementById('editButton').addEventListener('click', () => {
    // Habilitar campos de texto para editar
    document.getElementById('nombreProfesor').disabled = false;
    document.getElementById('apellidoProfesor').disabled = false;
    document.getElementById('emailProfesor').disabled = false;
   
    document.getElementById('experienciaProfesor').disabled = false;
    document.getElementById('carreraProfesor').disabled = false;

    // Mostrar el botón de guardar y ocultar el botón de editar
    document.getElementById('saveButton').style.display = 'inline-block';
    document.getElementById('editButton').style.display = 'none';
});

document.getElementById('saveButton').addEventListener('click', () => {
    // Enviar formulario con los campos habilitados
    document.getElementById('nombreProfesor').disabled = false;
    document.getElementById('apellidoProfesor').disabled = false;
    document.getElementById('emailProfesor').disabled = false;
    document.getElementById('experienciaProfesor').disabled = false;
    document.getElementById('carreraProfesor').disabled = false;
    
    document.querySelector('form').submit(); // Esto enviará el formulario
});


</script>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>