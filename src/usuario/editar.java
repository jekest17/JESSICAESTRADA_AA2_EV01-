/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;
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
public class editar {
    
     public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    int idUsuario_editar=11;
    String new_Nombre = "Th2";
    String new_Correo_Electronico = "thing21254@gmail.com";
    String new_Contraseña = "123446";
    String new_Rol = "Usuario";
    String sql = "UPDATE usuario set Nombre='"+new_Nombre+"',Correo_Electronico='"+new_Correo_Electronico+"',Contraseña='"+new_Contraseña+"',Rol='"+new_Rol+"' where idUsuario="+idUsuario_editar;
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM usuario ");
    rs.next();
    
    do{
    System.out.println("-"+rs.getString("idUsuario")+"-"+rs.getString("Nombre")+"-"+rs.getString("Correo_Electronico")+"-"+rs.getString("Contraseña")+"-"+rs.getString("Rol"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
