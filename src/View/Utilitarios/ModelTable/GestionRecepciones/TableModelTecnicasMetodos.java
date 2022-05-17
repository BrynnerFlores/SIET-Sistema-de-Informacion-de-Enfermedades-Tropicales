package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.TecnicaAplicada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelTecnicasMetodos extends AbstractTableModel {

    private final String[] columnas = {"Nº", "TECNICA", "METODO", "SELECCIONAR"};
    private List<TecnicaDisponible> tecnicasDisponibles;

    public TableModelTecnicasMetodos() {
        tecnicasDisponibles = new ArrayList<>();
    }

    public List<TecnicaDisponible> getTecnicasDisponibles() {
        return tecnicasDisponibles;
    }

    public void setTecnicasDisponibles(List<TecnicaDisponible> tecnicasDisponibles) {
        this.tecnicasDisponibles = tecnicasDisponibles;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (tecnicasDisponibles != null) {
            tecnicasDisponibles.clear();
            fireTableDataChanged();
        }
    }

    public List<TecnicaAplicada> obtenerTecnicasAplicadas() {
        final List<TecnicaAplicada> tecnicasAplicadas = new ArrayList<>();
        tecnicasDisponibles.forEach((tecnicaDisponible) -> {
            if (tecnicaDisponible.isSelected()) {
                tecnicasAplicadas.add(tecnicaDisponible.getTecnicaAplicada());
            }
        });
        return tecnicasAplicadas;
    }

    @Override
    public int getRowCount() {
        return tecnicasDisponibles == null ? 0 : tecnicasDisponibles.size();
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
                return tecnicasDisponibles.get(rowIndex).getTecnicaAplicada().getTecnica().getTecnicaNombre();

            case 2:
                return tecnicasDisponibles.get(rowIndex).getTecnicaAplicada().getTecnica().getTecnicaMetodo();

            case 3:
                return tecnicasDisponibles.get(rowIndex).isSelected();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(final Object object, final int rowIndex, final int columnIndex) {
        switch (columnIndex) {
            case 3:
                final boolean isSelected = Boolean.parseBoolean(object.toString());
                if (isSelected) {
                    tecnicasDisponibles.get(rowIndex).setSelected(Boolean.valueOf(object.toString()));
                } else {
                    tecnicasDisponibles.get(rowIndex).setSelected(Boolean.valueOf(object.toString()));
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
            case 3:
                return true;

            default:
                return false;
        }
    }
}