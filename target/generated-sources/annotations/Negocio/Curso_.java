package Negocio;

import Negocio.Profesor;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-10-05T12:03:23")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Integer> codigo;
    public static volatile SingularAttribute<Curso, Double> precio;
    public static volatile SingularAttribute<Curso, Profesor> profesor;
    public static volatile ListAttribute<Curso, List> inscritos;
    public static volatile SingularAttribute<Curso, String> nombre;

}