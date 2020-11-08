<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="style.css">
        <link rel="icon" type="image/x-icon" href="img/favicon.ico">
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
        <title>Menú de cervezas</title>
    </head>
    <body>
        <h1>ERROR</h1>
        <p>
            ${mensajeError}  
        </p>     
        
        <form method="post" action="VolverInicioServlet"> 
           <input type="submit" value ="SALIR">
        </form>
        
    </body>
</html>
