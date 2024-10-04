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
public class Profesor extends Persona{

     @OneToMany(mappedBy="profesor")
     private List<Curso> lista =new ArrayList<Curso>();
     
   private String Nomtitulo;
   private String Carrera;
  

    public Profesor(String Nomtitulo, String Carrera, List<Curso> frank ,int codigo, String Nombre, String Apellido,String email,String contrasenia ,int edad) {
       
        super( codigo , Nombre , Apellido,email,contrasenia , edad );
        this.Nomtitulo = Nomtitulo;
        this.Carrera = Carrera;
        frank=lista;
    }

    public String getNomtitulo() {
        return Nomtitulo;
    }

    public void setNomtitulo(String Nomtitulo) {
        this.Nomtitulo = Nomtitulo;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public List<Curso> getLista() {
        return lista;
    }

    public void setLista(List<Curso> lista) {
        this.lista = lista;
    }


    
   
    
   
    
}
