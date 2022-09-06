package Registro;

import Clase.Clase;
import Socio.Socio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-04T19:29:21")
@StaticMetamodel(Registro.class)
public class Registro_ { 

    public static volatile SingularAttribute<Registro, Date> fecha;
    public static volatile SingularAttribute<Registro, Float> costo;
    public static volatile SingularAttribute<Registro, Socio> socio;
    public static volatile SingularAttribute<Registro, Integer> id;
    public static volatile SingularAttribute<Registro, Clase> clase;

}