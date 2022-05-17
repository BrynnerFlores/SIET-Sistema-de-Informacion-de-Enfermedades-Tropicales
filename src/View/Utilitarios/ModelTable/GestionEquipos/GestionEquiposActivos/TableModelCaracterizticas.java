package View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposActivos;

import Model.POJO.Caracteriztica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelCaracterizticas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CARACTERIZTICA", "VALOR"};
    private List<Caracteriztica> caracterizticas;

    public void setCaracterizticas(List<Caracteriztica> caracterizticas) {
        this.caracterizticas = caracterizticas;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (caracterizticas != null) {
            caracterizticas.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return caracterizticas == null ? 0 : caracterizticas.size();
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
        final Caracteriztica caracteriztica = caracterizticas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return caracteriztica.getEquipoCaracteriztica();

            case 2:
                return caracteriztica.getEquipoCaracterizticaValor();

            default:
                return null;
        }
    }

    public Caracteriztica getCaracteriztica(final int rowIndex) {
        return caracterizticas.get(rowIndex);
    }
}
