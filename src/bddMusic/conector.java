/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bddMusic;
import java.sql.*;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;

/**
 *
 * @author victorsalazar
 */
public class conector {
    Connection connection;
    Statement Stm;
    String Query,Tablenom;
    ResultSet results;
    
    public ResultSet getResult(){
    return results;
    }
    
    public conector () throws SQLException{
        try {
           // jdbc:oracle:thin:@localhost:15211:XE
    this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MUSICGALERYBDD","mysound");
    this.Stm=this.connection.createStatement(this.results.TYPE_SCROLL_INSENSITIVE,this.results.CONCUR_UPDATABLE);
    JOptionPane.showMessageDialog(null,"Conexion Exitosa");
        }    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex + "\n Error al Conectar a MUSICGALERYBDD");
    }
    }
    
    public void StartQuery(String query){
    try{
        this.results=Stm.executeQuery(query);
        JOptionPane.showMessageDialog(null,"Exito al Ejecutar el Query");

    }catch(SQLException ex){
    
    JOptionPane.showMessageDialog(null,ex+"\nError al Ejecutar el Query");
    }
    
    }
    
  
    
    public String[] SacarQuery(String campo,int tama){
   try {
            String[] codigo =  new  String[tama];
          int i=0;	
         
  while(getResult().next() == true) {
      
              codigo[i] = getResult().getString(campo);
              JOptionPane.showMessageDialog(null,codigo[i]);
             
i++;
            }
         return codigo;
        } catch (SQLException sqlExcpt) {
            JOptionPane.showMessageDialog(null, "Error  al insertar"+ sqlExcpt);
        }
        return null;

  
  }
    
}
