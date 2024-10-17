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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Frank
 */
@WebServlet(name = "loginE", urlPatterns = {"/loginE"})
public class loginE extends HttpServlet {

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
     
           String correo= request.getParameter("email");
        String contrasenia= request.getParameter("password");
        
       String userType = request.getParameter("userType"); 
   
       boolean validacion = false;

        if ("1".equals(userType) ) {
            
            Estudiante estudiante = new Estudiante();
              validacion = control.comprobaringresoE(correo,contrasenia);
              
              
             if (validacion==true) {
                 
                 estudiante= control.buscarestudiante(correo);
                 
            HttpSession misession= request.getSession(true);
           
            misession.setAttribute("estudiante",estudiante );
           response.sendRedirect("EstudianteDashboard.jsp");
        }
               
               else{
               response.sendRedirect("loginError.jsp");
               }
        }
        else{
            
             Profesor profesor = new Profesor();
            
           validacion = control.comprobaringresoP(correo,contrasenia);
          
         if (validacion==true) {
                 
            profesor =control.buscarprofesor(correo);
        
            HttpSession misession= request.getSession(true);
           
            misession.setAttribute("profesor",profesor );
           response.sendRedirect("ProfesorDashboard.jsp");
        }
               
               else{
               response.sendRedirect("loginError.jsp");
               }    
        }
               
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
