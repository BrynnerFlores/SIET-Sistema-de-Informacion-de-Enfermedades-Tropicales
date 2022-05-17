package View.Utilitarios.ModelTable.GestionSubespecialidades;

import Model.POJO.Enfermedad;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerEnfermedadesAgregadas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "ENFERMEDAD"};
    private List<Enfermedad> enfermedades;

    public void setEnfermedades(List<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public void limpiarLista() {
        if (enfermedades != null) {
            enfermedades.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return enfermedades == null ? 0 : enfermedades.size();
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
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return enfermedades.get(rowIndex).getEnfermedadNombre();

            default:
                return null;
        }
    }

    public Enfermedad getEnfermedad(final int rowIndex) {
        return enfermedades.get(rowIndex);
    }
}
