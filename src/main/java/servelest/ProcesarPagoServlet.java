/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelest;

import Negocio.PagoService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Frank
 */
@WebServlet(name = "ProcesarPagoServlet", urlPatterns = {"/ProcesarPagoServlet"})
public class ProcesarPagoServlet extends HttpServlet {

        PagoService pagoService = new PagoService();
               
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
        
        response.setContentType("application/json");

        // Leer el JSON de la solicitud
        JSONObject json = new JSONObject(request.getReader().lines().reduce("", String::concat));
        String paymentMethodId = json.getString("paymentMethodId");
        double total = json.getDouble("total");

        
        System.out.println("PaymentMethodId este es el paymentmethodId: " + paymentMethodId);
    
        
        
        try {
            // Crear el PaymentIntent con el método de pago y el monto
            PaymentIntent paymentIntent = pagoService.crearPaymentIntentConReturnUrl(paymentMethodId, total);

            // Construir la respuesta JSON
            JSONObject responseData = new JSONObject();
            responseData.put("success", true);
            responseData.put("paymentIntentId", paymentIntent.getId()); // Añadir el paymentIntentId
            responseData.put("clientSecret", paymentIntent.getClientSecret()); // Añadir clientSecret para confirmar el pago
            responseData.put("total", total); // Enviar el total en unidades de moneda

            // Enviar respuesta al cliente
            response.getWriter().write(responseData.toString());

        } catch (StripeException e) {
            // Manejo de errores
            JSONObject responseData = new JSONObject();
            responseData.put("success", false);
            responseData.put("message", e.getMessage());
            response.getWriter().write(responseData.toString());
        }
    }


 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
