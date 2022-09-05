package Cuponera;

import CuponeraXActividad.CuponeraXActividad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-04T19:29:21")
@StaticMetamodel(Cuponera.class)
public class Cuponera_ { 

    public static volatile SingularAttribute<Cuponera, String> descripcion;
    public static volatile ListAttribute<Cuponera, CuponeraXActividad> cuponerasXActividad;
    public static volatile SingularAttribute<Cuponera, Integer> descuento;
    public static volatile SingularAttribute<Cuponera, Integer> id;
    public static volatile SingularAttribute<Cuponera, String> nombre;
    public static volatile SingularAttribute<Cuponera, Date> periodoVigencia;

}