/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Frank
 */
public class Profesor extends Persona{

   private String Nomtitulo;
   private String Carrera;

    public Profesor(String Nomtitulo, String Carrera,int codigo, String Nombre, String Apellido, int edad) {
       
        super( codigo , Nombre , Apellido , edad );
        this.Nomtitulo = Nomtitulo;
        this.Carrera = Carrera;
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
    
   
    
   
    
}
