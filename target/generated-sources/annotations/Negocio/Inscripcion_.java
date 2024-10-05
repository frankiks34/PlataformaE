package Negocio;

import Negocio.Curso;
import Negocio.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-10-05T12:03:23")
@StaticMetamodel(Inscripcion.class)
public class Inscripcion_ { 

    public static volatile SingularAttribute<Inscripcion, Estudiante> estudiante;
    public static volatile SingularAttribute<Inscripcion, Double> calificacion;
    public static volatile SingularAttribute<Inscripcion, Integer> code;
    public static volatile SingularAttribute<Inscripcion, Curso> curso;

}