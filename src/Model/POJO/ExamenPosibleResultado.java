package Model.POJO;

/**
 *
 * @author Brynner
 */
public class ExamenPosibleResultado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoPosibleResultado;
    private Examen examen;
    private String posibleResultadoNombre;
    private int posibleResultadoEstado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ExamenPosibleResultado(int codigoPosibleResultado, Examen examen, String posibleResultadoNombre, int posibleResultadoEstado) {
        this.codigoPosibleResultado = codigoPosibleResultado;
        this.examen = examen;
        this.posibleResultadoNombre = posibleResultadoNombre;
        this.posibleResultadoEstado = posibleResultadoEstado;
    }

    public ExamenPosibleResultado(Examen examen, String posibleResultadoNombre, int posibleResultadoEstado) {
        this.examen = examen;
        this.posibleResultadoNombre = posibleResultadoNombre;
        this.posibleResultadoEstado = posibleResultadoEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoPosibleResultado() {
        return codigoPosibleResultado;
    }

    public void setCodigoPosibleResultado(int codigoPosibleResultado) {
        this.codigoPosibleResultado = codigoPosibleResultado;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public String getPosibleResultadoNombre() {
        return posibleResultadoNombre;
    }

    public void setPosibleResultadoNombre(String posibleResultadoNombre) {
        this.posibleResultadoNombre = posibleResultadoNombre;
    }

    public int getPosibleResultadoEstado() {
        return posibleResultadoEstado;
    }
    
    public void setPosibleResultadoEstado(int posibleResultadoEstado) {    
        this.posibleResultadoEstado = posibleResultadoEstado;
    }
    
    // </editor-fold>
    
}