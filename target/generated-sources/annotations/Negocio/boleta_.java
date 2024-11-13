package Negocio;

import Negocio.Curso;
import Negocio.Estudiante;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-12T12:46:31", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Boleta.class)
public class Boleta_ { 

    public static volatile SingularAttribute<Boleta, Estudiante> estudiante;
    public static volatile SingularAttribute<Boleta, String> paymentIntentId;
    public static volatile SingularAttribute<Boleta, String> descripcion;
    public static volatile SingularAttribute<Boleta, Double> monto;
    public static volatile SingularAttribute<Boleta, Date> fechaTransaccion;
    public static volatile SingularAttribute<Boleta, Curso> curso;
    public static volatile SingularAttribute<Boleta, String> paymentMethodId;
    public static volatile SingularAttribute<Boleta, Integer> idBoleta;
    public static volatile SingularAttribute<Boleta, Date> fechaCreacion;
    public static volatile SingularAttribute<Boleta, String> returnUrl;
    public static volatile SingularAttribute<Boleta, String> estadoPago;

}