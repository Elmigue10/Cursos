package Capa_datos;
import java.sql.*;
 

public class Conexion {

    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/ventas";
    private String user="root";
    private String pwd=""; 

    public Conexion ()
    {}
    
    public ResultSet Listar(String Cad)
    {
            try
            {
                Class.forName(driver).newInstance();
                Connection cn=DriverManager.getConnection(url,user,pwd);
                PreparedStatement da= cn.prepareStatement(Cad);
                ResultSet tb1 = da.executeQuery();
                return tb1;
                
            }
            catch(Exception e)
            {
                javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
                return null;
            }
    }
    
    public String Ejecutar (String Cad)
    {
        try
        {
            Class.forName(driver).newInstance();
            Connection cn=DriverManager.getConnection(url,user,pwd);
            PreparedStatement da=cn.prepareStatement(Cad);
            int r=da.executeUpdate();
            return "se afectaron"+r+" filas";
        }
        catch (Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
            return "Error "+e.getMessage();
        }
    }
    
}