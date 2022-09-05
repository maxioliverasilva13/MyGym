package Institucion;

import Actividad.Actividad;
import Profesor.Profesor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-04T19:29:21")
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile SingularAttribute<Institucion, String> descripcion;
    public static volatile ListAttribute<Institucion, Profesor> profesores;
    public static volatile SingularAttribute<Institucion, Integer> id;
    public static volatile ListAttribute<Institucion, Actividad> actividades;
    public static volatile SingularAttribute<Institucion, String> nombre;
    public static volatile SingularAttribute<Institucion, String> url;

}