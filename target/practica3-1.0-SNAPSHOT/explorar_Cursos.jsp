<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Negocio.Profesor"%>
<%@page import="Negocio.Estudiante"%>
<%@page import="Negocio.Inscripcion"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession misession = request.getSession();
    Estudiante estudiante = (Estudiante) request.getSession().getAttribute("estudiante");

    if (estudiante == null) {
        response.sendRedirect("sinLogin.jsp");
        return;
    }

    List<Profesor> profes = (List<Profesor>)request.getSession().getAttribute("lista");
    
    if (profes == null || profes.isEmpty()) {
        out.println("<p>No hay profesores disponibles.</p>");
        return;
    }

    // Obtener la lista de inscripciones del estudiante
    List<Inscripcion> inscripciones = estudiante.getInscripcion();
    List<Curso> cursosInscritos = new ArrayList<>();
    
  

%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Explora todos los cursos disponibles">
    <meta name="author" content="">
    <title>Explorar Cursos</title>
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

    <header class="masthead bg-primary text-white text-center">
        <div class="container d-flex align-items-center flex-column">
            <h1 class="masthead-heading text-uppercase mb-0">Explora Nuestros Cursos</h1>
            <p class="masthead-subheading font-weight-light mb-0">Descubre nuevas oportunidades de aprendizaje</p>
        </div>
    </header>

    <section class="page-section bg-light">
        <div class="container">
            <h2 class="section-heading text-center text-uppercase">Cursos Disponibles</h2>
            <div class="row">
                <% 
                 for (Inscripcion inscripcion : inscripciones) {
  
        cursosInscritos.add(inscripcion.getCurso());
    }
    

    
    %>
    
    
              
              <% for (Profesor profe : profes) { %>
                    <% for (Curso curso : profe.getLista()) { %>
                        <% 
                            // Verificar si el curso está en la lista de cursos inscritos
                         boolean isInscrito = false;
                for (Curso inscrito : cursosInscritos) {
                    if (inscrito != null && inscrito.getCodigo() == curso.getCodigo()) { 
        isInscrito = true;
        break;
    }
                }
                if (isInscrito) {
                    continue; // Saltar a la siguiente iteración si el curso ya está inscrito
                }

                            String base64Image = "";
                            if (curso.getImagen() != null) {
                                base64Image = Base64.getEncoder().encodeToString(curso.getImagen());
                            }
                        %>
                        
                       
                        <div class="col-md-4 mb-4">
                            <div class="card h-100">
                                <div class="card-body">
                                    <a href="CursoMostrar?nombre=<%= curso.getCodigo() %>">
                                        <img class="card-img-top img-fluid" src="data:image/jpeg;base64,<%= base64Image %>" alt="Imagen del Curso" style="height: 200px; object-fit: cover; width: 100%;">
                                    </a>
                                    <h5 class="card-title"><%= curso.getNombre() %></h5>
                                    <p class="card-text"><%= profe.getNombre() %></p>
                                    <p class="card-text"><%= curso.getSubtitulo() %></p>
                                    <p class="card-text"><%= curso.getPrecio() %></p>
                                </div>
                                <div class="card-footer">
                                    <a href="Bolsa?id=<%= curso.getCodigo() %>" class="btn btn-primary">Agregar a la Bolsa</a>
                                </div>
                            </div>
                        </div>
                    <% } %>
                <% } %>
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
