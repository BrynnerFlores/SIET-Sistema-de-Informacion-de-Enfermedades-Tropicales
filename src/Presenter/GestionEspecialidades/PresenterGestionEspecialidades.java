package Presenter.GestionEspecialidades;

import Model.DAO.GestionEspecialidad.SQLEspecialidad;
import Model.POJO.Especialidad;
import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.EspecialidadPersonalizada;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionEspecialidades {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLEspecialidad sqlEspecialidad;
    
    private CallBackObtenerEspecialidades callBackObtenerEspecialidades;
    private CallBackCrearEspecialidad callBackCrearEspecialidad;
    private CallBackObtenerSubespecialidadesAsignadas callBackObtenerSubespecialidadesAsignadas;
    private CallBackModificarEspecialidad callBackModificarEspecialidad;
    private CallBackEliminarEspecialidad callBackEliminarEspecialidad;
    private CallBackVerificarExistenciaEspecialidad callBackVerificarExistenciaEspecialidad;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionEspecialidades() {
        sqlEspecialidad = new SQLEspecialidad();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerEspecialidades(CallBackObtenerEspecialidades callBackObtenerEspecialidades) {
        this.callBackObtenerEspecialidades = callBackObtenerEspecialidades;
    }

    public void setCallBackCrearEspecialidad(CallBackCrearEspecialidad callBackCrearEspecialidad) {
        this.callBackCrearEspecialidad = callBackCrearEspecialidad;
    }
    
    public void setCallBackObtenerSubespecialidadesAsignadas(CallBackObtenerSubespecialidadesAsignadas callBackObtenerSubespecialidadesAsignadas) {
        this.callBackObtenerSubespecialidadesAsignadas = callBackObtenerSubespecialidadesAsignadas;
    }

    public void setCallBackModificarEspecialidad(CallBackModificarEspecialidad callBackModificarEspecialidad) {
        this.callBackModificarEspecialidad = callBackModificarEspecialidad;
    }

    public void setCallBackEliminarEspecialidad(CallBackEliminarEspecialidad callBackEliminarEspecialidad) {
        this.callBackEliminarEspecialidad = callBackEliminarEspecialidad;
    }

    public void setCallBackVerificarExistenciaEspecialidad(CallBackVerificarExistenciaEspecialidad callBackVerificarExistenciaEspecialidad) {
        this.callBackVerificarExistenciaEspecialidad = callBackVerificarExistenciaEspecialidad;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerEspecialidades() {
        try {
            final List<EspecialidadPersonalizada> especialidadesPersonalizadas = sqlEspecialidad.obtenerTodos();

            if (especialidadesPersonalizadas == null) {
                callBackObtenerEspecialidades.errorObtenerEspecialidades("Se produjo un error al intentar obtener a las especialidades, vuelve a intentarlo.");
            } else if (especialidadesPersonalizadas.isEmpty()) {
                callBackObtenerEspecialidades.listaEspecialidadesVacia("No se encontraron registros de especialidades en la base de datos.");
            } else {
                callBackObtenerEspecialidades.especialidadesObtenidas(especialidadesPersonalizadas);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEspecialidades - Obtener Especialidades: " + e.getMessage());
            callBackObtenerEspecialidades.errorDesconocidoObtenerEspecialidades("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void crearEspecialidad(final Especialidad especialidad) {
        try {
            final int result = sqlEspecialidad.verificarExistencia(especialidad);

            switch (result) {
                case 0:
                    if (sqlEspecialidad.insertar(especialidad)) {
                        callBackCrearEspecialidad.especialidadCreada("Especialidad creada exitosamente.");
                    } else {
                        callBackCrearEspecialidad.errorCrearEspecialidad("Se produjo un error al crear la especialidad, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaEspecialidad.especialidadExiste("Ya existe una especialidad con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEspecialidad.errorVerificarExistenciaEspecialidad("Se produjo un error al verificar la existencia de alguna especialidad con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEspecialidades - Crear Especialidad: " + e.getMessage());
            callBackCrearEspecialidad.errorDesconocidoCrearEspecialidad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerSubespecialidadesAsignadas(final Especialidad especialidad) {
        try {
            final List<Subespecialidad> especialidadesSubespecialidades = sqlEspecialidad.obtenerSubespecialidadesAsignadas(especialidad);

            if (especialidadesSubespecialidades == null) {
                callBackObtenerSubespecialidadesAsignadas.errorObtenerSubespecialidadesAsignadas("Se produjo un error al intentar obtener a las subespecialidades, vuelve a intentarlo.");
            } else if (especialidadesSubespecialidades.isEmpty()) {
                callBackObtenerSubespecialidadesAsignadas.listaSubespecialidadesAsignadasVacia("No se encontraron subespecialidades asignadas a esta especialidad.");
            } else {
                callBackObtenerSubespecialidadesAsignadas.subespecialidadesAsignadasObtenidas(especialidadesSubespecialidades);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEspecialidades - Obtener Subespecialidades Asignadas: " + e.getMessage());
            callBackObtenerSubespecialidadesAsignadas.errorDesconocidoObtenerSubespecialidadesAsignadas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarEspecialidad(final Especialidad especialidad) {
        try {
            final int result = sqlEspecialidad.verificarExistencia(especialidad);

            switch (result) {
                case 0:
                    if (sqlEspecialidad.actualizar(especialidad)) {
                        callBackModificarEspecialidad.especialidadModificada("Especialidad modificada correctamente.");
                    } else {
                        callBackModificarEspecialidad.errorModificarEspecialidad("Se produjo un error al modificar la especialidad.");
                    }
                    break;
                case 1:
                    callBackVerificarExistenciaEspecialidad.especialidadExiste("Ya existe una especialidad con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEspecialidad.errorVerificarExistenciaEspecialidad("Se produjo un error al verificar la existencia de alguna especialidad con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEspecialidades - Modificar Especialidad: " + e.getMessage());
            callBackModificarEspecialidad.errorDesconocidoModificarEspecialidad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarEspecialidad(final Especialidad especialidad) {
        try {
            if (sqlEspecialidad.eliminar(especialidad)) {
                callBackEliminarEspecialidad.especialidadEliminada("Especialidad Eliminada.");
            } else {
                callBackEliminarEspecialidad.errorEliminarEspecialidad("Se produjo un error al eliminar la especialidad.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEspecialidades - Eliminar Especialidade: " + e.getMessage());
            callBackEliminarEspecialidad.errorDesconocidoEliminarEspecialidad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerEspecialidades {

        void especialidadesObtenidas(final List<EspecialidadPersonalizada> especialidadesPersonalizadas);

        void listaEspecialidadesVacia(final String msg);

        void errorObtenerEspecialidades(final String msg);

        void errorDesconocidoObtenerEspecialidades(final String msg);
    }

    public interface CallBackVerificarExistenciaEspecialidad {

        void especialidadExiste(final String msg);

        void errorVerificarExistenciaEspecialidad(final String msg);
    }

    public interface CallBackCrearEspecialidad {

        void especialidadCreada(final String msg);

        void errorCrearEspecialidad(final String msg);

        void errorDesconocidoCrearEspecialidad(final String msg);
    }

    public interface CallBackObtenerSubespecialidadesDisponibles {

        void tablaSubespecialidadesVacia(final String msg);
        
        void subespecialidadesDisponiblesObtenidas(final List<Subespecialidad> subespecialidades);

        void listaSubespecialidadesDisponiblesVacia(final String msg);

        void errorVerificarTablaSubespecialidadesVacia(final String msg);
        
        void errorObtenerSubespecialidadesDisponibles(final String msg);

        void errorDesconocidoObtenerSubespecialidadesDisponibles(final String msg);

        void errorDesconocidoVerificarTablaSubespecialidadesVacia(final String msg);

    }

    public interface CallBackObtenerSubespecialidadesAsignadas {

        void subespecialidadesAsignadasObtenidas(final List<Subespecialidad> especialidadesSubespecialidades);

        void listaSubespecialidadesAsignadasVacia(final String msg);

        void errorObtenerSubespecialidadesAsignadas(final String msg);

        void errorDesconocidoObtenerSubespecialidadesAsignadas(final String msg);
    }

    public interface CallBackModificarEspecialidad {

        void especialidadModificada(final String msg);

        void errorModificarEspecialidad(final String msg);

        void errorDesconocidoModificarEspecialidad(final String msg);
    }

    public interface CallBackEliminarEspecialidad {

        void especialidadEliminada(final String msg);

        void errorEliminarEspecialidad(final String msg);

        void errorDesconocidoEliminarEspecialidad(final String msg);
    }

    // </editor-fold>
    
}