<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Bicicleteria</title>
    </head>
    <body>
        <h1>Bienvenido a tu bicicletería!</h1>
        <form method="post" action="LoginServlet">

            <div>
                <p> <label> Usuario: </label> <br>
                    <input type="text" name="usuario">
                </p>
                <p> <label> Contraseña: </label> <br>
                    <input type="password" name="contrasena">
                </p>
                <p> 
                    <input type="submit" value="Entrar"> 
                </p>  
            </div>

        </form>
    </body>
</html>
