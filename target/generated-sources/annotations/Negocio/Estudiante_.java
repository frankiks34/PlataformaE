package Negocio;

import Negocio.Inscripcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-10-05T12:03:23")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ extends Usuario_ {

    public static volatile ListAttribute<Estudiante, Inscripcion> inscripcion;
    public static volatile SingularAttribute<Estudiante, String> Universidad;

}