/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Frank
 */
public class Reseña {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
     
    private String comentario;
    
    @OneToOne
    private Estudiante estudiante;
    @OneToOne
    private Curso curso;

    public Reseña(int id, String comentario, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.comentario = comentario;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
  
}
