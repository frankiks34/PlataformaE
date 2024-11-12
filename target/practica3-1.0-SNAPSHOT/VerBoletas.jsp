<%@page import="Negocio.Boleta"%>
<%@page import="Negocio.Controlador"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession misession = request.getSession();
    Estudiante estudiante = (Estudiante) request.getSession().getAttribute("estudiante");

    if (estudiante == null) {
        response.sendRedirect("sinLogin.jsp");
    }

    Controlador controlador = new Controlador();
    List<Boleta> boletas = estudiante.getBoletas(); // Método para obtener todas las boletas del estudiante
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Mis Boletas">
    <title>Mis Boletas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Barra de navegación común -->
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

<div class="container mt-5">
    <h2 class="text-center text-uppercase">Mis Boletas</h2>
    <div class="row">
        <% if (boletas != null && !boletas.isEmpty()) { 
            for (Boleta boleta : boletas) { 
        %>
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <p><strong>Curso:</strong>
  <%= boleta.getCurso().getNombre() %></p>
                        <p><strong>Monto:</strong> $<%= boleta.getMonto() %></p>
                        <p><strong>Estado de Pago:</strong> <%= boleta.getEstadoPago() %></p>
                        <p><strong>Fecha de Transacción:</strong> <%= boleta.getFechaTransaccion() %></p>
                        <p><strong>Descripción:</strong> <%= boleta.getDescripcion() %></p>
                        <p><strong>PaymentIntent ID:</strong> <%= boleta.getPaymentIntentId() %></p>
                        <p><strong>PaymentMethod ID:</strong> <%= boleta.getPaymentMethodId() %></p>
                    </div>
                </div>
            </div>
        <% } } else { %>
            <p class="text-center">No tienes boletas registradas actualmente.</p>
        <% } %>
    </div>
</div>

<!-- Footer -->
<footer class="footer bg-dark text-white text-center mt-5">
    <div class="container">
        <small>&copy; 2024 Mi Plataforma de Cursos - Todos los derechos reservados</small>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>