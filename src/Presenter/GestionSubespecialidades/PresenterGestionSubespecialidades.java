package Presenter.GestionSubespecialidades;

import Model.DAO.GestionSubespecialidad.SQLSubespecialidad;
import Model.POJO.Enfermedad;
import Model.POJO.MuestraBiologica;
import Model.POJO.Subespecialidad;
import Model.POJO.SubespecialidadMuestra;
import Model.POJOPersonalizado.SubespecialidadPersonalizada;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionSubespecialidades {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLSubespecialidad sqlSubespecialidad;
    
    private CallBackObtenerSubespecialidades callBackObtenerSubespecialidades;
    private CallBackVerificarExistenciaSubespecialidad callBackVerificarExistenciaSubespecialidad;
    private CallBackCrearSubespecialidad callBackCrearSubespecialidad;
    private CallBackObtenerMuestrasBiologicasDisponibles callBackObtenerMuestrasBiologicasDisponibles;
    private CallBackObtenerMuestrasBiologicasAsignadas callBackObtenerMuestrasBiologicasAsignadas;
    private CallBackObtenerEnfermedades callBackObtenerEnfermedades;
    private CallBackModificarSubespecialidad callBackModificarSubespecialidad;
    private CallBackEliminarSubespecialidad callBackEliminarSubespecialidad;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionSubespecialidades() {
        sqlSubespecialidad = new SQLSubespecialidad();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerSubespecialidades(CallBackObtenerSubespecialidades callBackObtenerSubespecialidades) {
        this.callBackObtenerSubespecialidades = callBackObtenerSubespecialidades;
    }

    public void setCallBackVerificarExistenciaSubespecialidad(CallBackVerificarExistenciaSubespecialidad callBackVerificarExistenciaSubespecialidad) {
        this.callBackVerificarExistenciaSubespecialidad = callBackVerificarExistenciaSubespecialidad;
    }

    public void setCallBackCrearSubespecialidad(CallBackCrearSubespecialidad callBackCrearSubespecialidad) {
        this.callBackCrearSubespecialidad = callBackCrearSubespecialidad;
    }

    public void setCallBackObtenerMuestrasBiologicasDisponibles(CallBackObtenerMuestrasBiologicasDisponibles callBackObtenerMuestrasBiologicasDisponibles) {
        this.callBackObtenerMuestrasBiologicasDisponibles = callBackObtenerMuestrasBiologicasDisponibles;
    }

    public void setCallBackObtenerMuestrasBiologicasAsignadas(CallBackObtenerMuestrasBiologicasAsignadas callBackObtenerMuestrasBiologicasAsignadas) {
        this.callBackObtenerMuestrasBiologicasAsignadas = callBackObtenerMuestrasBiologicasAsignadas;
    }

    public void setCallBackObtenerEnfermedades(CallBackObtenerEnfermedades callBackObtenerEnfermedades) {
        this.callBackObtenerEnfermedades = callBackObtenerEnfermedades;
    }

    public void setCallBackModificarSubespecialidad(CallBackModificarSubespecialidad callBackModificarSubespecialidad) {
        this.callBackModificarSubespecialidad = callBackModificarSubespecialidad;
    }

    public void setCallBackEliminarSubespecialidad(CallBackEliminarSubespecialidad callBackEliminarSubespecialidad) {
        this.callBackEliminarSubespecialidad = callBackEliminarSubespecialidad;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerSubespecialidades() {
        try {
            final List<SubespecialidadPersonalizada> subespecialidadesPersonalizadas = sqlSubespecialidad.obtenerTodos();

            if (subespecialidadesPersonalizadas == null) {
                callBackObtenerSubespecialidades.errorObtenerSubespecialidades("Se produjo un error al intentar obtener a las subespecialidades, vuelve a intentarlo.");
            } else if (subespecialidadesPersonalizadas.isEmpty()) {
                callBackObtenerSubespecialidades.listaSubespecialidadesVacia("No se encontraron registros de subespecialidades en la base de datos.");
            } else {
                callBackObtenerSubespecialidades.subespecialidadesObtenidas(subespecialidadesPersonalizadas);
            }
        } catch (final Exception e) {
            System.err.println("Error en:\nClase = PresenterGestionSubespecilidades\nMetodo = obtenerSubespecialidades\nError = " + e.getMessage());
            callBackObtenerSubespecialidades.errorDesconocidoObtenerSubespecialidades("Se produjo un error desconocido, vuelve a intentarlo. Si el error persiste, contactate con el desarrollador.");
        }
    }

    public void crearSubespecialidad(final Subespecialidad subespecialidad) {
        try {
            final int result = sqlSubespecialidad.verificarExistencia(subespecialidad);

            switch (result) {
                case 0:
                    if (sqlSubespecialidad.insertar(subespecialidad)) {
                        callBackCrearSubespecialidad.subespecialidadCreada("Subespecialidad creada exitosamente.");
                    } else {
                        callBackCrearSubespecialidad.errorCrearSubespecialidad("Se produjo un error al crear la subespecialidad, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaSubespecialidad.existeSubespecialidad("Ya existe una subespecialidad con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaSubespecialidad.errorVerificarExistenciaSubespecialidad("Se produjo un error al verificar la existencia de alguna subespecialidad con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en:\nClase = PresenterGestionSubespecilidades\nMetodo = crearSubespecialidad\nError = " + e.getMessage());
            callBackCrearSubespecialidad.errorDesconocidoCrearSubespecialidad("Se produjo un error desconocido, vuelve a intentarlo. Si el error persiste, contactate con el desarrollador.");
        }
    }

    public void obtenerMuestrasBiologicasDisponibles(final Subespecialidad subespecialidad) {
        try {
            final int result = sqlSubespecialidad.verificarTablaVaciaMuestrasBiologicas();

            switch (result) {
                case 0:
                    callBackObtenerMuestrasBiologicasDisponibles.tablaMuestrasBiologicasVacia("No se encontraron registros de muestras biológicas en la base de datos.");
                    break;

                case 1:
                    final List<MuestraBiologica> muestrasBiologicas = sqlSubespecialidad.obtenerMuestrasBiologicasDisponibles(subespecialidad);

                    if (muestrasBiologicas == null) {
                        callBackObtenerMuestrasBiologicasDisponibles.errorObtenerMuestrasBiologicasDisponibles("Se produjo un error al intentar obtener a las muestras biologicas, vuelve a intentarlo.");
                    } else if (muestrasBiologicas.isEmpty()) {
                        callBackObtenerMuestrasBiologicasDisponibles.listaMuestrasBiologicasDisponiblesVacia("Todas las muestras biologicas disponibles ya estan asignadas a esta subespecialidad.");
                    } else {
                        callBackObtenerMuestrasBiologicasDisponibles.muestrasBiologicasDisponiblesObtenidas(muestrasBiologicas);
                    }
                    break;

                case -1:
                    callBackObtenerMuestrasBiologicasDisponibles.errorVerificarTablaMuestrasBiologicasVacia("Se produjo un error en la verifiación de datos existe en la tabla de las muestras biológicas.");
                    break;

                default:
                    callBackObtenerMuestrasBiologicasDisponibles.errorDesconocidoVerificarTablaMuestrasBiologicasVacia("Se produjo un error desconocido en la verificación de datos en la tabla de las muestras biológicas.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionSubespecialidades - Obtener Especialidades Disponibles: " + e.getMessage());
            callBackObtenerMuestrasBiologicasDisponibles.errorDesconocidoObtenerMuestrasBiologicasDisponibles("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerMuestrasBiologicasAsignadas(final Subespecialidad subespecialidad) {
        try {
            final List<SubespecialidadMuestra> subespecialidadesMuestras = sqlSubespecialidad.obtenerMuestrasBiologicasAsignadas(subespecialidad);

            if (subespecialidadesMuestras == null) {
                callBackObtenerMuestrasBiologicasAsignadas.errorObtenerMuestrasBiologicasAsignadas("Se produjo un error al intentar obtener a las muestras biologicas, vuelve a intentarlo.");
            } else if (subespecialidadesMuestras.isEmpty()) {
                callBackObtenerMuestrasBiologicasAsignadas.listaMuestrasBiologicasAsignadasVacia("No se encontraron muestras biologicas asignadas a esta subespecialidad.");
            } else {
                callBackObtenerMuestrasBiologicasAsignadas.muestrasBiologicasAsignadasObtenidas(subespecialidadesMuestras);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionSubespecialidades - Obtener Especialidades Asignadas: " + e.getMessage());
            callBackObtenerMuestrasBiologicasAsignadas.errorDesconocidoObtenerMuestrasBiologicasAsignadas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerEnfermedades(final Subespecialidad subespecialidad) {
        try {
            final List<Enfermedad> enfermedades = sqlSubespecialidad.obtenerEnfermedades(subespecialidad);
            
            if (enfermedades == null) {
                callBackObtenerEnfermedades.errorObtenerEnfermedades("Se produjo un error, vuelve a intentarlo.");
            } else if (enfermedades.isEmpty()) {
                callBackObtenerEnfermedades.listaEnfermedadesVacia("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerEnfermedades.enfermedadesObtenidas(enfermedades);
            }
        } catch (final Exception e) {
            System.err.println("Error en:\nClase = PresenterGestionEnfermedades\nMetodo = Obtener Enfermedades\nError = " + e.getMessage());
            callBackObtenerEnfermedades.errorDesconocidoObtenerEnfermedades("Se produjo un error desconocido, vuelve a intentarlo. Si el error persiste, contactate con el desarrollador.");
        }
    }
    
    public void modificarSubespecialidad(final Subespecialidad subespecialidad) {
        try {
            final int result = sqlSubespecialidad.verificarExistencia(subespecialidad);

            switch (result) {
                case 0:
                    if (sqlSubespecialidad.actualizar(subespecialidad)) {
                        callBackModificarSubespecialidad.subespecialidadModificada("Subespecialidad modificada correctamente.");
                    } else {
                        callBackModificarSubespecialidad.errorModificarSubespecialidad("Se produjo un error al modificar la subespecialidad.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaSubespecialidad.existeSubespecialidad("Ya existe una subespecialidad con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaSubespecialidad.errorVerificarExistenciaSubespecialidad("Se produjo un error al verificar la existencia de alguna subespecialidad con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionSubspecialidades - Modificar Subespecialidad: " + e.getMessage());
            callBackModificarSubespecialidad.errorDesconocidoModificarSubespecialidad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void eliminarSubespecialidad(final Subespecialidad subespecialidad) {
        try {
            if (sqlSubespecialidad.eliminar(subespecialidad)) {
                callBackEliminarSubespecialidad.subespecialidadEliminada("Subespecialidad Eliminada.");
            } else {
                callBackEliminarSubespecialidad.errorEliminarSubespecialidad("Se produjo un error al eliminar la subespecialidad.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionSubspecialidades - Eliminar Subespecialidad: " + e.getMessage());
            callBackEliminarSubespecialidad.errorDesconocidoEliminarSubespecialidad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackCrearSubespecialidad {

        void subespecialidadCreada(final String msg);

        void errorCrearSubespecialidad(final String msg);

        void errorDesconocidoCrearSubespecialidad(final String msg);
    }

    public interface CallBackObtenerSubespecialidades {

        void subespecialidadesObtenidas(final List<SubespecialidadPersonalizada> subespecialidadesPersonalizadas);

        void listaSubespecialidadesVacia(final String msg);

        void errorObtenerSubespecialidades(final String msg);

        void errorDesconocidoObtenerSubespecialidades(final String msg);
    }

    public interface CallBackObtenerMuestrasBiologicasDisponibles {

        void tablaMuestrasBiologicasVacia(final String msg);

        void muestrasBiologicasDisponiblesObtenidas(final List<MuestraBiologica> muestrasBiologicas);

        void listaMuestrasBiologicasDisponiblesVacia(final String msg);

        void errorVerificarTablaMuestrasBiologicasVacia(final String msg);

        void errorObtenerMuestrasBiologicasDisponibles(final String msg);

        void errorDesconocidoVerificarTablaMuestrasBiologicasVacia(final String msg);

        void errorDesconocidoObtenerMuestrasBiologicasDisponibles(final String msg);
    }

    public interface CallBackObtenerMuestrasBiologicasAsignadas {

        void muestrasBiologicasAsignadasObtenidas(final List<SubespecialidadMuestra> subespecialidadesMuestras);

        void listaMuestrasBiologicasAsignadasVacia(final String msg);

        void errorObtenerMuestrasBiologicasAsignadas(final String msg);

        void errorDesconocidoObtenerMuestrasBiologicasAsignadas(final String msg);
    }
    
    public interface CallBackObtenerEnfermedades {

        void enfermedadesObtenidas(final List<Enfermedad> enfermedades);

        void listaEnfermedadesVacia(final String msg);

        void errorObtenerEnfermedades(final String msg);

        void errorDesconocidoObtenerEnfermedades(final String msg);
    }

    public interface CallBackModificarSubespecialidad {

        void subespecialidadModificada(final String msg);

        void errorModificarSubespecialidad(final String msg);

        void errorDesconocidoModificarSubespecialidad(final String msg);
    }
    
    public interface CallBackEliminarSubespecialidad {

        void subespecialidadEliminada(final String msg);

        void errorEliminarSubespecialidad(final String msg);

        void errorDesconocidoEliminarSubespecialidad(final String msg);
    }

    public interface CallBackVerificarExistenciaSubespecialidad {

        void existeSubespecialidad(final String msg);

        void errorVerificarExistenciaSubespecialidad(final String msg);
    }

    // </editor-fold>
    
}