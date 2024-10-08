package Negocio;

import Negocio.Inscripcion;
import Negocio.Profesor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-08T15:51:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Integer> codigo;
    public static volatile SingularAttribute<Curso, Double> precio;
    public static volatile SingularAttribute<Curso, Profesor> profesor;
    public static volatile ListAttribute<Curso, Inscripcion> inscritos;
    public static volatile SingularAttribute<Curso, String> nombre;

}