package View.Utilitarios.ModelTable.GestionSubespecialidades;

import Model.POJO.MuestraBiologica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelAsignarMuestrasBiologicas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "MUESTRA BIOLOGICA"};
    private List<MuestraBiologica> muestrasBiologicas;

    public void setMuestrasBiologicas(List<MuestraBiologica> muestrasBiologicas) {
        this.muestrasBiologicas = muestrasBiologicas;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (muestrasBiologicas != null) {
            muestrasBiologicas.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return muestrasBiologicas == null ? 0 : muestrasBiologicas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final MuestraBiologica muestraBiologica = muestrasBiologicas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return muestraBiologica.getMuestraBiologicaTipo();

            default:
                return null;
        }
    }

    public MuestraBiologica getMuestraBiologica(final int rowIndex) {
        return muestrasBiologicas.get(rowIndex);
    }
}
