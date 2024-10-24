<%@page import="java.util.Base64"%>
<%@page import="Negocio.Estudiante"%>
<%@page import="Negocio.Curso"%>
<%@page import="Negocio.bolsa_Compras"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    HttpSession misession = request.getSession();
    Estudiante estudiante =(Estudiante)request.getSession().getAttribute("estudiante");

   if (estudiante==null) {
            response.sendRedirect("sinLogin.jsp");
        }
    bolsa_Compras a = (bolsa_Compras)request.getSession().getAttribute("bol");
    List<Curso> cursos = a.getCursos();
%>

<!DOCTYPE html>
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
                <li class="nav-item"><a class="nav-link" href="MisCursosEstudiante.jsp">Mis Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="Motrar_cursos">Explorar Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="miPerfilE.jsp">Mi Perfil</a></li>
                <li class="nav-item"><a class="nav-link" href="BolsaCompras.jsp">Bolsa de Compras</a></li>
                <li class="nav-item"><a class="nav-link" href="cerrar_Sesion">Cerrar Sesión</a></li>
            </ul>
        </div>
    </div>
</nav>

<header class="masthead bg-primary text-white text-center">
    <div class="container">
        <h1 class="masthead-heading text-uppercase mb-0">Tu Bolsa de Compras</h1>
        <p class="masthead-subheading font-weight-light mb-0">Revisa y completa tus compras</p>
    </div>
</header>

<section class="page-section bg-light text-center">
    <div class="container">
        <h2 class="section-heading text-uppercase">Cursos en tu Bolsa</h2>
        
        <div class="row">
            <% if (cursos != null && !cursos.isEmpty()) { 
                for (Curso curso : cursos) { %>
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <img class="card-img-top" src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(curso.getImagen()) %>" alt="Imagen del curso">
                            <div class="card-body">
                                <h5 class="card-title"><%= curso.getNombre() %></h5>
                                <p class="card-text"><%= curso.getDescripcion() %></p>
                                <p class="card-text text-muted">$<%= curso.getPrecio() %></p>
                            </div>
                            <div class="card-footer">
                                <a href="removerCursoBolsa?cursoId=<%= curso.getCodigo()%>" class="btn btn-danger">Eliminar</a>
                            </div>
                        </div>
                    </div>
            <% } } else { %>
                <p>No hay cursos en tu bolsa de compras.</p>
            <% } %>
        </div>
        
         <div class="row">
            <div class="col-md-12 text-right">
                <h3>Total a pagar: $<%=a.totalimporte()%></h3>
            </div>
        </div>
        

        <a href="comprarCursos" class="btn btn-success btn-lg">Completar Compra</a>
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
<script src="js/scripts.js"></script>
</body>
</html>
