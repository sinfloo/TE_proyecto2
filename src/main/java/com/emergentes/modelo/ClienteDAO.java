
package com.emergentes.modelo;

import com.emergentes.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    ConexionDB cn = new ConexionDB();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String ci){
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE ci="+ci;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c.setId_cliente(rs.getInt(1));
                c.setCi(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setCelular(rs.getString(7));
            }
        } catch (Exception e) {
        }
        
        return c;
    }
    
    public List listar(){
        String sql = "SELECT * FROM cliente";
        List<Cliente>lista = new ArrayList<>();
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt(1));
                cl.setCi(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setApellidos(rs.getString(4));
                cl.setDireccion(rs.getString(5));
                cl.setEmail(rs.getString(6));
                cl.setCelular(rs.getString(7));
                
                lista.add(cl);
            }
            
        } catch (Exception e){
            
        }
        return lista;
    }
    
}
