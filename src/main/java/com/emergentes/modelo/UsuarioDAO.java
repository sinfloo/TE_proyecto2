
package com.emergentes.modelo;

import com.emergentes.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    ConexionDB cn = new ConexionDB();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuario validar(String email, String contrasena) {
        Usuario us = new Usuario();
        String sql = "SELECT * FROM usuario WHERE email=? AND contrasena=?";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setEmail(rs.getString("email"));
                us.setContrasena(rs.getString("contrasena"));
                us.setNombres(rs.getString("nombres"));
                us.setApellidos(rs.getString("apellidos"));
            }
        } catch (Exception e) {
            
        }
        return us;
    }
    
    public List listar(){
        String sql = "SELECT * FROM usuario";
        List<Usuario>lista = new ArrayList<>();
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt(1));
                us.setCi(rs.getString(2));
                us.setNombres(rs.getString(3));
                us.setApellidos(rs.getString(4));
                us.setDireccion(rs.getString(5));
                us.setCelular(rs.getString(6));
                us.setEmail(rs.getString(7));
                lista.add(us);
            }
            
        } catch (Exception e){
            
        }
        return lista;
    }
    
    public int agregar(Usuario us){
        String sql = "INSERT INTO usuario(ci,nombres,apellidos,direccion,celular,email,contrasena) VALUES (?,?,?,?,?,?,?)";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, us.getCi());
            ps.setString(2, us.getNombres());
            ps.setString(3, us.getApellidos());
            ps.setString(4, us.getDireccion());
            ps.setString(5, us.getCelular());
            ps.setString(6, us.getEmail());
            ps.setString(7, us.getContrasena());
         
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int actualizar(Usuario us){
        String sql = "UPDATE usuario SET ci=?,nombres=?,apellidos=?,direccion=?,celular=?,email=?,contrasena=? WHERE id_usuario=?";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, us.getCi());
            ps.setString(2, us.getNombres());
            ps.setString(3, us.getApellidos());
            ps.setString(4, us.getDireccion());
            ps.setString(5, us.getCelular());
            ps.setString(6, us.getEmail());
            ps.setString(7, us.getContrasena());
            
            ps.setInt(8, us.getId_usuario());
         
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Usuario listarId_usuario(int id_usuario){
        Usuario usu = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id_usuario="+id_usuario;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                usu.setCi(rs.getString(2));
                usu.setNombres(rs.getString(3));
                usu.setApellidos(rs.getString(4));
                usu.setDireccion(rs.getString(5));
                usu.setCelular(rs.getString(6));
                usu.setEmail(rs.getString(7));
                usu.setContrasena(rs.getString(8));
            }
        } catch (Exception e) {
        }
        return usu;
    }
    
    public void delete(int id_usuario){
        String sql = "DELETE FROM usuario WHERE id_usuario="+id_usuario;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
