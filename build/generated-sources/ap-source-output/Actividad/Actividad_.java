package Actividad;

import Clase.Clase;
import CuponeraXActividad.CuponeraXActividad;
import Institucion.Institucion;
import Profesor.Profesor;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-27T15:47:43", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> 3ac410e764c5b52ef05e05c71199681f9d3dcf95
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, String> descripcion;
    public static volatile CollectionAttribute<Actividad, CuponeraXActividad> cuponerasXActividad;
    public static volatile SingularAttribute<Actividad, Float> costo;
    public static volatile SingularAttribute<Actividad, Date> fechaRegistro;
    public static volatile CollectionAttribute<Actividad, Clase> clases;
    public static volatile SingularAttribute<Actividad, Institucion> institucion;
    public static volatile SingularAttribute<Actividad, Integer> duracion;
    public static volatile SingularAttribute<Actividad, Profesor> profesor;
    public static volatile SingularAttribute<Actividad, Integer> id;
<<<<<<< HEAD
    public static volatile SingularAttribute<Actividad, String> nombre;
=======
>>>>>>> 3ac410e764c5b52ef05e05c71199681f9d3dcf95

}