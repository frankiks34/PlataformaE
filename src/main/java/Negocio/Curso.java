/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
  
      @OneToMany(mappedBy="curso")
    private List<Inscripcion> inscritos;
     
    private String nombre;
    private Double precio;
    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor profesor;

    public Curso(int codigo,List<Inscripcion> inscrito , String nombre, Double precio ,Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
       this.profesor=profesor;
       inscritos = inscrito;
    }
    
    
    public Curso()
    {
    
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Inscripcion> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Inscripcion> inscritos) {
        this.inscritos = inscritos;
    }
    
    
    
    
    
}
