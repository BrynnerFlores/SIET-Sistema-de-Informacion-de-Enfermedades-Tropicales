package View.Utilitarios.ModeloItemComboBox;

/**
 *
 * @author Brynner
 */
public class ItemAspectoCalidad {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoAspectoCalidad;
    private String aspectoCalidad;
    private int aspectoCalidadEstado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ItemAspectoCalidad(int codigoAspectoCalidad, String aspectoCalidad, int aspectoCalidadEstado) {
        this.codigoAspectoCalidad = codigoAspectoCalidad;
        this.aspectoCalidad = aspectoCalidad;
        this.aspectoCalidadEstado = aspectoCalidadEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public int getCodigoAspectoCalidad() {
        return codigoAspectoCalidad;
    }

    public String getAspectoCalidad() {
        return aspectoCalidad;
    }

    public int getAspectoCalidadEstado() {
        return aspectoCalidadEstado;
    }
    
    // </editor-fold>
    
    @Override
    public String toString() {
        return getAspectoCalidad();
    }
}