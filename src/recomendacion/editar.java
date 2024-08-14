/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recomendacion;
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
    
    int idRecomendacion_editar=1;
    String new_Descripcion = "Configurar firewall";
    String new_NivelUrgencia = "Alto";
    String new_Amenaza_idAmenaza = "4";
    String sql = "UPDATE recomendacion set Descripcion='"+new_Descripcion+"',NivelUrgencia='"+new_NivelUrgencia+"',Amenaza_idAmenaza='"+new_Amenaza_idAmenaza+"' where idRecomendacion="+idRecomendacion_editar;
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM recomendacion ");
    rs.next();
    
    do{
    System.out.println("-"+rs.getString("idRecomendacion")+"-"+rs.getString("Descripcion")+"-"+rs.getString("NivelUrgencia")+"-"+rs.getString("Amenaza_idAmenaza"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
