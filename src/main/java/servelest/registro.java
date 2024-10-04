/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

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
@WebServlet(name = "registro", urlPatterns = {"/registro"})
public class registro extends HttpServlet {

   

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String a;
        int total =14;
        if (total>13) {
            
            a = "aprobado";
        }
         else  {
            
            a = "desaprobado";
        }
        
        HttpSession misession= request.getSession();
        misession.setAttribute("a",a);
        response.sendRedirect("index.jsp");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       float final1 = Float.parseFloat(request.getParameter("notas1"));
         float parcial = Float.parseFloat(request.getParameter("notas2"));
        float practica1 = Float.parseFloat(request.getParameter("notas3"));
       float practica2 = Float.parseFloat(request.getParameter("notas4"));
       
       float total = (final1+parcial+((practica1+practica2)/2))/3;
        
         System.out.println("Resultado total :"+ total );
        
      response.sendRedirect("registro");
    }

    @Override
    public String getServletInfo() {
        
        
        return "Short description";
    }

}
