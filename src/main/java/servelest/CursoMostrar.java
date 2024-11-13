/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.Controlador;
import Negocio.Curso;
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
@WebServlet(name = "CursoMostrar", urlPatterns = {"/CursoMostrar"})
public class CursoMostrar extends HttpServlet {
    
    Controlador controlador = new Controlador();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
         int codigo = Integer.parseInt(request.getParameter("nombre"));
    
         Curso curso = controlador.buscarcurso(codigo);
    
           HttpSession misession = request.getSession();
              misession.setAttribute("curso", curso);
            response.sendRedirect("vistacurso.jsp"); 
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
