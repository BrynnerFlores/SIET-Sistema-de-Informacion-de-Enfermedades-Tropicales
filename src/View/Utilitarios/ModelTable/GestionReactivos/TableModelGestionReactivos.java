package View.Utilitarios.ModelTable.GestionReactivos;

import Model.POJOPersonalizado.ReactivoPersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionReactivos extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "REACTIVO", "# LOTES DISPONIBLES"};
    private List<ReactivoPersonalizado> reactivosPersonalizados;

    public void setReactivosPersonalizados(List<ReactivoPersonalizado> reactivosPersonalizados) {
        this.reactivosPersonalizados = reactivosPersonalizados;
        fireTableDataChanged();
    }

    public List<ReactivoPersonalizado> getReactivosPersonalizados() {
        return reactivosPersonalizados;
    }
    
    public void limpiarLista() {
        if (reactivosPersonalizados != null) {
            reactivosPersonalizados.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return reactivosPersonalizados == null ? 0 : reactivosPersonalizados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        final ReactivoPersonalizado reactivoPersonalizado = reactivosPersonalizados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return reactivoPersonalizado.getReactivo().getCodigoReactivo();

            case 2:
                return reactivoPersonalizado.getReactivo().getNombre();
                
            case 3:
                return reactivoPersonalizado.getSaldo();
                
            default:
                return null;
        }
    }

    public ReactivoPersonalizado getReactivoPersonalizado(final int rowIndex) {
        return reactivosPersonalizados.get(rowIndex);
    }
}