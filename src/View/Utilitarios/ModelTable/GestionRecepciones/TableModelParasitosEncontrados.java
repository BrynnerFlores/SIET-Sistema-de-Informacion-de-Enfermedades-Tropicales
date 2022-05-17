package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.ParasitoEncontrado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelParasitosEncontrados extends AbstractTableModel {

    private final String[] columnas = {"Nº", "PARASITO", "OBSERVACION"};
    private List<ParasitoEncontrado> parasitosEncontrados;

    public TableModelParasitosEncontrados() {
        parasitosEncontrados = new ArrayList<>();
    }

    public List<ParasitoEncontrado> getParasitosEncontrados() {
        return parasitosEncontrados;
    }

    public void setParasitosEncontrados(List<ParasitoEncontrado> parasitosEncontrados) {
        this.parasitosEncontrados = parasitosEncontrados;
    }

    public void limpiarLista() {
        parasitosEncontrados.clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return parasitosEncontrados == null ? 0 : parasitosEncontrados.size();
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
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return parasitosEncontrados.get(rowIndex).getParasito().getParasitoNombre();

            case 2:
                return parasitosEncontrados.get(rowIndex).getParasitoTipoObservacion();
                
            default:
                return null;
        }
    }
}