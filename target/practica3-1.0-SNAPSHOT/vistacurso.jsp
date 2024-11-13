
<%@page import="java.util.Base64"%>
<%@page import="Negocio.Curso"%>
<%@page import="Negocio.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


   <% HttpSession misession = request.getSession();
    Estudiante estudiante =(Estudiante)request.getSession().getAttribute("estudiante");
    
    if (estudiante==null) {
            response.sendRedirect("sinLogin.jsp");
        }
    
   Curso curso = (Curso)request.getSession().getAttribute("curso");


    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Dashboard del Estudiante">
    <meta name="author" content="">
    <title>Dashboard del Estudiante</title>
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
</head>

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


<body class= "page-section bg-light">
    <div class="container">
        <div class="row">
          
            <div class="col-md-8">
                <h1><%= curso.getNombre() %></h1>
                <p><strong>Creado por:</strong> <%= curso.getProfesor().getNombre() %></p>
                <p><%= curso.getDescripcion() %></p>

                <div class="course-details">
                    <ul>
                        <li><strong>Calificaciones:</strong> 4.8 ★ (564 calificaciones)</li>
                        <-<!-- comment <li><strong>Estudiantes inscritos:</strong> <%= curso.getInscritos().size() %></li> -->
                        <li><strong>Última actualización:</strong> 2/2024</li>
                        <li><strong>Idioma:</strong> Español</li>
                    </ul>
                </div>

                <h3>Lo que aprenderás</h3>
                <ul>
                    <li>Convertirte en un desarrollador confiable</li>
                    <li>Aprender control de flujo, variables, funciones, etc.</li>
                    <li>Herencia con prototipos y clases</li>
                    <li>Javascript asíncrono con promesas, async/await</li>
                    <!-- Puedes agregar más puntos importantes aquí -->
                </ul>
            </div>

       
            <div class="col-md-4">
                <div class="course-card">
                   
                    <%
                        String base64Image = Base64.getEncoder().encodeToString(curso.getImagen());
                    %>
                    <img src="data:image/png;base64,<%= base64Image %>" alt="Imagen del curso" class="img-fluid">

                    <div class="price">
                        <h3><%= curso.getPrecio() %> S/</h3>
                    </div>

                    <div class="actions">
                        <button class="btn btn-primary">Añadir a la cesta</button>
                        <button class="btn btn-success">Comprar ahora</button>
                    </div>

                    <p><small>Garantía de reembolso de 30 días</small></p>
                    <div class="course-includes">
                        <h5>Este curso incluye:</h5>
                        <ul>
                            <li>13 horas de vídeo bajo demanda</li>
                            <li>Acceso en dispositivos móviles y TV</li>
                            <li>Acceso de por vida</li>
                            <li>Certificado de finalización</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
                  
<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
                    

</html>