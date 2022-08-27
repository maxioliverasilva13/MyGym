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

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T16:31:10", comments="EclipseLink-2.7.10.v20211216-rNA")
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

}