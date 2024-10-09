/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Estudiante;
import Negocio.Profesor;

/**
 *
 * @author Frank
 */
public class ControladorPersistencia {
 
   CursoJpaController curso ; 
   EstudianteJpaController estudiante ;
   InscripcionJpaController inscripcion ;
   ProfesorJpaController profeso ;
   ReseñaJpaController resenia;
   UsuarioJpaController usuario ;
    
   
   public ControladorPersistencia (){
   
  curso =   new CursoJpaController();  
estudiante = new EstudianteJpaController();
inscripcion = new InscripcionJpaController();
profeso = new ProfesorJpaController();
resenia= new ReseñaJpaController();
usuario = new UsuarioJpaController();
   
   }
   
  public void Crearestudiante(Estudiante a){
  
      estudiante.create(a);

  }

    public void Crearprofesor(Profesor profe) {
    
     profeso.create(profe);

    }
   
   
    
    
}
