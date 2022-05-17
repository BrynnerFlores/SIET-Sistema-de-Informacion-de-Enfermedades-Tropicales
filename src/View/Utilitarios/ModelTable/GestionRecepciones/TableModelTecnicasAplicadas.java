package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.TecnicaAplicada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelTecnicasAplicadas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "TECNICA", "METODO"};
    private List<TecnicaAplicada> tecnicasAplicadas;

    public TableModelTecnicasAplicadas() {
        tecnicasAplicadas = new ArrayList<>();
    }

    public List<TecnicaAplicada> getTecnicasAplicadas() {
        return tecnicasAplicadas;
    }

    public void setTecnicasAplicadas(List<TecnicaAplicada> tecnicasAplicadas) {
        this.tecnicasAplicadas = tecnicasAplicadas;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (tecnicasAplicadas != null) {
            tecnicasAplicadas.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return tecnicasAplicadas == null ? 0 : tecnicasAplicadas.size();
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
                return tecnicasAplicadas.get(rowIndex).getTecnica().getTecnicaNombre();

            case 2:
                return tecnicasAplicadas.get(rowIndex).getTecnica().getTecnicaMetodo();
                
            default:
                return null;
        }
    }
}