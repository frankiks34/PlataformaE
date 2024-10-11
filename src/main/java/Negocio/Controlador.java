/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.List;

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
       profe.setNombre(nombreUsuario);
        
        
        control.Crearprofesor(profe);
        
        
    }

    public boolean comprobaringresoP(String correo, String contrasenia) {
             
         boolean ingreso =false;
        List<Profesor> lista = new ArrayList<Profesor>();
        
        lista=control.getProfesores();
        
       for (Profesor pro : lista) {
           if (pro.getEmail().equals(correo)) {
               if (pro.getContrasenia().equals(contrasenia)) {
                   ingreso = true;
               }
               else{         
                  ingreso=false ;          
               }      
           }
       }
    
       return ingreso;
    
    }
    
     public boolean comprobaringresoE(String correo, String contrasenia) {
             
         boolean ingreso =false;
        List<Estudiante> lista = new ArrayList<Estudiante>();
        
        System.out.println("Valor de userType recibido: " + correo); // Línea añadida para depuración

        
        lista=control.getEstudiante();
        
       for (Estudiante pro : lista) {
           if (pro.getEmail().equals(correo)) {
               if (pro.getContrasenia().equals(contrasenia)) {
                   ingreso = true;
               }
               else{         
                  ingreso=false ;          
               }      
           }
       }
    
       return ingreso;
    
    }

    public Profesor buscarprofesor(String correo) {
        
        List<Profesor> lista = new ArrayList<Profesor>();
        
       int a=0;

        
        lista=control.getProfesores();
        
   
        
        
       for (Profesor pro : lista) {
           if (pro.getEmail().equals(correo)) {
              
             return pro;
           }
            
       }
         return null;
       
    }

    public void editarprofesor(Profesor profe) throws Exception{
       
        
        control.editarprofesor(profe);
      
    }
    
     
    
    
     
     
    
}
