package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.Examen;
import Model.POJO.ExamenSolicitado;
import Model.POJO.MuestraBiologica;
import Model.POJOPersonalizado.ExamenPersonalizado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelRegistrarModificarRecepcion extends AbstractTableModel {

    private final String[] columnas = {"Nº", "EXAMEN", "MUESTRA BIOLOGICA", "# MUESTRAS BIOLOGICAS", "ESTADO MUESTRA", "SELECCIONAR"};

    private final List<ExamenSeleccionado> examenesSeleccionados;
    private final List<ExamenDisponible> examenesDisponibles;
    
    private List<ExamenPersonalizado> examenesPersonalizados;
    private List<ExamenSolicitado> examenesSolicitados;

    public TableModelRegistrarModificarRecepcion() {
        examenesSeleccionados = new ArrayList<>();
        examenesDisponibles = new ArrayList<>();
        examenesSolicitados = new ArrayList<>();
    }

    public void setExamenesPersonalizados(final List<ExamenPersonalizado> examenesPersonalizados) {
        this.examenesPersonalizados = examenesPersonalizados;
        examenesPersonalizados.forEach((examenPersonalizado) -> {
            final Examen examen = examenPersonalizado.getExamen();
            examenesDisponibles.add(new ExamenDisponible(examen, null, null, -1, false));
        });
    }
    
    public List<ExamenSeleccionado> getExamenesSeleccionados() {
        return examenesSeleccionados;
    }

    public void setExamenSeleccionado(final ExamenSeleccionado examenSeleccionado) {
        examenesSeleccionados.add(examenSeleccionado);
    }

    public void setExamenesSolicitados(List<ExamenSolicitado> examenesSolicitados) {
        this.examenesSolicitados = examenesSolicitados;
        //System.out.println("Examenes solicitados en el modelo de la tabla: " + examenesSolicitados.size());
    }

    public List<ExamenSolicitado> getExamenesSolicitados() {
        return examenesSolicitados;
    }
    
    public MuestraBiologica getMuestraBiologica(final Examen examen) {
        for (final ExamenSeleccionado examenSeleccionado : examenesSeleccionados) {
            if (examenSeleccionado.getExamen().getCodigoExamen() == examen.getCodigoExamen()) {
                return examenSeleccionado.getMuestraBiologica();
            }
        }
        return null;
    }

    public List<Examen> getExamenes() {
        final List<Examen> examenes = new ArrayList<>();
        
        examenesPersonalizados.forEach((examenPersonalizado) -> {
            examenes.add(examenPersonalizado.getExamen());
        });
        
        return examenes;
    }
    
    public void updateMuestraBiologica(final Examen examen, final MuestraBiologica muestraBiologica) {
        for (final ExamenSeleccionado examenSeleccionado : examenesSeleccionados) {
            if (examenSeleccionado.getExamen().getCodigoExamen() == examen.getCodigoExamen()) {
                examenSeleccionado.setMuestraBiologica(muestraBiologica);
                break;
            }
        }
    }
    
    public void updateEstadoMuestraBiologica(final Examen examen, final String estadoMuestraBiologica) {
        for (final ExamenSeleccionado examenSeleccionado : examenesSeleccionados) {
            if (examenSeleccionado.getExamen().getCodigoExamen() == examen.getCodigoExamen()) {
                examenSeleccionado.setEstadoMuestraBiologica(estadoMuestraBiologica);
                break;
            }
        }
    }
    
    public void updateTotalMuestrasBiologicas(final Examen examen, final int totalMuestrasBiologicas) {
        for (final ExamenSeleccionado examenSeleccionado : examenesSeleccionados) {
            if (examenSeleccionado.getExamen().getCodigoExamen() == examen.getCodigoExamen()) {
                examenSeleccionado.setTotalMuestrasBiologicas(totalMuestrasBiologicas);
                break;
            }
        }
    }

    public void removeExamenSeleccionado(final Examen examen) {
        final int examenesSeleccionadosSize = examenesSeleccionados.size();
        for (int i = 0; i < examenesSeleccionadosSize; i++) {
            if (examenesSeleccionados.get(i).getExamen().getCodigoExamen() == examen.getCodigoExamen()) {
                examenesSeleccionados.remove(i);
                break;
            }
        }
    }
    
    public boolean examenSeleccionadoExiste(final Examen examen) {
        return examenesSeleccionados.stream().anyMatch((examenSeleccionado) -> (examenSeleccionado.getExamen().getCodigoExamen() == examen.getCodigoExamen()));
    }
    
    public Examen getExamen(final int rowIndex) {
        return examenesPersonalizados.get(rowIndex).getExamen();
    }

    @Override
    public int getRowCount() {
        return examenesPersonalizados == null ? 0 : examenesPersonalizados.size();
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
        final ExamenDisponible examenDisponible = examenesDisponibles.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return examenDisponible.getExamen().getExamenNombre();

            case 2:
                return examenDisponible.getMuestraBiologica();

            case 3:
                return examenDisponible.getTotalMuestrasBiologicas() == -1 ? null : examenDisponible.getTotalMuestrasBiologicas();
                
            case 4:
                return examenDisponible.getEstadoMuestraBiologica();
                
            case 5:
                return examenDisponible.isSelected();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(final Object value, final int rowIndex, final int columnIndex) {
        final ExamenDisponible examenDisponible = examenesDisponibles.get(rowIndex);

        switch (columnIndex) {
            case 2:
                examenDisponible.setMuestraBiologica(value == null ? null : value.toString());
                break;
                
            case 3:
                examenDisponible.setTotalMuestrasBiologicas(Integer.valueOf(String.valueOf(value)) == -1 ? -1 : Integer.valueOf(String.valueOf(value)));
                break;
                
            case 4:
                examenDisponible.setEstadoMuestraBiologica(value == null ? null : value.toString());
                break;

            case 5:
                examenDisponible.setSelected(Boolean.parseBoolean(value.toString()));
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 5) {
            return Boolean.class;

        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 5:
                return true;

            default:
                if ((Boolean.parseBoolean(getValueAt(rowIndex, 5).toString()) && columnIndex == 2) || (Boolean.parseBoolean(getValueAt(rowIndex, 5).toString()) && columnIndex == 3) || (Boolean.parseBoolean(getValueAt(rowIndex, 5).toString()) && columnIndex == 4)) {
                    return true;
                }
                return false;
        }
    }
}