package Presenter.GestionReportes;

import Model.DAO.GestionReportes.SQLInformeMensualLaboratorio;
import Model.POJOPersonalizado.ResultadoGeneralReportePersonalizado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionReportes {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLInformeMensualLaboratorio sqlInformeMensualLaboratorio;
    
    private CallBackInformeMensualLaboratorio callBackInformeMensualLaboratorio;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionReportes() {
        sqlInformeMensualLaboratorio = new SQLInformeMensualLaboratorio();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackInformeMensualLaboratorio(CallBackInformeMensualLaboratorio callBackInformeMensualLaboratorio) {
        this.callBackInformeMensualLaboratorio = callBackInformeMensualLaboratorio;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerInformeMensualLaboratorio(final int month, final int year) {
        try {
            final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado = sqlInformeMensualLaboratorio.obtenerResultadosGenerales(month, year);
            
            if (resultadosGeneralesReportePersonalizado == null) {
                callBackInformeMensualLaboratorio.errorGenerarInformeMensualLaboratorio("Se produjo un error.");
            } else if (resultadosGeneralesReportePersonalizado.isEmpty()) {
                callBackInformeMensualLaboratorio.informeMensualVacio("No se encontraron registros en la base de datos.");
            } else {
                callBackInformeMensualLaboratorio.informeMensualGenerado(resultadosGeneralesReportePersonalizado);
            }
        } catch (final Exception exception) {
            System.err.println("Error en PresenterGestionReportes - Obtener Informe Mensual Laboratorio: " + exception.getMessage());
            callBackInformeMensualLaboratorio.errorDesconocidoGenerarInformeMensualLaboratorio("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackInformeMensualLaboratorio {

        void informeMensualGenerado(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesPersonalizados);

        void informeMensualVacio(final String msg);

        void errorGenerarInformeMensualLaboratorio(final String msg);

        void errorDesconocidoGenerarInformeMensualLaboratorio(final String msg);
    }
    
    // </editor-fold>
    
}