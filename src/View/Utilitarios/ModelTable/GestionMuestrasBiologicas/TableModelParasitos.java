package View.Utilitarios.ModelTable.GestionMuestrasBiologicas;

import Model.POJO.Parasito;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelParasitos extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "PARASITO"};
    private List<Parasito> parasitos;

    public void setParasitos(List<Parasito> parasitos) {
        this.parasitos = parasitos;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (parasitos != null) {
            parasitos.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return parasitos == null ? 0 : parasitos.size();
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
        final Parasito parasito = parasitos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return parasito.getCodigoParasito();

            case 2:
                return parasito.getParasitoNombre();
                
            default:
                return null;
        }
    }
    
    public Parasito getParasito(final int rowIndex) {
        return parasitos.get(rowIndex);
    }
}