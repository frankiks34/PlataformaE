/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.Controlador;
import Negocio.Curso;
import Negocio.Profesor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Frank
 */

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB
    maxFileSize = 1024 * 1024 * 10,       // 10 MB
    maxRequestSize = 1024 * 1024 * 15     // 15 MB
)

@WebServlet(name = "CrearCurso", urlPatterns = {"/CrearCurso"})
public class CrearCurso extends HttpServlet {

  Controlador control = new Controlador();
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         if (request.getContentType() != null && request.getContentType().contains("multipart/form-data")) {
        
    String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String subtitulo = request.getParameter("subtitulo");
        String precioStr = request.getParameter("precio");

     
           double precio = 0;
        try {
            precio = Double.parseDouble(precioStr.trim());
        } catch (NumberFormatException e) {
            // Si no puede convertir el precio, manejar el error (redirigir a una página de error, etc.)
            response.sendRedirect("error.jsp");
            return;
        }
        
        
         Part filePart = request.getPart("imagen"); // Asegúrate de que "imagen" coincide con el nombre en el input del formulario.
        byte[] imagen = filePart.getInputStream().readAllBytes();
        
        
          Profesor profesor = (Profesor)request.getSession().getAttribute("profesor");
             
          Curso curso = new Curso();
          
          curso.setDescripcion(descripcion);
          curso.setNombre(nombre);
        curso.setPrecio(precio);
          curso.setProfesor(profesor);
         curso.setSubtitulo(subtitulo);
        curso.setImagen(imagen);
      
      
         control.crearcurso(curso);
       profesor.getLista().add(curso);
      
       request.getSession().setAttribute("profesor", profesor);
 
         response.sendRedirect("MisCursos.jsp");
          
       
         }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
