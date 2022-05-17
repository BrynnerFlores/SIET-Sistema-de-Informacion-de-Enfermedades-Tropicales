package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Caracteriztica {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEquipoCaracteriztica;
    private Equipo equipo;
    private String equipoCaracteriztica;
    private String equipoCaracterizticaValor;
    private int equipoCaracterizticaEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public Caracteriztica(int codigoEquipoCaracteriztica, Equipo equipo, String equipoCaracteriztica, String equipoCaracterizticaValor, int equipoCaracterizticaEstado) {
        this.codigoEquipoCaracteriztica = codigoEquipoCaracteriztica;
        this.equipo = equipo;
        this.equipoCaracteriztica = equipoCaracteriztica;
        this.equipoCaracterizticaValor = equipoCaracterizticaValor;
        this.equipoCaracterizticaEstado = equipoCaracterizticaEstado;
    }
    
    public Caracteriztica(Equipo equipo, String equipoCaracteriztica, String equipoCaracterizticaValor, int equipoCaracterizticaEstado) {
        this.equipo = equipo;
        this.equipoCaracteriztica = equipoCaracteriztica;
        this.equipoCaracterizticaValor = equipoCaracterizticaValor;
        this.equipoCaracterizticaEstado = equipoCaracterizticaEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoEquipoCaracteriztica() {
        return codigoEquipoCaracteriztica;
    }

    public void setCodigoEquipoCaracteriztica(int codigoEquipoCaracteriztica) {
        this.codigoEquipoCaracteriztica = codigoEquipoCaracteriztica;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getEquipoCaracteriztica() {
        return equipoCaracteriztica;
    }

    public void setEquipoCaracteriztica(String equipoCaracteriztica) {
        this.equipoCaracteriztica = equipoCaracteriztica;
    }

    public String getEquipoCaracterizticaValor() {
        return equipoCaracterizticaValor;
    }

    public void setEquipoCaracterizticaValor(String equipoCaracterizticaValor) {
        this.equipoCaracterizticaValor = equipoCaracterizticaValor;
    }

    public int getEquipoCaracterizticaEstado() {
        return equipoCaracterizticaEstado;
    }

    public void setEquipoCaracterizticaEstado(int equipoCaracterizticaEstado) {
        this.equipoCaracterizticaEstado = equipoCaracterizticaEstado;
    }
    
    // </editor-fold>
    
}