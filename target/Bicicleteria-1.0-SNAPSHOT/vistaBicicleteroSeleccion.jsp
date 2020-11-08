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


        <form method="post" action="BicicleteroServlet"> <!-- Crear BicicleteroServlet -->
            <div>
                <h2>Armar Bici</h2>
                <p>
                    <label>N° Serie: </label><br>
                        <select name="serie" size="1">
                        ${numSerieSel}
                        </select>
                    <input type="submit" value ="Ver">
                </p>
            </div>
        </form>

        <form method="post" action="BicicleteroSeleccionServlet">
            <div>
                <p>
                <h2>Piezas disponibles de la serie ${serie}:</h2>

                <label> Cuadro: </label>
                <select name="cuadro" size="1">
                    ${cuadroSel}
                </select>

                <br>
                
                <label> Rueda: </label>
                <select name="rueda" size="1">
                    ${ruedaSel}
                </select>

                <br>

                <label> Manubrio: </label>
                <select name="manubrio" size="1">
                    ${manubrioSel}
                </select>

                <br>

                <label> Asiento: </label>
                <select name="asiento" size="1">
                    ${asientoSel}
                </select>

                <br>

                <label> Pedal: </label>
                <select name="pedal" size="1">
                    ${pedalSel}
                </select>

                <br>

                <label> Kit: </label>
                <select name="kit" size="1">
                    ${kitSel}
                </select>

                <br>
                <input type="submit" value ="Alta">
                </p>
            </div>
                
        </form>
                             
        <form method="post" action="VolverInicioServlet"> 
            <input type="submit" value ="SALIR">
        </form>
                
    </body>
</html>
