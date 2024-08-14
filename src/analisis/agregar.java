/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisis;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jjer1
 */
public class agregar {
  public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String Fecha = "2023-08-14";
    String Resultado = "Vulnerabilidad identificada en el servidor";
    String Usuario_idUsuario = "6";
    String Sistema_idSistema = "3";
    String sql = "INSERT INTO analisis (Fecha, Resultado, Usuario_idUsuario, Sistema_idSistema ) values ('"+Fecha+"','"+Resultado+"','"+Usuario_idUsuario+"','"+Sistema_idSistema+"')";
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM analisis ");
    rs.next();
    
    do{
    System.out.println("-"+rs.getString("idAnalisis")+"-"+rs.getString("Fecha")+"-"+rs.getString("Resultado")+"-"+rs.getString("Usuario_idUsuario")+rs.getString("Sistema_idSistema"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}


