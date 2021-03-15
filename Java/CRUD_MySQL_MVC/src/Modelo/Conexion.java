package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/crud";
    private String user="root";
    private String pwd=""; 
    private Connection con = null;
    
    public Connection getConnection () {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(this.url,this.user,this.pwd);
        }
        catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en la conexion.");
        }
        return con;
    }
}
