

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Plataforma de Cursos Online</title>
    
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
   
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="#page-top">LearnHub</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#cursos">Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="#instructores">Instructores</a></li>
                <li class="nav-item"><a class="nav-link" href="#mis-cursos">Mis Cursos</a></li>
                <li class="nav-item"><a class="nav-link" href="loginPa.jsp">Iniciar sesion</a></li>
            </ul>
        </div>
    </div>
</nav>


<header class="masthead bg-primary text-white text-center">
    <div class="container d-flex align-items-center flex-column">
        <h1 class="masthead-heading text-uppercase mb-0">Bienvenido a la Plataforma de Cursos</h1>
        <p class="masthead-subheading font-weight-light mb-0">Aprende a tu ritmo, con los mejores instructores</p>
    </div>
</header>


<section class="page-section" id="cursos">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Cursos Populares</h2>
            <h3 class="section-subheading text-muted">Explora los cursos más demandados</h3>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="assets/img/course1.jpg" alt="Curso 1">
                    <div class="card-body">
                        <h5 class="card-title">Curso de Java</h5>
                        <p class="card-text">Aprende Java desde cero hasta avanzado.</p>
                        <a href="#" class="btn btn-primary">Ver curso</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="assets/img/course2.jpg" alt="Curso 2">
                    <div class="card-body">
                        <h5 class="card-title">Curso de Python</h5>
                        <p class="card-text">Domina Python y sus frameworks más populares.</p>
                        <a href="#" class="btn btn-primary">Ver curso</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="assets/img/course3.jpg" alt="Curso 3">
                    <div class="card-body">
                        <h5 class="card-title">Curso de Desarrollo Web</h5>
                        <p class="card-text">Crea aplicaciones web dinámicas con HTML, CSS y JavaScript.</p>
                        <a href="#" class="btn btn-primary">Ver curso</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="page-section bg-light" id="instructores">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Nuestros Instructores</h2>
            <h3 class="section-subheading text-muted">Conoce a los profesionales detrás de los cursos</h3>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/1.jpg" alt="Instructor 1" />
                    <h4>Parveen Anand</h4>
                    <p class="text-muted">Java Expert</p>
                </div> 
            </div>
            <div class="col-lg-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/2.jpg" alt="Instructor 2" />
                    <h4>Diana Petersen</h4>
                    <p class="text-muted">Data Scientist</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/3.jpg" alt="Instructor 3" />
                    <h4>Larry Parker</h4>
                    <p class="text-muted">Web Developer</p>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="page-section" id="contact">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Contacto</h2>
            <h3 class="section-subheading text-muted">¿Tienes alguna pregunta? ¡Escríbenos!</h3>
        </div>
        <form id="contactForm" data-sb-form-api-token="API_TOKEN">
            <div class="row align-items-stretch mb-5">
                <div class="col-md-6">
                    <input class="form-control" id="name" type="text" placeholder="Tu Nombre *" required />
                    <input class="form-control" id="email" type="email" placeholder="Tu Email *" required />
                    <input class="form-control" id="phone" type="tel" placeholder="Tu Teléfono *" required />
                </div>
                <div class="col-md-6">
                    <textarea class="form-control" id="message" placeholder="Tu Mensaje *" required></textarea>
                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-primary btn-xl text-uppercase" id="submitButton" type="submit">Enviar Mensaje</button>
            </div>
        </form>
    </div>
</section>


<footer class="footer bg-dark text-white">
    <div class="container text-center">
        <small>&copy; 2024 Mi Plataforma de Cursos - Todos los derechos reservados</small>
    </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
