package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class conexion {
    
    public Connection obtenerConexion() {
        
        Connection conexion = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/modulo3", "root","");
            
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error de la clase Conexion" + ex.getMessage());
        }
        return conexion;
    }
    
}
