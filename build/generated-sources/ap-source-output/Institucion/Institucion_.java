package Institucion;

import Actividad.Actividad;
import Profesor.Profesor;
import javax.annotation.processing.Generated;
<<<<<<< HEAD
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-27T15:47:43", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> 3ac410e764c5b52ef05e05c71199681f9d3dcf95
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile SingularAttribute<Institucion, String> descripcion;
<<<<<<< HEAD
    public static volatile ListAttribute<Institucion, Profesor> profesores;
    public static volatile SingularAttribute<Institucion, Integer> id;
    public static volatile ListAttribute<Institucion, Actividad> actividades;
=======
    public static volatile CollectionAttribute<Institucion, Profesor> profesores;
    public static volatile SingularAttribute<Institucion, Integer> id;
    public static volatile CollectionAttribute<Institucion, Actividad> actividades;
>>>>>>> 3ac410e764c5b52ef05e05c71199681f9d3dcf95
    public static volatile SingularAttribute<Institucion, String> nombre;
    public static volatile SingularAttribute<Institucion, String> url;

}