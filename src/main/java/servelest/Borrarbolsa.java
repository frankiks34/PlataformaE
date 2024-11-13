/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.Controlador;
import Negocio.Curso;
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
@WebServlet(name = "Borrarbolsa", urlPatterns = {"/Borrarbolsa"})
public class Borrarbolsa extends HttpServlet {

    
     Controlador controlador = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
        int codigo =  Integer.parseInt(request.getParameter("cursoId"));
        int codigo2 = Integer.parseInt(request.getParameter("bolsaId"));
         
            
        
        bolsa_Compras a = controlador.buscarBC(codigo2);
       
   
        Curso b = controlador.getcurso(codigo);
         System.out.printf("curso a eliminar:"+ b.getNombre());
       a.removerCurso(codigo);
       
   
       for (Curso c :a.getCursos()) {
          
              System.out.printf("los cursos son: "+c.getNombre()+ "\n");
        }
        
        
        
         try {
             controlador.setbolsa(a);
         } catch (Exception ex) {
             Logger.getLogger(Borrarbolsa.class.getName()).log(Level.SEVERE, null, ex);
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
