package Profesor;

import Actividad.Actividad;
import Institucion.Institucion;
import Usuario.Usuario_;
import javax.annotation.processing.Generated;
<<<<<<< HEAD
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-27T15:47:43", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> 3ac410e764c5b52ef05e05c71199681f9d3dcf95
@StaticMetamodel(Profesor.class)
public class Profesor_ extends Usuario_ {

    public static volatile SingularAttribute<Profesor, String> descripcionGeneral;
<<<<<<< HEAD
    public static volatile SetAttribute<Profesor, Institucion> instituciones;
    public static volatile SingularAttribute<Profesor, String> biografia;
    public static volatile SetAttribute<Profesor, Actividad> actividades;
=======
    public static volatile CollectionAttribute<Profesor, Institucion> instituciones;
    public static volatile SingularAttribute<Profesor, String> biografia;
    public static volatile CollectionAttribute<Profesor, Actividad> actividades;
>>>>>>> 3ac410e764c5b52ef05e05c71199681f9d3dcf95
    public static volatile SingularAttribute<Profesor, String> linkSitioWeb;

}