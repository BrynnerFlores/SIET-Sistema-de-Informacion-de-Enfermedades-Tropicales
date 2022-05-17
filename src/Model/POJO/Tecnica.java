package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Tecnica {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoTecnica;
    private Examen examen;
    private String tecnicaNombre;
    private String tecnicaMetodo;
    private int tecnicaEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Tecnica(int codigoTecnica, Examen examen, String tecnicaNombre, String tecnicaMetodo, int tecnicaEstado) {
        this.codigoTecnica = codigoTecnica;
        this.examen = examen;
        this.tecnicaNombre = tecnicaNombre;
        this.tecnicaMetodo = tecnicaMetodo;
        this.tecnicaEstado = tecnicaEstado;
    }

    public Tecnica(Examen examen, String tecnicaNombre, String tecnicaMetodo, int tecnicaEstado) {
        this.examen = examen;
        this.tecnicaNombre = tecnicaNombre;
        this.tecnicaMetodo = tecnicaMetodo;
        this.tecnicaEstado = tecnicaEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoTecnica() {
        return codigoTecnica;
    }

    public void setCodigoTecnica(int codigoTecnica) {
        this.codigoTecnica = codigoTecnica;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public String getTecnicaNombre() {
        return tecnicaNombre;
    }

    public void setTecnicaNombre(String tecnicaNombre) {
        this.tecnicaNombre = tecnicaNombre;
    }

    public String getTecnicaMetodo() {
        return tecnicaMetodo;
    }

    public void setTecnicaMetodo(String tecnicaMetodo) {
        this.tecnicaMetodo = tecnicaMetodo;
    }

    public int getTecnicaEstado() {
        return tecnicaEstado;
    }

    public void setTecnicaEstado(int tecnicaEstado) {
        this.tecnicaEstado = tecnicaEstado;
    }

    // </editor-fold>
    
}