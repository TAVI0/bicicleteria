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
        
           <form method="post" action="BicicleteroServlet">
            <div> 
                <h2>Armar Bici</h2>
             <p>
                <label> N° Serie: </label><br>
                <select name="serie" size="1">
                    ${numSerieSel}
                </select>
                <input type="submit" value ="Ver">
             </p>
             <div class="confirm">${textConfirm}${textData}</div>
             
            </form> 
        
        <form method="post" action="VolverInicioServlet"> 
            <input type="submit" value ="SALIR">
        </form>
        
    </body>
</html>
