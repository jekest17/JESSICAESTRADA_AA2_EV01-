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
public class agregar {
  public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String Descripcion = "Implementar autenticación de dos factores";
    String NivelUrgencia = "Alto";
    String Amenaza_idAmenaza = "2";
    String sql = "INSERT INTO recomendacion (Descripcion, NivelUrgencia, Amenaza_idAmenaza) values ('"+Descripcion+"','"+NivelUrgencia+"','"+Amenaza_idAmenaza+"')";
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
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
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}

