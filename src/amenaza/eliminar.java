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
public class eliminar {
    
     public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    //dato a eliminar 
     int idAmenaza_eliminar=3;
     
     // instruccion sql
     
     String sql= "DELETE fROM amenaza where idAmenaza="+idAmenaza_eliminar;
     
     try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);    
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
        Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
