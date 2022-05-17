package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class LoteEliminado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private int codigoLoteEliminado;
    private ReactivoLote reactivoLote;
    private String causaEliminacion;
    private Date fechaEliminacion;
    private Time horaEliminacion;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public LoteEliminado(int codigoLoteEliminado, ReactivoLote reactivoLote, String causaEliminacion, Date fechaEliminacion, Time horaEliminacion) {
        this.codigoLoteEliminado = codigoLoteEliminado;
        this.reactivoLote = reactivoLote;
        this.causaEliminacion = causaEliminacion;
        this.fechaEliminacion = fechaEliminacion;
        this.horaEliminacion = horaEliminacion;
    }

    public LoteEliminado(ReactivoLote reactivoLote, String causaEliminacion, Date fechaEliminacion, Time horaEliminacion) {
        this.reactivoLote = reactivoLote;
        this.causaEliminacion = causaEliminacion;
        this.fechaEliminacion = fechaEliminacion;
        this.horaEliminacion = horaEliminacion;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getCodigoLoteEliminado() {
        return codigoLoteEliminado;
    }

    public void setCodigoLoteEliminado(int codigoLoteEliminado) {
        this.codigoLoteEliminado = codigoLoteEliminado;
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
