package View.Utilitarios.ModeloItemComboBox;

import Model.POJO.Examen;

/**
 *
 * @author Brynner
 */
public class ItemPosibleResultado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoPosibleResultado;
    private Examen examen;
    private String posibleResultadoNombre;
    private int posibleResultadoEstado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ItemPosibleResultado(int codigoPosibleResultado, Examen examen, String posibleResultadoNombre, int posibleResultadoEstado) {
        this.codigoPosibleResultado = codigoPosibleResultado;
        this.examen = examen;
        this.posibleResultadoNombre = posibleResultadoNombre;
        this.posibleResultadoEstado = posibleResultadoEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public int getCodigoPosibleResultado() {
        return codigoPosibleResultado;
    }

    public Examen getExamen() {
        return examen;
    }

    public String getPosibleResultadoNombre() {
        return posibleResultadoNombre;
    }

    public int getPosibleResultadoEstado() {
        return posibleResultadoEstado;
    }
    
    // </editor-fold>
    
    @Override
    public String toString() {
        return getPosibleResultadoNombre();
    }
}