package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class Recepcion {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoRecepcion;
    private PersonalTecnico personalTecnico;
    private Paciente paciente;
    private Establecimiento establecimiento;
    private String codigoRegistroLaboratorio;
    private int edadPacienteYears;
    private int edadPacienteMeses;
    private int edadPacienteDias;
    private boolean mujerEmbarazada;
    private boolean mujerParto;
    private boolean mujerPostParto;
    private int numeroDiasSintomas;
    private Date fechaProcesamiento;
    private String solicitante;
    private Date fechaRecepcion;
    private Time horaRecepcion;
    private int estado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public Recepcion(int codigoRecepcion, PersonalTecnico personalTecnico, Paciente paciente, Establecimiento establecimiento, String codigoRegistroLaboratorio, int edadPacienteYears, int edadPacienteMeses, int edadPacienteDias, boolean mujerEmbarazada, boolean mujerParto, boolean mujerPostParto, int numeroDiasSintomas, Date fechaProcesamiento, String solicitante, Date fechaRecepcion, Time horaRecepcion, int estado) {
        this.codigoRecepcion = codigoRecepcion;
        this.personalTecnico = personalTecnico;
        this.paciente = paciente;
        this.establecimiento = establecimiento;
        this.codigoRegistroLaboratorio = codigoRegistroLaboratorio;
        this.edadPacienteYears = edadPacienteYears;
        this.edadPacienteMeses = edadPacienteMeses;
        this.edadPacienteDias = edadPacienteDias;
        this.mujerEmbarazada = mujerEmbarazada;
        this.mujerParto = mujerParto;
        this.mujerPostParto = mujerPostParto;
        this.numeroDiasSintomas = numeroDiasSintomas;
        this.fechaProcesamiento = fechaProcesamiento;
        this.solicitante = solicitante;
        this.fechaRecepcion = fechaRecepcion;
        this.horaRecepcion = horaRecepcion;
        this.estado = estado;
    }

    public Recepcion(PersonalTecnico personalTecnico, Paciente paciente, Establecimiento establecimiento, String codigoRegistroLaboratorio, int edadPacienteYears, int edadPacienteMeses, int edadPacienteDias, boolean mujerEmbarazada, boolean mujerParto, boolean mujerPostParto, int numeroDiasSintomas, Date fechaProcesamiento, String solicitante, Date fechaRecepcion, Time horaRecepcion, int estado) {
        this.personalTecnico = personalTecnico;
        this.paciente = paciente;
        this.establecimiento = establecimiento;
        this.codigoRegistroLaboratorio = codigoRegistroLaboratorio;
        this.edadPacienteYears = edadPacienteYears;
        this.edadPacienteMeses = edadPacienteMeses;
        this.edadPacienteDias = edadPacienteDias;
        this.mujerEmbarazada = mujerEmbarazada;
        this.mujerParto = mujerParto;
        this.mujerPostParto = mujerPostParto;
        this.numeroDiasSintomas = numeroDiasSintomas;
        this.fechaProcesamiento = fechaProcesamiento;
        this.solicitante = solicitante;
        this.fechaRecepcion = fechaRecepcion;
        this.horaRecepcion = horaRecepcion;
        this.estado = estado;
    }
    
    

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getCodigoRecepcion() {
        return codigoRecepcion;
    }

    public void setCodigoRecepcion(int codigoRecepcion) {
        this.codigoRecepcion = codigoRecepcion;
    }

    public PersonalTecnico getPersonalTecnico() {
        return personalTecnico;
    }

    public void setPersonalTecnico(PersonalTecnico personalTecnico) {
        this.personalTecnico = personalTecnico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getCodigoRegistroLaboratorio() {
        return codigoRegistroLaboratorio;
    }

    public void setCodigoRegistroLaboratorio(String numeroRegistroLaboratorio) {
        this.codigoRegistroLaboratorio = codigoRegistroLaboratorio;
    }

    public int getEdadPacienteYears() {
        return edadPacienteYears;
    }

    public void setEdadPacienteYears(int edadPacienteYears) {
        this.edadPacienteYears = edadPacienteYears;
    }

    public int getEdadPacienteMeses() {
        return edadPacienteMeses;
    }

    public void setEdadPacienteMeses(int edadPacienteMeses) {
        this.edadPacienteMeses = edadPacienteMeses;
    }

    public int getEdadPacienteDias() {
        return edadPacienteDias;
    }

    public void setEdadPacienteDias(int edadPacienteDias) {
        this.edadPacienteDias = edadPacienteDias;
    }

    public boolean isMujerEmbarazada() {
        return mujerEmbarazada;
    }

    public void setMujerEmbarazada(boolean mujerEmbarazada) {
        this.mujerEmbarazada = mujerEmbarazada;
    }

    public boolean isMujerParto() {
        return mujerParto;
    }

    public void setMujerParto(boolean mujerParto) {
        this.mujerParto = mujerParto;
    }

    public boolean isMujerPostParto() {
        return mujerPostParto;
    }

    public void setMujerPostParto(boolean mujerPostParto) {
        this.mujerPostParto = mujerPostParto;
    }

    public int getNumeroDiasSintomas() {
        return numeroDiasSintomas;
    }

    public void setNumeroDiasSintomas(int numeroDiasSintomas) {
        this.numeroDiasSintomas = numeroDiasSintomas;
    }

    public Date getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(Date fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Time getHoraRecepcion() {
        return horaRecepcion;
    }

    public void setHoraRecepcion(Time horaRecepcion) {
        this.horaRecepcion = horaRecepcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    // </editor-fold>
    
}