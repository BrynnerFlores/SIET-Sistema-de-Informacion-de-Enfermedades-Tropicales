package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class EquipoEliminado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEquipoEliminado;
    private Equipo equipo;
    private Date fechaEliminacion;
    private Time horaEliminacion;
    private String motivoEliminacion;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public EquipoEliminado(int codigoEquipoEliminado, Equipo equipo, Date fechaEliminacion, Time horaEliminacion, String motivoEliminacion) {
        this.codigoEquipoEliminado = codigoEquipoEliminado;
        this.equipo = equipo;
        this.fechaEliminacion = fechaEliminacion;
        this.horaEliminacion = horaEliminacion;
        this.motivoEliminacion = motivoEliminacion;
    }
    
    public EquipoEliminado(Equipo equipo, Date fechaEliminacion, Time horaEliminacion, String motivoEliminacion) {
        this.equipo = equipo;
        this.fechaEliminacion = fechaEliminacion;
        this.horaEliminacion = horaEliminacion;
        this.motivoEliminacion = motivoEliminacion;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoEquipoEliminado() {
        return codigoEquipoEliminado;
    }

    public void setCodigoEquipoEliminado(int codigoEquipoEliminado) {
        this.codigoEquipoEliminado = codigoEquipoEliminado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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

    public String getMotivoEliminacion() {
        return motivoEliminacion;
    }

    public void setMotivoEliminacion(String motivoEliminacion) {
        this.motivoEliminacion = motivoEliminacion;
    }

    // </editor-fold>
    
}