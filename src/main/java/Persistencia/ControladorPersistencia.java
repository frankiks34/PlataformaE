/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Boleta;
import Negocio.Curso;
import Negocio.Estudiante;
import Negocio.Inscripcion;
import Negocio.Profesor;
import Negocio.bolsa_Compras;
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
    bolsa_ComprasJpaController bolsa;
    BoletaJpaController boleta;
  
   
   public ControladorPersistencia (){
   
  curso =   new CursoJpaController();  
estudiante = new EstudianteJpaController();
inscripcion = new InscripcionJpaController();
profeso = new ProfesorJpaController();
resenia= new ReseñaJpaController();
usuario = new UsuarioJpaController();
   bolsa = new bolsa_ComprasJpaController();
   boleta = new   BoletaJpaController();
   }
   
  
   
   public void setbolsa(bolsa_Compras bolsaCompras) throws Exception
   {
   bolsa.edit(bolsaCompras);   
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

    public List<Estudiante> getEstudiantes() {
       
    return estudiante.findEstudianteEntities();
    }
    
   public void editarprofesor(Profesor a) throws Exception 
   {
   
      profeso.edit(a);
       
   }

    public void crearcurso(Curso cursos) {
      
        curso.create(cursos);
    }

    public void editarestudiante(Estudiante estudiantes) throws Exception {
     
       estudiante.edit(estudiantes);
    }

    public Curso getcurso(int codigo) {
    return  curso.findCurso(codigo);
    }
  
    public void crearbolsa(bolsa_Compras a)
    {
        
   bolsa.create(a);
    }
     public List<bolsa_Compras> getbolsas()
    {
  
       return bolsa.findBolsaComprasEntities();
  
    }

    public bolsa_Compras getbolsa(int codigo) {
    return bolsa.findBolsaCompras(codigo);
    }

    public void CrearInscripcion(Inscripcion a) {
       inscripcion.create(a);
    }
 public void CrearBoleta(Boleta bo){
       boleta.create(bo);
    }

   
}
