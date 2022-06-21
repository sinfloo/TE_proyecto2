
package com.emergentes.modelo;

public class Venta {
    int id_ventas;
    int id_cliente;
    int is_usuario;
    String numero_ventas;
    String fecha_ventas;
    double precio_total;
    
    // variables adicionales
    int item;
    int id_producto; 
    String descripcionP;
    double precio;
    int cantidad;
    double subtotal;

    public Venta() {
    }

    public Venta(int id_ventas, int id_cliente, int is_usuario, String numero_ventas, String fecha_ventas, double precio_total, int item, int id_producto, String descripcionP, double precio, int cantidad, double subtotal) {
        this.id_ventas = id_ventas;
        this.id_cliente = id_cliente;
        this.is_usuario = is_usuario;
        this.numero_ventas = numero_ventas;
        this.fecha_ventas = fecha_ventas;
        this.precio_total = precio_total;
        this.item = item;
        this.id_producto = id_producto;
        this.descripcionP = descripcionP;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getIs_usuario() {
        return is_usuario;
    }

    public void setIs_usuario(int is_usuario) {
        this.is_usuario = is_usuario;
    }

    public String getNumero_ventas() {
        return numero_ventas;
    }

    public void setNumero_ventas(String numero_ventas) {
        this.numero_ventas = numero_ventas;
    }

    public String getFecha_ventas() {
        return fecha_ventas;
    }

    public void setFecha_ventas(String fecha_ventas) {
        this.fecha_ventas = fecha_ventas;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
