<%-- 
    Document   : registerP
    Created on : 5 oct. 2024, 4:09:53 p. m.
    Author     : Frank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
   

    <!-- Registration Form -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <h2 class="text-center">Registro de Usuario</h2>
                <div class="text-center my-3">
                    <!-- Botones para seleccionar Estudiante o Profesor -->
                    <button type="button" class="btn btn-primary" onclick="mostrarFormulario('estudiante')">Estudiante</button>
                    <button type="button" class="btn btn-secondary" onclick="mostrarFormulario('profesor')">Profesor</button>
                </div>
                
                <!-- Formulario de Registro -->
                <form id="form-registro" class="border p-4 rounded" method="POST">
                    <!-- Campos Comunes -->
                    <div class="form-group mb-3">
                        <label for="nombre">Nombre Completo</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="nombre">Apellido</label>
                        <input type="text" class="form-control" id="Apellido" name="Apellido" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="email">Correo Electrónico</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="password">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>

                    <!-- Campos Específicos de Estudiante -->
                    <div id="campos-estudiante" style="display: none;">
                        <h4 class="mt-4">Información Adicional de Estudiante</h4>
                       
                        <div class="form-group mb-3">
                            <label for="cursoActual">Universidad o colegio</label>
                            <input type="text" class="form-control" id="cursoActual" name="cursoActual">
                        </div>
                    </div>

                    <!-- Campos Específicos de Profesor -->
                    <div id="campos-profesor" style="display: none;">
                        <h4 class="mt-4">Información Adicional de Profesor</h4>
                        <div class="form-group mb-3">
                            <label for="especialidad">Carrera</label>
                            <input type="text" class="form-control" id="especialidad" name="especialidad">
                        </div>
                        <div class="form-group mb-3">
                            <label for="experiencia">Años de Experiencia</label>
                            <input type="number" class="form-control" id="experiencia" name="experiencia">
                        </div>
                    </div>

                    <!-- Botón de Registro -->
                    <button type="submit" class="btn btn-success w-100" id="submitButton">Registrar</button>
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

    <!-- Script para Mostrar Formulario Dinámico y Cambiar Action -->
    <script>
        // Variable para almacenar el tipo seleccionado
        let tipoUsuario = '';

        // Función para mostrar los campos específicos según el tipo de usuario
        function mostrarFormulario(tipo) {
            tipoUsuario = tipo;
            // Mostrar u ocultar campos según el tipo
            document.getElementById('campos-estudiante').style.display = tipo === 'estudiante' ? 'block' : 'none';
            document.getElementById('campos-profesor').style.display = tipo === 'profesor' ? 'block' : 'none';

            // Cambiar el action del formulario dependiendo del tipo seleccionado
            const form = document.getElementById('form-registro');
            if (tipo === 'estudiante') {
                form.action = 'CrearAlumnoServlet'; // Redirigir a CrearAlumnoServlet
            } else if (tipo === 'profesor') {
                form.action = 'CrearProfesorServlet'; // Redirigir a CrearProfesorServlet
            }
        }
    </script>
</body>
</html>