package Clase;

import Actividad.Actividad;
import Registro.Registro;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-04T19:29:21")
@StaticMetamodel(Clase.class)
public class Clase_ { 

    public static volatile SingularAttribute<Clase, Date> fecha;
    public static volatile SingularAttribute<Clase, String> urlAcceso;
    public static volatile SingularAttribute<Clase, Date> fechaRegistro;
    public static volatile ListAttribute<Clase, Registro> registros;
    public static volatile SingularAttribute<Clase, Integer> id;
    public static volatile SingularAttribute<Clase, Integer> capMaxima;
    public static volatile SingularAttribute<Clase, String> nombre;
    public static volatile SingularAttribute<Clase, Integer> capMinima;
    public static volatile SingularAttribute<Clase, Actividad> actividad;

}