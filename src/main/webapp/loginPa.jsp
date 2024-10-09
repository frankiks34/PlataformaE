<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .btn-active {
            background-color: #007bff; /* Cambia el color según lo que prefieras */
            color: white;
        }
        .btn-inactive {
            background-color: #e9ecef; /* Color por defecto */
            color: black;
        }
    </style>
</head>
<body>
    <!-- Login Form -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2 class="text-center">Iniciar Sesión</h2>

                <div class="d-flex justify-content-center mb-3">
                    <button id="btnEstudiante" class="btn btn-inactive mx-2" onclick="setUserType('Estudiante')">Estudiante</button>
                    <button id="btnMaestro" class="btn btn-inactive mx-2" onclick="setUserType('Maestro')">Maestro</button>
                </div>

                <form id="loginForm" action="LoginServlet" method="POST" class="border p-4 rounded">
                    <input type="hidden" id="userType" name="userType" value="">

                    <div class="form-group mb-3">
                        <label for="email">Correo Electrónico</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="password">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Iniciar Sesión</button>
                    <p class="text-center mt-3">¿No tienes cuenta? <a href="registerP.jsp">Regístrate</a></p>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer bg-dark text-white text-center mt-5">
        <div class="container">
            <small>&copy; 2024 Plataforma de Cursos - Todos los derechos reservados</small>
        </div>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function setUserType(type) {
            // Actualiza el tipo de usuario
            document.getElementById('userType').value = type;

            // Cambia la acción del formulario según el tipo de usuario
            document.getElementById('loginForm').action = type === 'Estudiante' ? 'EstudianteServlet' : 'MaestroServlet';

            // Cambia el estilo de los botones
            const btnEstudiante = document.getElementById('btnEstudiante');
            const btnMaestro = document.getElementById('btnMaestro');

            if (type === 'Estudiante') {
                btnEstudiante.classList.add('btn-active');
                btnEstudiante.classList.remove('btn-inactive');
                btnMaestro.classList.add('btn-inactive');
                btnMaestro.classList.remove('btn-active');
            } else {
                btnMaestro.classList.add('btn-active');
                btnMaestro.classList.remove('btn-inactive');
                btnEstudiante.classList.add('btn-inactive');
                btnEstudiante.classList.remove('btn-active');
            }
        }
    </script>
</body>
</html>
