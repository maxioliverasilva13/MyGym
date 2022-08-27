package Profesor;

import Actividad.Actividad;
import Institucion.Institucion;
import Usuario.Usuario_;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Profesor.class)
public class Profesor_ extends Usuario_ {

    public static volatile SingularAttribute<Profesor, String> descripcionGeneral;
    public static volatile CollectionAttribute<Profesor, Institucion> instituciones;
    public static volatile SingularAttribute<Profesor, String> biografia;
    public static volatile CollectionAttribute<Profesor, Actividad> actividades;
    public static volatile SingularAttribute<Profesor, String> linkSitioWeb;

}