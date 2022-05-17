package Model.POJO;

import java.sql.Date;

/**
 *
 * @author Brynner
 */
public class Equipo {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEquipo;
    private PersonalTecnico personalTecnico;
    private Subespecialidad subespecialidad;
    private String equipoNombre;
    private String equipoMarca;
    private String equipoModelo;
    private String equipoNumeroSerie;
    private Date equipoFechaAdquisicion;
    private String equipoProveedor;
    private String equipoResponsableEntrega;
    private String equipoIntegridad;
    private int equipoGarantia;
    private String equipoUbicacion;
    private String equipoObservaciones;
    private byte[] equipoFoto;
    private int equipoEstado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Equipo(int codigoEquipo, PersonalTecnico personalTecnico, Subespecialidad subespecialidad, String equipoNombre, String equipoMarca, String equipoModelo, String equipoNumeroSerie, Date equipoFechaAdquisicion, String equipoProveedor, String equipoResponsableEntrega, String equipoIntegridad, int equipoGarantia, String equipoUbicacion, String equipoObservaciones, byte[] equipoFoto, int equipoEstado) {
        this.codigoEquipo = codigoEquipo;
        this.personalTecnico = personalTecnico;
        this.subespecialidad = subespecialidad;
        this.equipoNombre = equipoNombre;
        this.equipoMarca = equipoMarca;
        this.equipoModelo = equipoModelo;
        this.equipoNumeroSerie = equipoNumeroSerie;
        this.equipoFechaAdquisicion = equipoFechaAdquisicion;
        this.equipoProveedor = equipoProveedor;
        this.equipoResponsableEntrega = equipoResponsableEntrega;
        this.equipoIntegridad = equipoIntegridad;
        this.equipoGarantia = equipoGarantia;
        this.equipoUbicacion = equipoUbicacion;
        this.equipoObservaciones = equipoObservaciones;
        this.equipoFoto = equipoFoto;
        this.equipoEstado = equipoEstado;
    }
    
    public Equipo(PersonalTecnico personalTecnico, Subespecialidad subespecialidad, String equipoNombre, String equipoMarca, String equipoModelo, String equipoNumeroSerie, Date equipoFechaAdquisicion, String equipoProveedor, String equipoResponsableEntrega, String equipoIntegridad, int equipoGarantia, String equipoUbicacion, String equipoObservaciones, byte[] equipoFoto, int equipoEstado) {
        this.personalTecnico = personalTecnico;
        this.subespecialidad = subespecialidad;
        this.equipoNombre = equipoNombre;
        this.equipoMarca = equipoMarca;
        this.equipoModelo = equipoModelo;
        this.equipoNumeroSerie = equipoNumeroSerie;
        this.equipoFechaAdquisicion = equipoFechaAdquisicion;
        this.equipoProveedor = equipoProveedor;
        this.equipoResponsableEntrega = equipoResponsableEntrega;
        this.equipoIntegridad = equipoIntegridad;
        this.equipoGarantia = equipoGarantia;
        this.equipoUbicacion = equipoUbicacion;
        this.equipoObservaciones = equipoObservaciones;
        this.equipoFoto = equipoFoto;
        this.equipoEstado = equipoEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public PersonalTecnico getPersonalTecnico() {
        return personalTecnico;
    }

    public void setBioquimico(PersonalTecnico personalTecnico) {
        this.personalTecnico = personalTecnico;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }

    public String getEquipoNombre() {
        return equipoNombre;
    }

    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    public String getEquipoMarca() {
        return equipoMarca;
    }

    public void setEquipoMarca(String equipoMarca) {
        this.equipoMarca = equipoMarca;
    }

    public String getEquipoModelo() {
        return equipoModelo;
    }

    public void setEquipoModelo(String equipoModelo) {
        this.equipoModelo = equipoModelo;
    }

    public String getEquipoNumeroSerie() {
        return equipoNumeroSerie;
    }

    public void setEquipoNumeroSerie(String equipoNumeroSerie) {
        this.equipoNumeroSerie = equipoNumeroSerie;
    }

    public Date getEquipoFechaAdquisicion() {
        return equipoFechaAdquisicion;
    }

    public void setEquipoFechaAdquisicion(Date equipoFechaAdquisicion) {
        this.equipoFechaAdquisicion = equipoFechaAdquisicion;
    }

    public String getEquipoProveedor() {
        return equipoProveedor;
    }

    public void setEquipoProveedor(String equipoProveedor) {
        this.equipoProveedor = equipoProveedor;
    }

    public String getEquipoResponsableEntrega() {
        return equipoResponsableEntrega;
    }

    public void setEquipoResponsableEntrega(String equipoResponsableEntrega) {
        this.equipoResponsableEntrega = equipoResponsableEntrega;
    }

    public String getEquipoIntegridad() {
        return equipoIntegridad;
    }

    public void setEquipoIntegridad(String equipoIntegridad) {
        this.equipoIntegridad = equipoIntegridad;
    }

    public int getEquipoGarantia() {
        return equipoGarantia;
    }

    public void setEquipoGarantia(int equipoGarantia) {
        this.equipoGarantia = equipoGarantia;
    }

    public String getEquipoUbicacion() {
        return equipoUbicacion;
    }

    public void setEquipoUbicacion(String equipoUbicacion) {
        this.equipoUbicacion = equipoUbicacion;
    }

    public String getEquipoObservaciones() {
        return equipoObservaciones;
    }

    public void setEquipoObservaciones(String equipoObservaciones) {
        this.equipoObservaciones = equipoObservaciones;
    }

    public byte[] getEquipoFoto() {
        return equipoFoto;
    }

    public void setEquipoFoto(byte[] equipoFoto) {
        this.equipoFoto = equipoFoto;
    }

    public int getEquipoEstado() {
        return equipoEstado;
    }
    
    public void setEquipoEstado(int equipoEstado) {    
        this.equipoEstado = equipoEstado;
    }
    
    // </editor-fold>
    
}