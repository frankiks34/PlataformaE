    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.ControladorPersistencia;
import Persistencia.bolsa_ComprasJpaController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank
 */
public class Controlador {
    
    ControladorPersistencia control = new ControladorPersistencia();
    
    
    
    public List<Profesor> getProfesores()
    {
    
        List<Profesor> lista =new ArrayList<Profesor>();
        
      return lista = control.getProfesores();
      
    }
    
    public void crearbolsa(String nombre){
    
       bolsa_Compras bol = new bolsa_Compras();
       List<Estudiante> lista = new ArrayList<Estudiante>();
        Estudiante a = new Estudiante();
        lista=control.getEstudiantes();
       
        for (Estudiante estu : lista) {
           if (estu.getNombre().equals(nombre)) {

             
      
           a=estu;
           }
          
       }
        
        bol.setEstudiante(a);
      
        control.crearbolsa(bol);
     
        
    }

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
        
   

        
        lista=control.getEstudiantes();
        
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

   

    public void crearcurso(Curso curso) {
     control.crearcurso(curso);
    
    }

    public Estudiante buscarestudiante(String correo) {
    
         List<Estudiante> lista = new ArrayList<Estudiante>();
        
        int a=0;

        
        lista = control.getEstudiantes();
        
   
        
       for (Estudiante estu : lista) {
           if (estu.getEmail().equals(correo)) {
              
             return estu;
           }
            
       }
         return null;
        
        
    }

    public void editarestudiante(Estudiante estudiante) throws Exception {
      
    control.editarestudiante(estudiante);
    }

    public Curso buscarcurso(int codigo) {
       
    return control.getcurso(codigo);
        
    }
    
    public void setbolsa(bolsa_Compras bolsaCompras) throws Exception
    {
    
    control.setbolsa(bolsaCompras);
    
    }

 
    public bolsa_Compras buscarB(Estudiante a)
    {
    System.out.println(a.getNombre()+"este es el que se mando  ");
       List<bolsa_Compras> lista = control.getbolsas();
       
           for ( bolsa_Compras de : lista) {
       
               
       }
       
       
       
     
           for ( bolsa_Compras e : lista) {
           if (e.getEstudiante().getNombre().equals(a.getNombre())) {
            
           return e;
               
           }
            
       }
           
            
              System.out.println("no se encontro el estudiante" );
            return null;
    }
    
    
     
     
    
}
