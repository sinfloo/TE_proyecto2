
package com.emergentes.modelo;

import com.emergentes.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VentaDAO {
    Connection conn;
    ConexionDB cn = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;
    
    public String GenerarNumero(){
        String numeroventa = "";
        String sql = "SELECT MAX(numero_ventas) FROM ventas";
        try {
            conn=cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                numeroventa = rs.getString(1);
            }
        } catch (Exception e) {
        }
        // numero maximo
        return numeroventa;
    }
}
