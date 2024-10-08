package Negocio;

import Negocio.Curso;
import Negocio.Estudiante;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-08T15:51:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Inscripcion.class)
public class Inscripcion_ { 

    public static volatile SingularAttribute<Inscripcion, Estudiante> estudiante;
    public static volatile SingularAttribute<Inscripcion, Double> calificacion;
    public static volatile SingularAttribute<Inscripcion, Integer> code;
    public static volatile SingularAttribute<Inscripcion, Curso> curso;

}