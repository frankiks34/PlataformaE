/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Negocio.Curso;
import Negocio.Profesor;
import Negocio.bolsa_Compras;
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
public class BolsaComprasTest {
    
     private bolsa_Compras bolsa;
    private Curso curso1;
    private Curso curso2;
    private Profesor frank;
    private Profesor pool;
byte[] imagen;
byte[] imagen2;
        
    
    public BolsaComprasTest() {
    }
    
   
    
    @BeforeEach
    public void setUp() {
       bolsa = new bolsa_Compras(); // Inicializamos una nueva bolsa para cada prueba
        curso1 = new Curso();
        curso1.setCodigo(0);
        curso1.setNombre("CURSOPRUEABA");
        curso1.setPrecio(100.0);

        curso2 = new Curso();  // Otro curso para pruebas
        curso2.setCodigo(1);
        curso2.setNombre("cursoprueba2");
        curso2.setPrecio(150.0);
    }
    
    @AfterEach
    public void tearDown() {
     bolsa = null; // Limpiamos la instancia de bolsa para evitar efectos colaterales entre pruebas
        curso1 = null;
        curso2 = null;
    
    }

 @Test
    public void testAgregarCurso() {
        // Agregamos el primer curso a la bolsa
        bolsa.agregarCurso(curso1);

        // Verificamos que el curso haya sido agregado a la bolsa
        assertTrue(bolsa.getCursos().contains(curso1), "El curso debería estar en la bolsa de compras.");
    }
      @Test
    public void testNoAgregarCursoDuplicado() {
        // Agregamos el primer curso a la bolsa
        bolsa.agregarCurso(curso1);
        // Intentamos agregar el mismo curso de nuevo
        bolsa.agregarCurso(curso1);

        // Verificamos que la bolsa solo tenga un curso (no duplicado)
        assertEquals(1, bolsa.getCursos().size(), "La bolsa no debe contener duplicados.");
    }

    @Test
    public void testRemoverCurso() {
        // Agregamos dos cursos a la bolsa
        bolsa.agregarCurso(curso1);
        bolsa.agregarCurso(curso2);

        // Removemos el curso1 de la bolsa
        bolsa.removerCurso(curso1.getCodigo());

        // Verificamos que la bolsa ya no contenga el curso1
        assertFalse(bolsa.getCursos().contains(curso1), "El curso1 debería haber sido eliminado.");
    }

    @Test
    public void testTotalImporte() {
        // Agregamos dos cursos a la bolsa
        bolsa.agregarCurso(curso1);
        bolsa.agregarCurso(curso2);

        // Verificamos que el total importe sea correcto (100 + 150 = 250)
        assertEquals(250.0, bolsa.totalimporte(), "El total importe no es correcto.");
    }
    
}
