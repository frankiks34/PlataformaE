/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Frank
 */
@WebServlet(name = "crearProfe", urlPatterns = {"/crearProfe"})
public class crearProfe extends HttpServlet {

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
        
        
         int a =0;
          
          String nombreUsuario = request.getParameter("nombre");
          String apellido =request.getParameter("Apellido");
             String email =request.getParameter("email");
         String contra = request.getParameter("password");
         String experianci =request.getParameter("experiencia");
         String carrera = request.getParameter("carrera");
         
        
                 
                a= Integer.parseInt(experianci);
         
           control.crearmaestro( nombreUsuario, apellido,  email, contra , a , carrera);
        
         
    }

 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
