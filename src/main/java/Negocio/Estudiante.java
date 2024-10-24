/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Frank
 */

   @Entity
   public class Estudiante extends Usuario{

         @OneToMany(mappedBy="estudiante")
        private List<Inscripcion> inscripcion;

       private String Universidad;

        



       public Estudiante(String universidad ,int codigo, String Nombre, String Apellido,String email,String contrasenia) {
           super(codigo, Nombre, Apellido, email, contrasenia);

           this.Universidad=universidad;
           inscripcion = new ArrayList<Inscripcion>();
          
       }


       public Estudiante(){

       }

       
       
 

 


       public String getUniversidad() {
           return Universidad;
       }

       public void setUniversidad(String Universidad) {
           this.Universidad = Universidad;
       }

       public List<Inscripcion> getInscripcion() {
           return inscripcion;
       }

       public void setInscripcion(List<Inscripcion> inscripcion) {
           this.inscripcion = inscripcion;
       }





   }
