package com.emergentes.controlador;

import com.emergentes.modelo.UsuarioDAO;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    UsuarioDAO udao = new UsuarioDAO();
    Usuario us = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        //System.out.println("-------> "+accion);
        if (accion.equalsIgnoreCase("Ingresar")) {
            String email = request.getParameter("txtemail");
            String contrasena = request.getParameter("txtcontrasena");
            us = udao.validar(email, contrasena);
            if (us.getEmail() != null) {
                //System.out.println("EL USUARIO EXISTE =============");
                request.setAttribute("user", us);
                //request.getRequestDispatcher("Controlador?accion=principal").forward(request, response);
                request.getRequestDispatcher("Controlador?menu=principal").forward(request, response);
            } else {
                //System.out.println("EL USUARIO NO EXISTE =============");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
