/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author Frank
 */
public class Estudiante extends Persona{
    
    private String Universidad;
    
     @OneToMany(mappedBy="estudiante")
    private List<Curso> listacurso;

    public Estudiante(String universidad,int codigo, String Nombre, String Apellido, int edad) {
        super(codigo, Nombre, Apellido, edad);
        
        this.Universidad=universidad;
    }

    public String getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(String Universidad) {
        this.Universidad = Universidad;
    }
    
    
    
    
}
