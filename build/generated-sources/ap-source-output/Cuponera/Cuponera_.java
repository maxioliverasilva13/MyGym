package Cuponera;

import CuponeraXActividad.CuponeraXActividad;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Cuponera.class)
public class Cuponera_ { 

    public static volatile SingularAttribute<Cuponera, String> descripcion;
    public static volatile CollectionAttribute<Cuponera, CuponeraXActividad> cuponerasXActividad;
    public static volatile SingularAttribute<Cuponera, Integer> descuento;
    public static volatile SingularAttribute<Cuponera, Integer> id;
    public static volatile SingularAttribute<Cuponera, String> nombre;
    public static volatile SingularAttribute<Cuponera, Date> periodoVigencia;

}