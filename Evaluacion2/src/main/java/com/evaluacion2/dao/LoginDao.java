package com.evaluacion2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.evaluacion2.conexion.Conexion;

public class LoginDao extends Conexion{

    public boolean autenticacion(String usuario, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select * from login where usuario=? and contrasena=?";
            pst = getConexion().prepareStatement(consulta); 
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            
            if(rs.next()){
                return true;
                
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
            
        }
        return false;
    }
    
   //public static void main(String[] args){
   //	LoginDao co = new LoginDao();
   //   
   //   //DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
   ///    Date date = new Date();
   ////   System.out.println("Hora actual: " + dateFormat.format(date));
   // //  System.out.println(co.autenticacion("sergio","1234"));
   //   //System.out.println(co.crearDueno(135809179, "sergio", "figueroa", "tacna 144", "safigue79@gmail.com","964951703","Pepo"));
   //   //System.out.println(co.crearMascota(13580917,"Perro",2,"Dogo"));
   ///    Date dt = new Date();
   ////   System.out.println(co.crearAgenda(1,13580917,"Dogo",12:25:25,20/12/12));
   //
}
