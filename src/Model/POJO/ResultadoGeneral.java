package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */

public class ResultadoGeneral {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoResultadoGeneral;
    private PersonalTecnico personalTecnicoAnalista;
    private PersonalTecnico personalTecnicoResultados;
    private ExamenSolicitado examenSolicitado;
    private AspectoCalidad aspecto;
    private SeguimientoPaciente seguimientoPaciente;
    private ExamenPosibleResultado examenPosibleResultado;
    private Enfermedad enfermedad;
    private String numeroMuestraBiologica;
    private Date fechaTomaMuestra;
    private Date fechaFinal;
    private Time horaFinal;
    private String examenControl;
    private String observaciones;
    private String recomendaciones;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ResultadoGeneral(int codigoResultadoGeneral, PersonalTecnico personalTecnicoAnalista, PersonalTecnico personalTecnicoResultados, ExamenSolicitado examenSolicitado, AspectoCalidad aspecto, SeguimientoPaciente seguimientoPaciente, ExamenPosibleResultado examenPosibleResultado, Enfermedad enfermedad, String numeroMuestraBiologica, Date fechaTomaMuestra, Date fechaFinal, Time horaFinal, String examenControl, String observaciones, String recomendaciones) {
        this.codigoResultadoGeneral = codigoResultadoGeneral;
        this.personalTecnicoAnalista = personalTecnicoAnalista;
        this.personalTecnicoResultados = personalTecnicoResultados;
        this.examenSolicitado = examenSolicitado;
        this.aspecto = aspecto;
        this.seguimientoPaciente = seguimientoPaciente;
        this.examenPosibleResultado = examenPosibleResultado;
        this.enfermedad = enfermedad;
        this.numeroMuestraBiologica = numeroMuestraBiologica;
        this.fechaTomaMuestra = fechaTomaMuestra;
        this.fechaFinal = fechaFinal;
        this.horaFinal = horaFinal;
        this.examenControl = examenControl;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
    }

    public ResultadoGeneral(PersonalTecnico personalTecnicoAnalista, PersonalTecnico personalTecnicoResultados, ExamenSolicitado examenSolicitado, AspectoCalidad aspecto, SeguimientoPaciente seguimientoPaciente, ExamenPosibleResultado examenPosibleResultado, Enfermedad enfermedad, String numeroMuestraBiologica, Date fechaTomaMuestra, Date fechaFinal, Time horaFinal, String examenControl, String observaciones, String recomendaciones) {
        this.personalTecnicoAnalista = personalTecnicoAnalista;
        this.personalTecnicoResultados = personalTecnicoResultados;
        this.examenSolicitado = examenSolicitado;
        this.aspecto = aspecto;
        this.seguimientoPaciente = seguimientoPaciente;
        this.examenPosibleResultado = examenPosibleResultado;
        this.enfermedad = enfermedad;
        this.numeroMuestraBiologica = numeroMuestraBiologica;
        this.fechaTomaMuestra = fechaTomaMuestra;
        this.fechaFinal = fechaFinal;
        this.horaFinal = horaFinal;
        this.examenControl = examenControl;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
    }

    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoResultadoGeneral() {
        return codigoResultadoGeneral;
    }

    public void setCodigoResultadoGeneral(int codigoResultadoGeneral) {
        this.codigoResultadoGeneral = codigoResultadoGeneral;
    }

    public PersonalTecnico getPersonalTecnicoAnalista() {
        return personalTecnicoAnalista;
    }

    public void setPersonalTecnicoAnalista(PersonalTecnico personalTecnicoAnalista) {
        this.personalTecnicoAnalista = personalTecnicoAnalista;
    }

    public PersonalTecnico getPersonalTecnicoResultados() {
        return personalTecnicoResultados;
    }

    public void setPersonalTecnicoResultados(PersonalTecnico personalTecnicoResultados) {
        this.personalTecnicoResultados = personalTecnicoResultados;
    }

    public ExamenSolicitado getExamenSolicitado() {
        return examenSolicitado;
    }

    public void setExamenSolicitado(ExamenSolicitado examenSolicitado) {
        this.examenSolicitado = examenSolicitado;
    }

    public AspectoCalidad getAspecto() {
        return aspecto;
    }

    public void setAspecto(AspectoCalidad aspecto) {
        this.aspecto = aspecto;
    }

    public SeguimientoPaciente getSeguimientoPaciente() {
        return seguimientoPaciente;
    }

    public void setSeguimientoPaciente(SeguimientoPaciente seguimientoPaciente) {
        this.seguimientoPaciente = seguimientoPaciente;
    }

    public ExamenPosibleResultado getExamenPosibleResultado() {
        return examenPosibleResultado;
    }

    public void setExamenPosibleResultado(ExamenPosibleResultado examenPosibleResultado) {
        this.examenPosibleResultado = examenPosibleResultado;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getNumeroMuestraBiologica() {
        return numeroMuestraBiologica;
    }

    public void setNumeroMuestraBiologica(String numeroMuestraBiologica) {
        this.numeroMuestraBiologica = numeroMuestraBiologica;
    }

    public Date getFechaTomaMuestra() {
        return fechaTomaMuestra;
    }

    public void setFechaTomaMuestra(Date fechaTomaMuestra) {
        this.fechaTomaMuestra = fechaTomaMuestra;
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

    public String getExamenControl() {
        return examenControl;
    }

    public void setExamenControl(String examenControl) {
        this.examenControl = examenControl;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }
    
    public void setRecomendaciones(String recomendaciones) {    
        this.recomendaciones = recomendaciones;
    }
    
    // </editor-fold>
    
}