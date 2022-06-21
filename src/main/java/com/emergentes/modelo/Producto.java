
package com.emergentes.modelo;

public class Producto {
    
    int id_producto;
    String nombre;
    String marca;
    int stock;
    double precio;
    String estado;
    int id_proveedor;
    int id_categoria;
    long imagen;

    public Producto() {
    }

    public Producto(int id_producto, String nombre, String marca, int stock, double precio, String estado, int id_proveedor, int id_categoria, long imagen) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
        this.id_proveedor = id_proveedor;
        this.id_categoria = id_categoria;
        this.imagen = imagen;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public long getImagen() {
        return imagen;
    }

    public void setImagen(long imagen) {
        this.imagen = imagen;
    }
    
    
}
