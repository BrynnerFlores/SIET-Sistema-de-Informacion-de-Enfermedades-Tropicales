package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class UnidadEliminada {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoUnidadEliminada;
    private ReactivoLote reactivoLote;
    private String causaEliminacion;
    private Date fechaEliminacion;
    private Time horaEliminacion;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public UnidadEliminada(int codigoUnidadEliminada, ReactivoLote reactivoLote, String causaEliminacion, Date fechaEliminacion, Time horaEliminacion) {
        this.codigoUnidadEliminada = codigoUnidadEliminada;
        this.reactivoLote = reactivoLote;
        this.causaEliminacion = causaEliminacion;
        this.fechaEliminacion = fechaEliminacion;
        this.horaEliminacion = horaEliminacion;
    }
    
    public UnidadEliminada(ReactivoLote reactivoLote, String causaEliminacion, Date fechaEliminacion, Time horaEliminacion) {
        this.reactivoLote = reactivoLote;
        this.causaEliminacion = causaEliminacion;
        this.fechaEliminacion = fechaEliminacion;
        this.horaEliminacion = horaEliminacion;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoUnidadEliminada() {
        return codigoUnidadEliminada;
    }

    public void setCodigoUnidadEliminada(int codigoUnidadEliminada) {
        this.codigoUnidadEliminada = codigoUnidadEliminada;
    }

    public ReactivoLote getReactivoLote() {
        return reactivoLote;
    }

    public void setReactivoLote(ReactivoLote reactivoLote) {
        this.reactivoLote = reactivoLote;
    }

    public String getCausaEliminacion() {
        return causaEliminacion;
    }

    public void setCausaEliminacion(String causaEliminacion) {
        this.causaEliminacion = causaEliminacion;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    public Time getHoraEliminacion() {
        return horaEliminacion;
    }

    public void setHoraEliminacion(Time horaEliminacion) {
        this.horaEliminacion = horaEliminacion;
    }
    
    // </editor-fold>
    
}