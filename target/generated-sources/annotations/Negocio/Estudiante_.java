package Negocio;

import Negocio.Inscripcion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-08T20:51:00", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ extends Usuario_ {

    public static volatile ListAttribute<Estudiante, Inscripcion> inscripcion;
    public static volatile SingularAttribute<Estudiante, String> Universidad;

}