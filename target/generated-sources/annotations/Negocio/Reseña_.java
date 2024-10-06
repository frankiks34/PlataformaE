package Negocio;

import Negocio.Curso;
import Negocio.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-10-06T15:57:18")
@StaticMetamodel(Reseña.class)
public class Reseña_ { 

    public static volatile SingularAttribute<Reseña, Estudiante> estudiante;
    public static volatile SingularAttribute<Reseña, Curso> curso;
    public static volatile SingularAttribute<Reseña, Integer> id;
    public static volatile SingularAttribute<Reseña, String> comentario;

}