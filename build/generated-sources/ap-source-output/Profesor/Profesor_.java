package Profesor;

import Actividad.Actividad;
import Institucion.Institucion;
import Usuario.Usuario_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-04T19:29:21")
@StaticMetamodel(Profesor.class)
public class Profesor_ extends Usuario_ {

    public static volatile SingularAttribute<Profesor, String> descripcionGeneral;
    public static volatile SetAttribute<Profesor, Institucion> instituciones;
    public static volatile SingularAttribute<Profesor, String> biografia;
    public static volatile SetAttribute<Profesor, Actividad> actividades;
    public static volatile SingularAttribute<Profesor, String> linkSitioWeb;

}