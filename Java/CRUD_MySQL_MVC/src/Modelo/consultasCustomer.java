package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

public class consultasCustomer extends Conexion{
    
    public boolean registrar(Customer custo){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO customer (name, address, phone) "
                + "VALUES(?,?,?)";
        
        try {
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, custo.getName());
            ps.setString(2, custo.getAddress());
            ps.setString(3, custo.getPhone());
            ps.execute();
            return true;
            
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
        finally {
            try{
                con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public boolean editar(Customer custo){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE customer SET name = ?, address = ?, phone = ? "
                + "WHERE id = ?";
        
        try {
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, custo.getName());
            ps.setString(2, custo.getAddress());
            ps.setString(3, custo.getPhone());
            ps.setInt(4, custo.getId());
            ps.execute();
            return true;
            
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
        finally {
            try{
                con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public boolean eliminar(Customer custo){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM customer WHERE id = ?";
        
        try {
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, custo.getId());
            ps.execute();
            return true;
            
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
        finally {
            try{
                con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public boolean buscar(Customer custo){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM customer WHERE id = ?";
        
        try {
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, custo.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                custo.setId(Integer.parseInt(rs.getString("id")));
                custo.setName(rs.getString("name"));
                custo.setAddress(rs.getString("address"));
                custo.setPhone(rs.getString("phone"));
                return true;
            }
            
            return false;
            
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
        finally {
            try{
                con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
