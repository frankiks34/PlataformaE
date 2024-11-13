/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Negocio.Controlador;
import Negocio.Estudiante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Frank
 */
public class testComprobarIngreso {
    
    
     private Controlador controlador;
    public testComprobarIngreso() {
    }
    
      

    @BeforeEach
    public void setUp() {
        controlador = new Controlador(); // Inicializamos el controlador antes de cada prueba
    }

    @Test
    public void testComprobarIngresoEstudiante() {
       
   assertTrue(controlador.comprobaringresoE("poco@utp.edu.pe", "123"));
    }

}
