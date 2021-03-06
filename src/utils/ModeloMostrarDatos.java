package utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

/** @author alfreding0 */
public class ModeloMostrarDatos {
    
    public static final int COLUMNA_0 = 0;
    public static final int COLUMNA_1 = 1;
    
    public ModeloMostrarDatos(){ }
    
    public void mostrar(String[] tituloEncabezado, JTable mitabla, Conexion con, String consulta) throws SQLException{
        
            ResultSet rs=con.ejecutarConsulta(consulta); 
        
            DefaultTableModel model = new DefaultTableModel(null, tituloEncabezado);
            
            ResultSetMetaData datos = rs.getMetaData();  
            int num_columnas = datos.getColumnCount();
            
            while(rs.next()){
                Object datosPorFila []=new Object[num_columnas]; 
                for(int i=0; i<num_columnas; i++){
                    int columnIndex=i+1;
                    datosPorFila[i]=rs.getObject(columnIndex);
                }
                model.addRow(datosPorFila);
            }
            
            mitabla.setModel(model);
            
    }
    
    public void mostrar(int inicioIndex, String[] tituloEncabezado, JTable mitabla, Conexion con, String consulta) throws SQLException{
        
            ResultSet rs=con.ejecutarConsulta(consulta); 
        
            DefaultTableModel model = new DefaultTableModel(null, tituloEncabezado);
            
            ResultSetMetaData datos = rs.getMetaData();  
            int num_columnas = datos.getColumnCount();
            
            while(rs.next()){
                Object datosPorFila []=new Object[num_columnas]; 
                for(int i=inicioIndex; i<num_columnas; i++){
                    int columnIndex=i+1;
                    datosPorFila[i]=rs.getObject(columnIndex);
                }
                model.addRow(datosPorFila);
            }
            
            mitabla.setModel(model);
            
    }
}
/** @author alfreding0 */