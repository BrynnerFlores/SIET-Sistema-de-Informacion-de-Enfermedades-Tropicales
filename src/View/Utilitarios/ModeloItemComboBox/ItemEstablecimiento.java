package View.Utilitarios.ModeloItemComboBox;

/**
 *
 * @author Brynner
 */
public class ItemEstablecimiento {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEstablecimiento;
    private String establecimientoNombre;
    private String establecimientoTipo;
    private String establecimientoArea;
    private int establecimientoEstado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ItemEstablecimiento(int codigoEstablecimiento, String establecimientoNombre, String establecimientoTipo, String establecimientoArea, int establecimientoEstado) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.establecimientoNombre = establecimientoNombre;
        this.establecimientoTipo = establecimientoTipo;
        this.establecimientoArea = establecimientoArea;
        this.establecimientoEstado = establecimientoEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public int getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public String getEstablecimientoNombre() {
        return establecimientoNombre;
    }

    public String getEstablecimientoTipo() {
        return establecimientoTipo;
    }

    public String getEstablecimientoArea() {
        return establecimientoArea;
    }

    public int getEstablecimientoEstado() {
        return establecimientoEstado;
    }

    // </editor-fold>
    
    @Override
    public String toString() {
        return getEstablecimientoNombre();
    }
}