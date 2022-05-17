package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.ParasitoEncontrado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelParasitosMuestraBiologica extends AbstractTableModel {

    private final String[] columnas = {"Nº", "PARASITO", "OBSERVACION", "SELECCIONAR"};
    private List<ParasitoDisponible> parasitosDisponibles;

    public TableModelParasitosMuestraBiologica() {
        parasitosDisponibles = new ArrayList<>();
    }

    public List<ParasitoDisponible> getParasitosDisponibles() {
        return parasitosDisponibles;
    }

    public void setParasitosDisponibles(List<ParasitoDisponible> parasitosDisponibles) {
        this.parasitosDisponibles = parasitosDisponibles;
    }

    public void limpiarLista() {
        if (parasitosDisponibles != null) {
            parasitosDisponibles.clear();
            fireTableDataChanged();
        }
    }

    public List<ParasitoEncontrado> obtenerParasitosEncontrados() {
        final List<ParasitoEncontrado> parasitosEncontrados = new ArrayList<>();
        parasitosDisponibles.forEach((parasitoDisponible) -> {
            if (parasitoDisponible.isSelected()) {
                parasitosEncontrados.add(parasitoDisponible.getParasitoEncontrado());
            }
        });
        return parasitosEncontrados;
    }

    @Override
    public int getRowCount() {
        return parasitosDisponibles == null ? 0 : parasitosDisponibles.size();
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
        final ParasitoDisponible parasitoDisponible = parasitosDisponibles.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return parasitoDisponible.getParasitoEncontrado().getParasito().getParasitoNombre();

            case 2:
                return parasitoDisponible.getParasitoEncontrado().getParasitoTipoObservacion();

            case 3:
                return parasitoDisponible.isSelected();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(final Object object, final int rowIndex, final int columnIndex) {
        switch (columnIndex) {
            case 2:
                parasitosDisponibles.get(rowIndex).getParasitoEncontrado().setParasitoTipoObservacion(object.toString());
                break;

            case 3:
                final boolean isSelected = Boolean.parseBoolean(object.toString());
                if (isSelected) {
                    parasitosDisponibles.get(rowIndex).setSelected(Boolean.valueOf(object.toString()));
                    parasitosDisponibles.get(rowIndex).getParasitoEncontrado().setParasitoTipoObservacion("MICROSCOPICA");
                } else {
                    parasitosDisponibles.get(rowIndex).setSelected(Boolean.valueOf(object.toString()));
                    parasitosDisponibles.get(rowIndex).getParasitoEncontrado().setParasitoTipoObservacion(null);
                }
                break;
        }
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(final int columnIndex) {
        if (columnIndex == 3) {
            return Boolean.class;
        }
        return Object.class;
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        switch (columnIndex) {
            case 2:
                final boolean isSelected = Boolean.parseBoolean(getValueAt(rowIndex, 3).toString());
                return isSelected;

            case 3:
                return true;

            default:
                return false;
        }
    }
}
