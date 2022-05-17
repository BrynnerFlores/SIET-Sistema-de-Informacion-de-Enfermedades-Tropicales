package Model.POJO.Reportes.ResultadoExamen;

import java.sql.Date;

/**
 *
 * @author Brynner
 */
public class TablaResultadoBaciloscopia {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private Date fechaProceso;
    private String muestra;
    private Date fechaRecepcionMuestra;
    private Date fechaProcesoMuestra;
    private String calidadMuestra;
    private String resultado1;
    private String resultado2;
    private String resultado3;
    private String resultado4;
    private String resultado5;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public TablaResultadoBaciloscopia(Date fechaProceso, String muestra, Date fechaRecepcionMuestra, Date fechaProcesoMuestra, String calidadMuestra, String resultado1, String resultado2, String resultado3, String resultado4, String resultado5) {
        this.fechaProceso = fechaProceso;
        this.muestra = muestra;
        this.fechaRecepcionMuestra = fechaRecepcionMuestra;
        this.fechaProcesoMuestra = fechaProcesoMuestra;
        this.calidadMuestra = calidadMuestra;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
        this.resultado3 = resultado3;
        this.resultado4 = resultado4;
        this.resultado5 = resultado5;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public Date getFechaProceso() {
        return fechaProceso;
    }

    public String getMuestra() {
        return muestra;
    }

    public Date getFechaRecepcionMuestra() {
        return fechaRecepcionMuestra;
    }

    public Date getFechaProcesoMuestra() {
        return fechaProcesoMuestra;
    }

    public String getCalidadMuestra() {
        return calidadMuestra;
    }

    public String getResultado1() {
        return resultado1;
    }

    public String getResultado2() {
        return resultado2;
    }

    public String getResultado3() {
        return resultado3;
    }

    public String getResultado4() {
        return resultado4;
    }

    public String getResultado5() {
        return resultado5;
    }

    // </editor-fold>
    
}