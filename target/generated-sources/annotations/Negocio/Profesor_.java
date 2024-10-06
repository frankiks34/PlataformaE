package Negocio;

import Negocio.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-10-06T15:57:18")
@StaticMetamodel(Profesor.class)
public class Profesor_ extends Usuario_ {

    public static volatile ListAttribute<Profesor, Curso> lista;
    public static volatile SingularAttribute<Profesor, Integer> experiancia;
    public static volatile SingularAttribute<Profesor, String> Carrera;

}