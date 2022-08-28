package Clase;

import Actividad.Actividad;
import Registro.Registro;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Clase.class)
public class Clase_ { 

    public static volatile SingularAttribute<Clase, Date> fecha;
    public static volatile SingularAttribute<Clase, String> urlAcceso;
    public static volatile SingularAttribute<Clase, Date> fechaRegistro;
    public static volatile CollectionAttribute<Clase, Registro> registros;
    public static volatile SingularAttribute<Clase, Integer> id;
    public static volatile SingularAttribute<Clase, Integer> capMaxima;
    public static volatile SingularAttribute<Clase, String> nombre;
    public static volatile SingularAttribute<Clase, Integer> capMinima;
    public static volatile SingularAttribute<Clase, Actividad> actividad;

}