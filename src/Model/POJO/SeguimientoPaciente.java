package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class SeguimientoPaciente {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoSeguimientoPaciente;
    private Paciente paciente;
    private Examen examen;
    private ExamenSolicitado examenSolicitado;
    private Date fechaInicio;
    private Time horaInicio;
    private Date fechaFinal;
    private Time horaFinal;
    private String progreso;
    private String detallesObservacionesInicio;
    private String detallesObservacionesFinal;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SeguimientoPaciente(int codigoSeguimientoPaciente, Paciente paciente, Examen examen, ExamenSolicitado examenSolicitado, Date fechaInicio, Time horaInicio, Date fechaFinal, Time horaFinal, String progreso, String detallesObservacionesInicio, String detallesObservacionesFinal) {
        this.codigoSeguimientoPaciente = codigoSeguimientoPaciente;
        this.paciente = paciente;
        this.examen = examen;
        this.examenSolicitado = examenSolicitado;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFinal = fechaFinal;
        this.horaFinal = horaFinal;
        this.progreso = progreso;
        this.detallesObservacionesInicio = detallesObservacionesInicio;
        this.detallesObservacionesFinal = detallesObservacionesFinal;
    }

    public SeguimientoPaciente(int codigoSeguimientoPaciente, Paciente paciente, Examen examen, ExamenSolicitado examenSolicitado, Date fechaInicio, Time horaInicio, String progreso, String detallesObservacionesInicio) {
        this.codigoSeguimientoPaciente = codigoSeguimientoPaciente;
        this.paciente = paciente;
        this.examen = examen;
        this.examenSolicitado = examenSolicitado;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.progreso = progreso;
        this.detallesObservacionesInicio = detallesObservacionesInicio;
    }
    
    public SeguimientoPaciente(Paciente paciente, Examen examen, ExamenSolicitado examenSolicitado, Date fechaInicio, Time horaInicio, String progreso, String detallesObservacionesInicio) {
        this.paciente = paciente;
        this.examen = examen;
        this.examenSolicitado = examenSolicitado;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.progreso = progreso;
        this.detallesObservacionesInicio = detallesObservacionesInicio;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoSeguimientoPaciente() {
        return codigoSeguimientoPaciente;
    }

    public void setCodigoSeguimientoPaciente(int codigoSeguimientoPaciente) {
        this.codigoSeguimientoPaciente = codigoSeguimientoPaciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public ExamenSolicitado getExamenSolicitado() {
        return examenSolicitado;
    }

    public void setExamenSolicitado(ExamenSolicitado examenSolicitado) {
        this.examenSolicitado = examenSolicitado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public String getDetallesObservacionesInicio() {
        return detallesObservacionesInicio;
    }

    public void setDetallesObservacionesInicio(String detallesObservacionesInicio) {
        this.detallesObservacionesInicio = detallesObservacionesInicio;
    }

    public String getDetallesObservacionesFinal() {
        return detallesObservacionesFinal;
    }
    
    public void setDetallesObservacionesFinal(String detallesObservacionesFinal) {    
        this.detallesObservacionesFinal = detallesObservacionesFinal;
    }
    // </editor-fold>
    
}