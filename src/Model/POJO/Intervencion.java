package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class Intervencion {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoIntervencion;
    private Equipo equipo;
    private Date intervencionFechaInicio;
    private Time intervencionHoraInicio;
    private Date intervencionFechaFinal;
    private Time intervencionHoraFinal;
    private String intervencionCausa;
    private String intervencionTrabajoRealizado;
    private String intervencionDescripcionActividad;
    private String intervencionObservaciones;
    private int intervencionEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Intervencion(int codigoIntervencion, Equipo equipo, Date intervencionFechaInicio, Time intervencionHoraInicio, Date intervencionFechaFinal, Time intervencionHoraFinal, String intervencionCausa, String intervencionTrabajoRealizado, String intervencionDescripcionActividad, String intervencionObservaciones, int intervencionEstado) {
        this.codigoIntervencion = codigoIntervencion;
        this.equipo = equipo;
        this.intervencionFechaInicio = intervencionFechaInicio;
        this.intervencionHoraInicio = intervencionHoraInicio;
        this.intervencionFechaFinal = intervencionFechaFinal;
        this.intervencionHoraFinal = intervencionHoraFinal;
        this.intervencionCausa = intervencionCausa;
        this.intervencionTrabajoRealizado = intervencionTrabajoRealizado;
        this.intervencionDescripcionActividad = intervencionDescripcionActividad;
        this.intervencionObservaciones = intervencionObservaciones;
        this.intervencionEstado = intervencionEstado;
    }
    
    public Intervencion(Equipo equipo, Date intervencionFechaInicio, Time intervencionHoraInicio, Date intervencionFechaFinal, Time intervencionHoraFinal, String intervencionCausa, String intervencionTrabajoRealizado, String intervencionDescripcionActividad, String intervencionObservaciones, int intervencionEstado) {
        this.equipo = equipo;
        this.intervencionFechaInicio = intervencionFechaInicio;
        this.intervencionHoraInicio = intervencionHoraInicio;
        this.intervencionFechaFinal = intervencionFechaFinal;
        this.intervencionHoraFinal = intervencionHoraFinal;
        this.intervencionCausa = intervencionCausa;
        this.intervencionTrabajoRealizado = intervencionTrabajoRealizado;
        this.intervencionDescripcionActividad = intervencionDescripcionActividad;
        this.intervencionObservaciones = intervencionObservaciones;
        this.intervencionEstado = intervencionEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoIntervencion() {
        return codigoIntervencion;
    }

    public void setCodigoIntervencion(int codigoIntervencion) {
        this.codigoIntervencion = codigoIntervencion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Date getIntervencionFechaInicio() {
        return intervencionFechaInicio;
    }

    public void setIntervencionFechaInicio(Date intervencionFechaInicio) {
        this.intervencionFechaInicio = intervencionFechaInicio;
    }

    public Time getIntervencionHoraInicio() {
        return intervencionHoraInicio;
    }

    public void setIntervencionHoraInicio(Time intervencionHoraInicio) {
        this.intervencionHoraInicio = intervencionHoraInicio;
    }

    public Date getIntervencionFechaFinal() {
        return intervencionFechaFinal;
    }

    public void setIntervencionFechaFinal(Date intervencionFechaFinal) {
        this.intervencionFechaFinal = intervencionFechaFinal;
    }

    public Time getIntervencionHoraFinal() {
        return intervencionHoraFinal;
    }

    public void setIntervencionHoraFinal(Time intervencionHoraFinal) {
        this.intervencionHoraFinal = intervencionHoraFinal;
    }

    public String getIntervencionCausa() {
        return intervencionCausa;
    }

    public void setIntervencionCausa(String intervencionCausa) {
        this.intervencionCausa = intervencionCausa;
    }

    public String getIntervencionTrabajoRealizado() {
        return intervencionTrabajoRealizado;
    }

    public void setIntervencionTrabajoRealizado(String intervencionTrabajoRealizado) {
        this.intervencionTrabajoRealizado = intervencionTrabajoRealizado;
    }

    public String getIntervencionDescripcionActividad() {
        return intervencionDescripcionActividad;
    }

    public void setIntervencionDescripcionActividad(String intervencionDescripcionActividad) {
        this.intervencionDescripcionActividad = intervencionDescripcionActividad;
    }

    public String getIntervencionObservaciones() {
        return intervencionObservaciones;
    }

    public void setIntervencionObservaciones(String intervencionObservaciones) {
        this.intervencionObservaciones = intervencionObservaciones;
    }

    public int getIntervencionEstado() {
        return intervencionEstado;
    }

    public void setIntervencionEstado(int intervencionEstado) {
        this.intervencionEstado = intervencionEstado;
    }
    
    // </editor-fold>

}