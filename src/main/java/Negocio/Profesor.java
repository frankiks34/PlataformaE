/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Frank
 */

@Entity
public class Profesor extends Usuario{

     @OneToMany(mappedBy="profesor")
     private List<Curso> lista;
     
   private int experiancia;
   private String Carrera;
  

    public Profesor(int experiencia, String Carrera,int codigo, String Nombre, String Apellido,String email,String contrasenia ,int edad) {
       
        super( codigo , Nombre , Apellido,email,contrasenia);
       this.experiancia =experiencia;
        this.Carrera = Carrera;
      lista =new ArrayList<Curso>();
    }

    public Profesor()
    {
    }
    
    @Override
   public int getCodigo() {
        return super.getCodigo();
    }
    
    
    
    
    public int getExperiancia() {
        return experiancia;
    }

    public void setExperiancia(int experiancia) {
        this.experiancia = experiancia;
    }

   public List<Curso> getLista()
   {
   return lista;
           
   }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    

    public void setLista(List<Curso> lista) {
        this.lista = lista;
    }


    
   
    
   
    
}
