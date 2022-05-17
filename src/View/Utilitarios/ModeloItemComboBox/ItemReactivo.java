package View.Utilitarios.ModeloItemComboBox;

/**
 *
 * @author Brynner
 */
public class ItemReactivo {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoReactivo;
    private String nombre;
    private int estado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ItemReactivo(int codigoReactivo, String nombre, int estado) {
        this.codigoReactivo = codigoReactivo;
        this.nombre = nombre;
        this.estado = estado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public int getCodigoReactivo() {
        return codigoReactivo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }
    
    // </editor-fold>
    
    @Override
    public String toString() {
        return getNombre();
    }
}