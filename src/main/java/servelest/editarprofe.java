/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.Controlador;
import Negocio.Estudiante;
import Negocio.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Frank
 */
@WebServlet(name = "editarprofe", urlPatterns = {"/editarprofe"})
public class editarprofe extends HttpServlet {
   Controlador control = new Controlador();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
           String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String email= request.getParameter("email");
       String id = request.getParameter("id"); 
        
        
         if ("1".equals(id)){
          String universi= request.getParameter("universidad");
            Estudiante estudiante = (Estudiante)request.getSession().getAttribute("estudiante");
              estudiante.setApellido(apellido);
            estudiante.setEmail(email);
                 estudiante.setNombre(nombre);
                 estudiante.setUniversidad(universi);
        
                  try {
                   control.editarestudiante(estudiante);
               } catch (Exception ex) {
                   Logger.getLogger(editarprofe.class.getName()).log(Level.SEVERE, null, ex);
               }
       
                  
         response.sendRedirect("miPerfilE.jsp");
                  
        }
      
        if ("2".equals(id)) {
            
            
         Profesor profe= (Profesor)request.getSession().getAttribute("profesor");
         
         profe.setApellido(apellido);
         profe.setEmail(email);
         profe.setNombre(nombre);
       System.out.println(profe.getApellido()+profe.getEmail()+profe.getNombre());   
           
               try {
                   control.editarprofesor(profe);
               } catch (Exception ex) {
                   Logger.getLogger(editarprofe.class.getName()).log(Level.SEVERE, null, ex);
               }
              
             response.sendRedirect("MiPerfil.jsp");
        }
     
        
        
       
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
