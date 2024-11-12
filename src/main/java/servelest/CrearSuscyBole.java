/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.Boleta;
import Negocio.Controlador;
import Negocio.Curso;
import Negocio.Estudiante;
import Negocio.Inscripcion;
import Negocio.bolsa_Compras;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "CrearSuscyBole", urlPatterns = {"/CrearSuscyBole"})
public class CrearSuscyBole extends HttpServlet {
 Controlador controlador = new Controlador();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Estudiante estudiante = (Estudiante) request.getSession().getAttribute("estudiante");
        bolsa_Compras bolsaCompras = controlador.buscarB(estudiante);

        // Obtener los detalles de pago de la URL
        String paymentIntentId = request.getParameter("paymentIntentId");
        String paymentMethodId = request.getParameter("paymentMethodId");
        double monto = Double.parseDouble(request.getParameter("monto"));

        System.out.println("PaymentIntentId: " + paymentIntentId);
        System.out.println("PaymentMethodId: " + paymentMethodId);
        System.out.println("Monto: " + monto);   
        
        // Crear inscripciones y boletas para cada curso en la bolsa de compras
        for (Curso curso : bolsaCompras.getCursos()) {
            // Crear la inscripción
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setEstudiante(estudiante);
            inscripcion.setCurso(curso);
            inscripcion.setCalificacion(0);
            controlador.crearInscripcion(inscripcion);

            // Crear la boleta para cada curso
            Boleta boleta = new Boleta();
            boleta.setEstudiante(estudiante);
            boleta.setCurso(curso);
            boleta.setMonto(monto);
            boleta.setEstadoPago("pagado");
            boleta.setPaymentIntentId(paymentIntentId);
            boleta.setPaymentMethodId(paymentMethodId);
            boleta.setFechaTransaccion(new Date());
            boleta.setDescripcion("Pago por curso " + curso.getNombre());

            controlador.crearBoleta(boleta); // Guardar la boleta
             
            estudiante.getBoletas().add(boleta);
            estudiante.getInscripcion().add(inscripcion);
        }

        bolsaCompras.getCursos().clear();
        
     try {
         controlador.setbolsa(bolsaCompras);
         controlador.editarestudiante(estudiante);
         response.sendRedirect("Confirmacion.jsp"); 
     } catch (Exception ex) {
         Logger.getLogger(CrearSuscyBole.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    
        
      
         
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
