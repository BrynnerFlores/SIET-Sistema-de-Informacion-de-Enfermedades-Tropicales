package Presenter.GestionMuestrasBiologicas;

import Model.DAO.GestionMuestraBiologica.SQLMuestraBiologica;
import Model.POJO.AspectoCalidad;
import Model.POJO.MuestraBiologica;
import Model.POJO.Parasito;
import Model.POJOPersonalizado.MuestraBiologicaPersonalizada;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionMuestrasBiologicas {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLMuestraBiologica sqlMuestraBiologica;

    private CallBackObtenerMuestrasBiologicas callBackObtenerMuestrasBiologicas;
    private CallBackCrearMuestraBiologica callBackCrearMuestraBiologica;
    private CallBackModificarMuestraBiologica callBackModificarMuestraBiologica;
    private CallBackEliminarMuestraBiologica callBackEliminarMuestraBiologica;
    private CallBackObtenerAspectos callBackObtenerAspectos;
    private CallBackObtenerParasitos callBackObtenerParasitos;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionMuestrasBiologicas() {
        sqlMuestraBiologica = new SQLMuestraBiologica();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerMuestrasBiologicas(CallBackObtenerMuestrasBiologicas callBackObtenerMuestrasBiologicas) {
        this.callBackObtenerMuestrasBiologicas = callBackObtenerMuestrasBiologicas;
    }

    public void setCallBackCrearMuestraBiologica(CallBackCrearMuestraBiologica callBackCrearMuestraBiologica) {
        this.callBackCrearMuestraBiologica = callBackCrearMuestraBiologica;
    }

    public void setCallBackModificarMuestraBiologica(CallBackModificarMuestraBiologica callBackModificarMuestraBiologica) {
        this.callBackModificarMuestraBiologica = callBackModificarMuestraBiologica;
    }

    public void setCallBackEliminarMuestraBiologica(CallBackEliminarMuestraBiologica callBackEliminarMuestraBiologica) {
        this.callBackEliminarMuestraBiologica = callBackEliminarMuestraBiologica;
    }

    public void setCallBackObtenerAspectos(CallBackObtenerAspectos callBackObtenerAspectos) {
        this.callBackObtenerAspectos = callBackObtenerAspectos;
    }

    public void setCallBackObtenerParasitos(CallBackObtenerParasitos callBackObtenerParasitos) {
        this.callBackObtenerParasitos = callBackObtenerParasitos;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerMuestrasBiologicas() {
        try {
            final List<MuestraBiologicaPersonalizada> muestrasBiologicasPersonalizadas = sqlMuestraBiologica.obtenerMuestrasBiologicas();

            if (muestrasBiologicasPersonalizadas == null) {
                callBackObtenerMuestrasBiologicas.errorObtenerMuestrasBiologicas("Se produjo un error al intentar obtener a las muestras biologicas, vuelve a intentarlo.");
            } else if (muestrasBiologicasPersonalizadas.isEmpty()) {
                callBackObtenerMuestrasBiologicas.listaMuestrasBiologicasVacia("No se encontraron registros de muestas biologicas en la base de datos.");
            } else {
                callBackObtenerMuestrasBiologicas.muestrasBiologicasObtenidas(muestrasBiologicasPersonalizadas);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionMuestasBiologicas - Obtener Muestras Biologicas: " + e.getMessage());
            callBackObtenerMuestrasBiologicas.errorDesconocidoObtenerMuestrasBiologicas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void crearMuestraBiologica(final MuestraBiologica muestraBiologica) {
        try {
            if (sqlMuestraBiologica.insertar(muestraBiologica)) {
                callBackCrearMuestraBiologica.muestraBiologicaCreada("Muestra biologica creada correctamente.");
            } else {
                callBackCrearMuestraBiologica.errorCrearMuestraBiologica("Se produjo un error al crear la muestra biologica.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionMuestasBiologicas - Crear Muestra Biologica: " + e.getMessage());
            callBackCrearMuestraBiologica.errorDesconocidoCrearMuestraBiologica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarMuestraBiologica(final MuestraBiologica muestraBiologica) {
        try {
            if (sqlMuestraBiologica.actualizar(muestraBiologica)) {
                callBackModificarMuestraBiologica.muestraBiologicaModificada("Muestra biologica modificada correctamente.");
            } else {
                callBackModificarMuestraBiologica.errorModificarMuestraBiologica("Se produjo un error al modificar la muestra biologica.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionMuestasBiologicas - Modificar Muestra Biologica: " + e.getMessage());
            callBackModificarMuestraBiologica.errorDesconocidoModificarMuestraBiologica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarMuestraBiologica(final MuestraBiologica muestraBiologica) {
        try {
            if (sqlMuestraBiologica.eliminar(muestraBiologica)) {
                callBackEliminarMuestraBiologica.muestraBiologicaEliminada();
            } else {
                callBackEliminarMuestraBiologica.errorEliminarMuestraBiologica("Se produjo un error al eliminar la muestra biologica.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionMuestasBiologicas - Eliminar Muestra Biologica: " + e.getMessage());
            callBackEliminarMuestraBiologica.errorDesconocidoEliminarMuestraBiologica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerAspectos(final MuestraBiologica muestraBiologica) {
        try {
            final List<AspectoCalidad> aspectos = sqlMuestraBiologica.obtenerAspectos(muestraBiologica);

            if (aspectos == null) {
                callBackObtenerAspectos.errorObtenerAspectos("Se produjo un error al obtener los aspectos, vuelve a intentarlo.");
            } else if (aspectos.isEmpty()) {
                callBackObtenerAspectos.listaAspectosVacia("No se encontraron registros de aspectos en la base de datos.");
            } else {
                callBackObtenerAspectos.aspectosObtenidos(aspectos);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionMuestasBiologicas - Obtener Aspectos: " + e.getMessage());
            callBackObtenerAspectos.errorDesconocidoObtenerAspectos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerParasitos(final MuestraBiologica muestraBiologica) {
        try {
            final List<Parasito> parasitos = sqlMuestraBiologica.obtenerParasitos(muestraBiologica);

            if (parasitos == null) {
                callBackObtenerParasitos.errorObtenerParasitos("Se produjo un error al obtener los parasitos, vuelve a intentarlo.");
            } else if (parasitos.isEmpty()) {
                callBackObtenerParasitos.listaParasitosVacia("No se encontraron registros de parásitos en la base de datos.");
            } else {
                callBackObtenerParasitos.parasitosObtenidos(parasitos);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionMuestasBiologicas - Obtener Parasitos: " + e.getMessage());
            callBackObtenerParasitos.errorDesconocidoObtenerParasitos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerMuestrasBiologicas {

        void muestrasBiologicasObtenidas(final List<MuestraBiologicaPersonalizada> muestrasBiologicasPersonalizadas);

        void listaMuestrasBiologicasVacia(final String msg);

        void errorObtenerMuestrasBiologicas(final String msg);

        void errorDesconocidoObtenerMuestrasBiologicas(final String msg);
    }

    public interface CallBackCrearMuestraBiologica {

        void muestraBiologicaCreada(final String msg);

        void errorCrearMuestraBiologica(final String msg);

        void errorDesconocidoCrearMuestraBiologica(final String msg);
    }

    public interface CallBackModificarMuestraBiologica {

        void muestraBiologicaModificada(final String msg);

        void errorModificarMuestraBiologica(final String msg);

        void errorDesconocidoModificarMuestraBiologica(final String msg);
    }

    public interface CallBackEliminarMuestraBiologica {

        void muestraBiologicaEliminada();

        void errorEliminarMuestraBiologica(final String msg);

        void errorDesconocidoEliminarMuestraBiologica(final String msg);
    }

    public interface CallBackObtenerAspectos {

        void aspectosObtenidos(final List<AspectoCalidad> aspectos);

        void listaAspectosVacia(final String msg);

        void errorObtenerAspectos(final String msg);

        void errorDesconocidoObtenerAspectos(final String msg);
    }

    public interface CallBackObtenerParasitos {

        void parasitosObtenidos(final List<Parasito> parasitos);

        void listaParasitosVacia(final String msg);

        void errorObtenerParasitos(final String msg);

        void errorDesconocidoObtenerParasitos(final String msg);
    }

    // </editor-fold>
    
}