package Presenter.GestionEquipos;

import Model.DAO.GestionEquipo.SQLEquipoEliminado;
import Model.POJO.EquipoEliminado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionEquiposEliminados {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLEquipoEliminado sqlEquipoEliminado;

    private CallBackObtenerEquiposEliminados callBackObtenerEquiposEliminados;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionEquiposEliminados() {
        sqlEquipoEliminado = new SQLEquipoEliminado();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerEquiposEliminados(CallBackObtenerEquiposEliminados callBackObtenerEquiposEliminados) {
        this.callBackObtenerEquiposEliminados = callBackObtenerEquiposEliminados;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerEquiposEliminados() {
        try {
            final List<EquipoEliminado> equiposEliminados = sqlEquipoEliminado.obtenerEquiposEliminados();

            if (equiposEliminados == null) {
                callBackObtenerEquiposEliminados.errorObtenerEquiposEliminados("Se produjo un error al intentar obtener los equipos dados de baja, vuelve a intentarlo.");
            } else if (equiposEliminados.isEmpty()) {
                callBackObtenerEquiposEliminados.listaEquiposEliminadosVacia("No se encontraron registros de equipos dados de baja en la base de datos.");
            } else {
                callBackObtenerEquiposEliminados.equiposEliminadosObtenidos(equiposEliminados);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquiposEliminados - Obtener EquiposEliminados: " + e.getMessage());
            callBackObtenerEquiposEliminados.errorDesconocidoObtenerEquiposEliminados("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerEquiposEliminados {

        void equiposEliminadosObtenidos(final List<EquipoEliminado> equiposEliminados);

        void listaEquiposEliminadosVacia(final String msg);

        void errorObtenerEquiposEliminados(final String msg);

        void errorDesconocidoObtenerEquiposEliminados(final String msg);
    }

    // </editor-fold>
    
}