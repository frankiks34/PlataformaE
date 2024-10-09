/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.ControladorPersistencia;

/**
 *
 * @author Frank
 */
public class Controlador {
    
    ControladorPersistencia control = new ControladorPersistencia();
    
    

    public void crearestudiante(String nombreUsuario, String apellido, String email, String contra, String universidad) {
  
        
         Estudiante estudi = new Estudiante();
          
         estudi.setApellido(apellido);
         estudi.setContrasenia(contra);
         estudi.setNombre(nombreUsuario);
         estudi.setEmail(email);
        estudi.setUniversidad(universidad);
        control.Crearestudiante(estudi);
        
    }
    
    public void crearmaestro(String nombreUsuario, String apellido, String email, String contra, int experiencia , String carrera)
    {
      
        Profesor profe = new Profesor();
        
        profe.setApellido(apellido);
        profe.setCarrera(carrera);
        profe.setContrasenia(contra);
        profe.setEmail(email);
        profe.setExperiancia(experiencia);
       profe.setNombre(contra);
        
        
        control.Crearprofesor(profe);
        
        
    }
    
    
    
}
