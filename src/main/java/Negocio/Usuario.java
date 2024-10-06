/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;




@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int codigo;
    private String Nombre;
    private String Apellido;
    private String email;
    private String contrasenia;
   

    public Usuario(int codigo, String Nombre, String Apellido,String email,String contrasenia) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;

        this.email=email;
        this.contrasenia=contrasenia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
    
}
