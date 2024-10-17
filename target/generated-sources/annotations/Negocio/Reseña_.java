package Negocio;

import Negocio.Curso;
import Negocio.Estudiante;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-17T02:18:00", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Reseña.class)
public class Reseña_ { 

    public static volatile SingularAttribute<Reseña, Estudiante> estudiante;
    public static volatile SingularAttribute<Reseña, Curso> curso;
    public static volatile SingularAttribute<Reseña, Integer> id;
    public static volatile SingularAttribute<Reseña, String> comentario;

}