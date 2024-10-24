package Negocio;

import Negocio.Curso;
import Negocio.Estudiante;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-23T19:50:16", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(bolsa_Compras.class)
public class bolsa_Compras_ { 

    public static volatile SingularAttribute<bolsa_Compras, Estudiante> estudiante;
    public static volatile ListAttribute<bolsa_Compras, Curso> cursos;
    public static volatile SingularAttribute<bolsa_Compras, Integer> id;

}