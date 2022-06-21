package com.emergentes.controlador;

import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.ClienteDAO;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.ProductoDAO;
import com.emergentes.modelo.Usuario;
import com.emergentes.modelo.UsuarioDAO;
import com.emergentes.modelo.Venta;
import com.emergentes.modelo.VentaDAO;
import com.emergentes.utiles.GenerarNumero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Usuario us = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    int idu;

    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    int idc;

    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int idp;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;

    double totalPagar;

    String numeroventa="0";
    VentaDAO vdao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        // System.out.println("1. ACCION ES: ==========>"+accion);

        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        
        if (menu.equals("cliente")) {
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        
        if (menu.equals("usuario")) {
            switch (accion) {
                case "Listar":
                    List lista = udao.listar();
                    request.setAttribute("usuarios", lista);
                    break;
                case "Agregar":
                    String ci = request.getParameter("txtci");
                    String nombres = request.getParameter("txtnombres");
                    String apellidos = request.getParameter("txtapellidos");
                    String direccion = request.getParameter("txtdireccion");
                    String celular = request.getParameter("txtcelular");
                    String email = request.getParameter("txtemail");
                    String contrasena = request.getParameter("txtcontrasena");

                    us.setCi(ci);
                    us.setNombres(apellidos);
                    us.setApellidos(nombres);
                    us.setDireccion(direccion);
                    us.setCelular(celular);
                    us.setEmail(email);
                    us.setContrasena(contrasena);

                    udao.agregar(us);
                    System.out.println("CI: " + ci);
                    System.out.println("NOMBRES: " + nombres);
                    request.getRequestDispatcher("Controlador?menu=usuario&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idu = Integer.parseInt(request.getParameter("id_usuario"));
                    Usuario u = udao.listarId_usuario(idu);
                    request.setAttribute("usuario", u);
                    request.getRequestDispatcher("Controlador?menu=usuario&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String ci1 = request.getParameter("txtci");
                    String nombres1 = request.getParameter("txtnombres");
                    String apellidos1 = request.getParameter("txtapellidos");
                    String direccion1 = request.getParameter("txtdireccion");
                    String celular1 = request.getParameter("txtcelular");
                    String email1 = request.getParameter("txtemail");
                    String contrasena1 = request.getParameter("txtcontrasena");

                    us.setCi(ci1);
                    us.setNombres(apellidos1);
                    us.setApellidos(nombres1);
                    us.setDireccion(direccion1);
                    us.setCelular(celular1);
                    us.setEmail(email1);
                    us.setContrasena(contrasena1);
                    us.setId_usuario(idu);
                    udao.actualizar(us);
                    request.getRequestDispatcher("Controlador?menu=usuario&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idu = Integer.parseInt(request.getParameter("id_usuario"));
                    udao.delete(idu);
                    request.getRequestDispatcher("Controlador?menu=usuario&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
        }
        
        if (menu.equals("proveedor")) {
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }
        
        //System.out.println("2. ACCION ES ANTES DE ENTRAR A NuevaVenta: ==========>"+accion);
        if (menu.equals("NuevaVenta")) {
            v = new Venta();
            switch (accion) {
                case "BuscarCliente":
                    String ci = request.getParameter("codigocliente");
                    c.setCi(ci);
                    c = cdao.buscar(ci);
                    request.setAttribute("c", c);
                    request.setAttribute("nventa", numeroventa);
                    break;
                case "BuscarProducto":
                    int id_producto = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.listarId_producto(id_producto);
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nventa", numeroventa);
                    break;
                case "Agregar":
                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId_producto();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;

                    v = new Venta(); // inicializar para que empiece en vacio

                    v.setItem(item);
                    v.setId_producto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    
                    lista.add(v);
                    
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nventa", numeroventa);
                    break;
                    
                default:
                    /* VERIFICAR ESTA PARTE DE GENERAR NÚMERO SERIE */
                    /* ============================================== */
                    numeroventa = vdao.GenerarNumero();
                    if (numeroventa == null) {
                        numeroventa = "00000001";
                        request.setAttribute("nventa", numeroventa);
                    } else {
                        int incrementar = Integer.parseInt(numeroventa);
                        GenerarNumero gn = new GenerarNumero();
                        numeroventa = gn.NumeroVenta(incrementar);
                        request.setAttribute("nventa", numeroventa);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    /* ============================================== */
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
