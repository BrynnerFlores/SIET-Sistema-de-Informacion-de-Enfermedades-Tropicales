package View.Utilitarios.ModelTable.GestionExamenes;

import Model.POJO.Tecnica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerTecnicasAgregadas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "TECNICA", "METODO"};
    private List<Tecnica> tecnicas;

    public void setTecnicas(List<Tecnica> tecnicas) {
        this.tecnicas = tecnicas;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (tecnicas != null) {
            tecnicas.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return tecnicas == null ? 0 : tecnicas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int colunIndex) {
        return columnas[colunIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return tecnicas.get(rowIndex).getTecnicaNombre();

            case 2:
                return tecnicas.get(rowIndex).getTecnicaMetodo();
                
            default:
                return null;
        }
    }

    public Tecnica getTecnica(final int rowIndex) {
        return tecnicas.get(rowIndex);
    }
}