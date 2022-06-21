<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=usuario" method="POST">
                        <div class="form-group">
                            <label>CI</label>
                            <input type="text" value="${usuario.getCi()}" name="txtci" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${usuario.getNombres()}" name="txtnombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Apellidos</label>
                            <input type="text" value="${usuario.getApellidos()}" name="txtapellidos" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dirección</label>
                            <input type="text" value="${usuario.getDireccion()}" name="txtdireccion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Celular</label>
                            <input type="text" value="${usuario.getCelular()}" name="txtcelular" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="text" value="${usuario.getEmail()}" name="txtemail" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="text" value="${usuario.getContrasena()}" name="txtcontrasena" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CI</th>
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>DIRECCION</th>
                            <th>CELULAR</th>
                            <th>EMAIL</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="us" items="${usuarios}">
                            <tr>
                                <td>${us.getId_usuario()}</td>
                                <td>${us.getCi()}</td>
                                <td>${us.getNombres()}</td>
                                <td>${us.getApellidos()}</td>
                                <td>${us.getDireccion()}</td>
                                <td>${us.getCelular()}</td>
                                <td>${us.getEmail()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=usuario&accion=Editar&id_usuario=${us.getId_usuario()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=usuario&accion=Delete&id_usuario=${us.getId_usuario()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>

            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
