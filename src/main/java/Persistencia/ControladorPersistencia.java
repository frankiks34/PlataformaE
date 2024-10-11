/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Estudiante;
import Negocio.Profesor;
import java.util.List;

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
   
      public List<Profesor> getProfesores() {
        return profeso.findProfesorEntities(); 
    }
     public Profesor getProfesor(int d) {
         return profeso.findProfesor(d);
    }

    public List<Estudiante> getEstudiante() {
       
    return estudiante.findEstudianteEntities();
    }
    
   public void editarprofesor(Profesor a) throws Exception 
   {
   
      profeso.edit(a);
       
   }
  
    
    
}
