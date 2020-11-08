<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Bicicleteria</title>
    </head>
    <body>
        <h1> Hola ${user}!</h1>

        <form method="post" action="EncargadoServlet">

            <div>   
                <h2>Cargar pieza</h2>
                <p>
                    <label> Nombre: </label><br>
                    <input type="text" name="nombre">
                </p>
                <p>
                    <label> N° Serie: </label><br>
                    <input type="text" name="serie">
                </p>
                <p>
                    <label> Categoria: </label><br>
                    <select name="categoria" size="1">
                        <option value="cuadro"> Cuadro </option>
                        <option value="rueda"> Rueda </option>
                        <option value="manubrio"> Manubrio </option>
                        <option value="asiento"> Asiento </option>
                        <option value="pedal"> Pedal </option>
                        <option value="kit"> Kit Mecanico </option>
                    </select>

                    <input type="submit" value ="Alta">
                </p>
                <div class="confirm">${textConfirm}${textData}</div>
            </div>
        </form>
        
        <form method="post" action="VolverInicioServlet"> 
            <input type="submit" value ="SALIR">
        </form>

    </body>
</html>
