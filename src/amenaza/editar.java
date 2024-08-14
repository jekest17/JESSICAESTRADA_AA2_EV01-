/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amenaza;
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
    
    int idAmenaza_editar=2;
    String new_Descripcion = "Phishing en correos electrónicos";
    String new_NivelRiesgo = "Alto";
    String new_Analisis_idAnalisis = "1";
    String sql = "UPDATE amenaza set Descripcion='"+new_Descripcion+"',NivelRiesgo='"+new_NivelRiesgo+"',Analisis_idAnalisis='"+new_Analisis_idAnalisis+"' where idAmenaza="+idAmenaza_editar;
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM amenaza ");
    rs.next();
    
    do{
    System.out.println("-"+rs.getString("idAmenaza")+"-"+rs.getString("Descripcion")+"-"+rs.getString("NivelRiesgo")+"-"+rs.getString("Analisis_idAnalisis"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
