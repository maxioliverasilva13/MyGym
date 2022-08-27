package Institucion;

import Actividad.Actividad;
import Profesor.Profesor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile SingularAttribute<Institucion, String> descripcion;
    public static volatile CollectionAttribute<Institucion, Profesor> profesores;
    public static volatile SingularAttribute<Institucion, Integer> id;
    public static volatile CollectionAttribute<Institucion, Actividad> actividades;
    public static volatile SingularAttribute<Institucion, String> nombre;
    public static volatile SingularAttribute<Institucion, String> url;

}