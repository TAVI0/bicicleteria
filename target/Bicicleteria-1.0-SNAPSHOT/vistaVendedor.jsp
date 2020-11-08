<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Bicicleteria</title>
    </head>
    <body>
        <h1> Hola ${nombre}!</h1>
        
        <form method="post" action="VendedorServlet">
            <div>
                <p>
                <h2>Seleccione una Bicicleta</h2>

                <label> BICICLETAS: </label>
                <select name="bici" size="1">
                    ${biciSel}
                </select>

                <input type="submit" value ="Vender">
                </p>
            </div>
            <div class="confirm">${textConfirm}${textData}</div>
        </form>

        <form method="post" action="VolverInicioServlet"> 
            <input type="submit" value ="SALIR">
        </form>

    </body>
</html>
