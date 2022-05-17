package View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposIntervencion;

import Model.POJO.Intervencion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionEquiposIntervencion extends AbstractTableModel {
    
    private final String[] columnas = {"Nº", "CODIGO INTERVENCION", "FECHA INICIO", "HORA INICIO", "CAUSA", "TRABAJO REALIZADO", "EQUIPO", "NUMERO DE SERIE", "UBICACION"};
    private List<Intervencion> intervenciones;

    public void setIntervenciones(List<Intervencion> intervenciones) {
        this.intervenciones = intervenciones;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (intervenciones != null) {
            intervenciones.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return intervenciones == null ? 0 : intervenciones.size();
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
        final Intervencion intervencion = intervenciones.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return intervencion.getCodigoIntervencion();
                
            case 2:
                return intervencion.getIntervencionFechaInicio();
                
            case 3:
                return intervencion.getIntervencionHoraInicio();
                
            case 4:
                return intervencion.getIntervencionCausa();
                
            case 5:
                return intervencion.getIntervencionTrabajoRealizado();
                
            case 6:
                return intervencion.getEquipo().getEquipoNombre();
                
            case 7:
                return intervencion.getEquipo().getEquipoNumeroSerie();
                
            case 8:
                return intervencion.getEquipo().getSubespecialidad().getSubespecialidadNombre();
                
                default:
                    return null;
        }
    }
    
    public Intervencion getIntervencion(final int rowIndex) {
        return intervenciones.get(rowIndex);
    }
}