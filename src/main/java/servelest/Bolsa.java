/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.Controlador;
import Negocio.Curso;
import Negocio.Estudiante;
import Negocio.bolsa_Compras;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Bolsa", urlPatterns = {"/Bolsa"})
public class Bolsa extends HttpServlet {

  
        Controlador controlador = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
        String codigo = request.getParameter("id");
       int co=0;
        
         Estudiante estudiante = (Estudiante)request.getSession().getAttribute("estudiante");
          bolsa_Compras a  =controlador.buscarB(estudiante);
        if (codigo != null ) {
              
            co=Integer.parseInt(codigo);
            
            Curso curso = controlador.buscarcurso(co);
       
               a.agregarCurso(curso);
              try {
                controlador.setbolsa(a);
            } catch (Exception ex) {
                Logger.getLogger(Bolsa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
  
           HttpSession misession = request.getSession();
              misession.setAttribute("bol", a);
            response.sendRedirect("bolsa_C.jsp"); 
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
