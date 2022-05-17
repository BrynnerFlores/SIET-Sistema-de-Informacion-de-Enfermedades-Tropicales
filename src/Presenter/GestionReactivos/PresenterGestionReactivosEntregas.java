package Presenter.GestionReactivos;

import Model.DAO.GestionReactivo.SQLReactivoEntrega;
import Model.POJO.LoteEliminado;
import Model.POJO.ReactivoEntrega;
import Model.POJO.ReactivoLote;
import Model.POJOPersonalizado.ReactivoEntregaPersonalizado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionReactivosEntregas {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLReactivoEntrega sqlReactivoEntrega;

    private CallBackRegistrarEntrega callBackRegistrarEntrega;
    private CallBackObtenerEntregas callBackObtenerEntregas;
    private CallBackObtenerLotes callBackObtenerLotes;
    private CallBackObtenerLotesEliminados callBackObtenerLotesEliminados;
    private CallBackActualizarEntrega callBackActualizarEntrega;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionReactivosEntregas() {
        sqlReactivoEntrega = new SQLReactivoEntrega();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackRegistrarEntrega(CallBackRegistrarEntrega callBackRegistrarEntrega) {
        this.callBackRegistrarEntrega = callBackRegistrarEntrega;
    }

    public void setCallBackObtenerEntregas(CallBackObtenerEntregas callBackObtenerEntregas) {
        this.callBackObtenerEntregas = callBackObtenerEntregas;
    }

    public void setCallBackObtenerLotes(CallBackObtenerLotes callBackObtenerLotes) {
        this.callBackObtenerLotes = callBackObtenerLotes;
    }

    public void setCallBackObtenerLotesEliminados(CallBackObtenerLotesEliminados callBackObtenerLotesEliminados) {
        this.callBackObtenerLotesEliminados = callBackObtenerLotesEliminados;
    }

    public void setCallBackActualizarEntrega(CallBackActualizarEntrega callBackActualizarEntrega) {
        this.callBackActualizarEntrega = callBackActualizarEntrega;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void registrarEntrega(final ReactivoEntrega reactivoEntrada) {
        try {
            if (sqlReactivoEntrega.insertar(reactivoEntrada)) {
                callBackRegistrarEntrega.entregaRegistrada("Registrado correctamente.");
            } else {
                callBackRegistrarEntrega.errorRegistrarEntrega("Se produjo un error en el registro de la nueva entrega.");
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosEntregas - Registrar Entrega: " + e.getMessage());
            callBackRegistrarEntrega.errorDesconocidoRegistrarEntrega("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void actualizarEntrega(final ReactivoEntrega reactivoEntrada) {
        try {
            if (sqlReactivoEntrega.actualizarEntrega(reactivoEntrada)) {
                callBackActualizarEntrega.entregaActualizada("Entrega actualizada.");
            } else {
                callBackActualizarEntrega.errorActualizarEntrega("Se produjo un error en la actualización de la entrega.");
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosEntregas - Actualizar Entrega: " + e.getMessage());
            callBackActualizarEntrega.errorDesconocidoActualizarEntrega("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerEntregas() {
        try {
            final List<ReactivoEntregaPersonalizado> reactivosEntregasPersonalizadas = sqlReactivoEntrega.obtenerEntregas();

            if (reactivosEntregasPersonalizadas == null) {
                callBackObtenerEntregas.errorObtenerEntregas("Se produjo un error al obtener a los datos de las entregas, vuelve a intentarlo.");
            } else if (reactivosEntregasPersonalizadas.isEmpty()) {
                callBackObtenerEntregas.listaEntregasVacia("No se encontraron registros de entregas en la base de datos.");
            } else {
                callBackObtenerEntregas.entregasObtenidas(reactivosEntregasPersonalizadas);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivoEntregas - Obtener Entregas: " + e.getMessage());
            callBackObtenerEntregas.errorDesconocidoObtenerEntregas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerLotes(final ReactivoEntrega reactivoEntrega) {
        try {
            final List<ReactivoLote> reactivosLotes = sqlReactivoEntrega.obtenerLotes(reactivoEntrega);

            if (reactivosLotes == null) {
                callBackObtenerLotes.errorObtenerLotes("Se produjo un error al obtener a los lotes de la entrega, vuelve a intentarlo.");
            } else if (reactivosLotes.isEmpty()) {
                callBackObtenerLotes.listaLotesVacia("No se encontraron registros de lotes en la base de datos.");
            } else {
                callBackObtenerLotes.lotesObtenidos(reactivosLotes);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivoEntregas - Obtener Lotes: " + e.getMessage());
            callBackObtenerLotes.errorDesconocidoObtenerLotes("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerLotesEliminados(final ReactivoEntrega reactivoEntrega) {
        try {
            final List<LoteEliminado> lotesEliminados = sqlReactivoEntrega.obtenerLotesEliminados(reactivoEntrega);

            if (lotesEliminados == null) {
                callBackObtenerLotesEliminados.errorObtenerLotesEliminados("Se produjo un error, vuelve a intentarlo.");
            } else if (lotesEliminados.isEmpty()) {
                callBackObtenerLotesEliminados.listaLotesEliminadosVacia("No se encontraron registros de lotes eliminados en la base de datos.");
            } else {
                callBackObtenerLotesEliminados.lotesEliminadosObtenidos(lotesEliminados);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivoEntregas - Obtener Lotes Eliminados: " + e.getMessage());
            callBackObtenerLotesEliminados.errorDesconocidoObtenerLotesEliminados("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackRegistrarEntrega {

        void entregaRegistrada(final String msg);

        void errorRegistrarEntrega(final String msg);

        void errorDesconocidoRegistrarEntrega(final String msg);
    }
    
    public interface CallBackActualizarEntrega {

        void entregaActualizada(final String msg);

        void errorActualizarEntrega(final String msg);

        void errorDesconocidoActualizarEntrega(final String msg);
    }
    
    public interface CallBackObtenerEntregas {

        void entregasObtenidas(final List<ReactivoEntregaPersonalizado> reactivosEntregasPersonalizadas);

        void listaEntregasVacia(final String msg);

        void errorObtenerEntregas(final String msg);

        void errorDesconocidoObtenerEntregas(final String msg);
    }
    
    public interface CallBackObtenerLotes {

        void lotesObtenidos(final List<ReactivoLote> reactivosLotesLotes);

        void listaLotesVacia(final String msg);

        void errorObtenerLotes(final String msg);

        void errorDesconocidoObtenerLotes(final String msg);
    }
    
    public interface CallBackObtenerLotesEliminados {

        void lotesEliminadosObtenidos(final List<LoteEliminado> lotesEliminados);

        void listaLotesEliminadosVacia(final String msg);

        void errorObtenerLotesEliminados(final String msg);

        void errorDesconocidoObtenerLotesEliminados(final String msg);
    }
    
    // </editor-fold>
    
}