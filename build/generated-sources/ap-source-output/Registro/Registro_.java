package Registro;

import Clase.Clase;
import Socio.Socio;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-27T15:47:43", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> 3ac410e764c5b52ef05e05c71199681f9d3dcf95
@StaticMetamodel(Registro.class)
public class Registro_ { 

    public static volatile SingularAttribute<Registro, Date> fecha;
    public static volatile SingularAttribute<Registro, Float> costo;
    public static volatile SingularAttribute<Registro, Socio> socio;
    public static volatile SingularAttribute<Registro, Integer> id;
    public static volatile SingularAttribute<Registro, Clase> clase;

}