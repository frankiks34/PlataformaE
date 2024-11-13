/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class bolsa_Compras {

   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    
     @OneToOne
     private Estudiante estudiante;
    
      @ManyToMany
    @JoinTable(
        name = "bolsa_compras_cursos",
        joinColumns = @JoinColumn(name = "bolsa_compras_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
   
      private List<Curso> cursos = new ArrayList<>();

    public bolsa_Compras(int id, Estudiante estudiante) {
        this.id = id;
        this.estudiante = estudiante;
    }
    public bolsa_Compras()
    {
    
    }
    
      public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
    
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
    
      public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }
    public void removerCurso(int cursoId) {
      
    Curso cursoAEliminar = null;

    for (Curso curso : cursos) {
        if (curso.getCodigo() == cursoId) { // Compara usando el ID
            cursoAEliminar = curso;
            break;
        }
    }

    if (cursoAEliminar != null) {
        cursos.remove(cursoAEliminar);
        System.out.println("Curso eliminado: " + cursoAEliminar.getNombre());
    } else {
        System.out.println("El curso no se encuentra en la bolsa: " + cursoId);
    }
    
    }
    
    
    public double totalimporte()       
    {
    double a=0;
        
        for (Curso curso:cursos) {
            a=a+curso.getPrecio();
            
        }
     return a;
    }
      
        
    
    
    
  

    
}
