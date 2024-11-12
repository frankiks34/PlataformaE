<%@page import="Negocio.Curso"%>
<%@page import="Negocio.bolsa_Compras"%>
<%@page import="Negocio.Inscripcion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.Estudiante"%>
<%@page import="Negocio.Profesor"%>
<!DOCTYPE html>

<% 
        HttpSession misession = request.getSession();
        Estudiante estudiante =(Estudiante)request.getSession().getAttribute("estudiante");

       if (estudiante==null) {
                response.sendRedirect("sinLogin.jsp");
            }
        bolsa_Compras a = (bolsa_Compras)request.getSession().getAttribute("bol");
        List<Curso>cursos = a.getCursos();


    %>

<html lang="en">
  <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Bolsa de Compras">
        <meta name="author" content="">
        <title>Bolsa de Compras - Plataforma de Cursos</title>
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
                <li class="nav-item"><a class="nav-link" href="MiscursosEstudiante.jsp">Mis Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="Motrar_cursos">Explorar Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="miPerfilE.jsp">Mi Perfil</a></li>
                <li class="nav-item"><a class="nav-link" href="Bolsa">Bolsa de Compras</a></li>
                <li class="nav-item"><a class="nav-link" href="cerrar_Sesion">Cerrar Sesión</a></li>
            </ul>
            </div>
        </div>
    </nav>

<div class="container text-center mt-5">
    <h1 class="text-success">¡Compra Exitosa!</h1>
    <p>Tu pago se ha procesado correctamente y has sido inscrito en los cursos seleccionados.</p>
    <a href="MisCursosEstudiante.jsp" class="btn btn-primary">Ver Mis Cursos</a>
</div>
        
           <footer class="footer bg-dark text-white text-center">
        <div class="container">
            <small>&copy; 2024 Mi Plataforma de Cursos - Todos los derechos reservados</small>
        </div>
    </footer>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
