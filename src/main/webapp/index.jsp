<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css' rel='stylesheet'>
        <link href="css/signin.css" rel="stylesheet">

        <script type='text/javascript' src=''></script>
        <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
        <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js'></script>
    </head>
    <body>
        <section class="body">
            <div class="container">
                <div class="login-box">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="logo">
                                <span class="logo-font">Sistema</span>Ventas
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <br>
                            <h3 class="header-title">Iniciar Sesión</h3>
                            
                            <form action="Validar" method="post" class="login-form">
                                <div class="form-group">
                                    <input type="email" name="txtemail" class="form-control" placeholder="Usuario">
                                </div>
                                
                                <div class="form-group">
                                    <input type="password" name="txtcontrasena" class="form-control" placeholder="Contraseña">
                                   <!-- <a href="#!" class="forgot-password">Forgot Password?</a>-->
                                </div>
                                
                                <div class="form-group">
                                    <button name="accion" value="Ingresar" class="btn btn-primary btn-block">Ingresar</button>
                                </div>
                                
                                <div class="form-group">
                                    <div class="text-center">¿No tienes cuenta? <a href="#!">Regístrate</a></div>
                                </div>
                            </form>
                            
                        </div>
                        <div class="col-sm-6 hide-on-mobile">
                            <div id="demo" class="carousel slide" data-ride="carousel">
                                <!-- Indicators -->
                                <ul class="carousel-indicators">
                                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                                    <li data-target="#demo" data-slide-to="1"></li>
                                </ul>
                                <!-- The slideshow -->
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <div class="slider-feature-card">
                                            <img src="img/ferreteria1.png" alt="">
                                            <h3 class="slider-title">Ferreteria</h3>
                                            <p class="slider-description">¡ Ferretería de Calidad !</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <div class="slider-feature-card">
                                            <img src="img/ferreteria.png" alt="">
                                            <!--<h3 class="slider-title">Title</h3>-->
                                            <p class="slider-description">Lo primero que se aprende al comprar una casa nueva es que se vive en ella. Allí duerme uno, pero vive en la ferretería.</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- Left and right controls -->
                                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                                    <span class="carousel-control-prev-icon"></span>
                                </a>
                                <a class="carousel-control-next" href="#demo" data-slide="next">
                                    <span class="carousel-control-next-icon"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script type='text/javascript'></script>
    </body>
</html>
