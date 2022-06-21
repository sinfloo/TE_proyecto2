package com.emergentes.modelo;

import com.emergentes.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    ConexionDB cn = new ConexionDB();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {
        String sql = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId_producto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setMarca(rs.getString(3));
                pr.setStock(rs.getInt(4));
                pr.setPrecio(rs.getDouble(5));
                pr.setEstado(rs.getString(6));
                pr.setId_proveedor(rs.getInt(7));
                pr.setId_categoria(rs.getInt(8));
                pr.setImagen(rs.getLong(9));

                lista.add(pr);
            }

        } catch (Exception e) {

        }
        return lista;
    }

    public int agregar(Producto p) {
        String sql = "INSERT INTO producto (nombre,marca,stock,precio,estado,id_proveedor,id_categoria,imagen) VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            ps.setInt(3, p.getStock());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getEstado());
            ps.setInt(6, p.getId_proveedor());
            ps.setInt(7, p.getId_categoria());
            ps.setLong(8, p.getImagen());

        } catch (Exception e) {
        }
        return r;
    }

    /*Método para buscar producto*/
    public Producto listarId_producto(int id_producto) {
        Producto pr = new Producto();
        String sql = "SELECT * FROM producto WHERE id_producto=" + id_producto;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId_producto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setMarca(rs.getString(3));
                pr.setStock(rs.getInt(4));
                pr.setPrecio(rs.getDouble(5));
                pr.setEstado(rs.getString(6));
                pr.setId_proveedor(rs.getInt(7));
                pr.setId_categoria(rs.getInt(8));
                pr.setImagen(rs.getLong(9));
            }
        } catch (Exception e) {
        }
        return pr;
    }

    public int actualizar(Producto pr) {
        String sql = "UPDATE producto SET nombre=?,marca=?,stock=?,precio=?,estado=?,id_proveedor=?,id_categoria=?,imagen=? WHERE id_producto=?";

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);

            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getMarca());
            ps.setInt(3, pr.getStock());
            ps.setDouble(4, pr.getPrecio());
            ps.setString(5, pr.getEstado());
            ps.setInt(6, pr.getId_proveedor());
            ps.setInt(7, pr.getId_categoria());
            ps.setLong(8, pr.getImagen());
            
            ps.setInt(9, pr.getId_producto());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id_producto){
        String sql = "DELETE FROM producto WHERE id_producto="+id_producto;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    /*
    public Producto buscar(String id_producto) {
        Producto p = new Producto();
        String sql = "SELECT * FROM producto WHERE id_producto=" + id_producto;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setMarca(rs.getString(3));
                p.setStock(rs.getInt(4));
                p.setPrecio(rs.getDouble(5));
                p.setEstado(rs.getString(6));
                p.setId_proveedor(rs.getInt(7));
                p.setId_categoria(rs.getInt(8));
                p.setImagen(rs.getLong(9));
            }
        } catch (Exception e) {
        }

        return p;
    }*/

}
