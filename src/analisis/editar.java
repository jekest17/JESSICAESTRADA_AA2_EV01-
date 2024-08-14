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
public class editar {
    
     public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    int idAnalisis_editar=1;
    String new_Fecha = "2022-01-26";
    String new_Resultado = "Se detectó un intento de intrusión";
    String new_Usuario_idUsuario = "6";
    String new_Sistema_idSistema = "1";
    String sql = "UPDATE analisis set Fecha='"+new_Fecha+"',Resultado='"+new_Resultado+"',Usuario_idUsuario='"+new_Usuario_idUsuario+"',Sistema_idSistema='"+new_Sistema_idSistema+"' where idAnalisis="+idAnalisis_editar;
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM analisis ");
    rs.next();
    
    do{
    System.out.println("-"+rs.getString("idAnalisis")+"-"+rs.getString("Fecha")+"-"+rs.getString("Resultado")+"-"+rs.getString("Usuario_idUsuario")+"-"+rs.getString("Sistema_idSistema"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
