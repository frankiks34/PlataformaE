/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Frank
 */

 @Entity
public class Estudiante extends Persona{
    
    private String Universidad;
    
     @OneToMany(mappedBy="estudiante")
     private List<Inscripcion> inscripcion;

    public Estudiante(String universidad ,List<Inscripcion> inscripcione ,int codigo, String Nombre, String Apellido,String email,String contrasenia, int edad) {
        super(codigo, Nombre, Apellido, email, contrasenia , edad);
        
        this.Universidad=universidad;
        inscripcion = inscripcione;
    }

    public String getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(String Universidad) {
        this.Universidad = Universidad;
    }
    
    
    
    
}
