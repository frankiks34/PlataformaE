<%-- 
    Document   : index
    Created on : 3 oct. 2024, 12:03:47 p. m.
    Author     : Frank
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    </head>
    
    
      <%
  String frank =(String)request.getSession().getAttribute("a");
                                    %>
    
    <body>
       <h2>Registro</h2>
    <form action="registro" method="POST">
        
        <h1>Nota Final</h1>
    <label for="nombre">Examen Parcial:</label>
    <input type="text" id="notas1" name="notas1" >

    
    <label for="nombre">Examen Finak:</label>
    <input type="text" id="notas2" name="notas2" >

     <label for="nombre">Practica Calificada 1</label>
    <input type="text" id="notas3" name="notas3" >
    
     <label for="nombre">Practica Calificada 2</label>
    <input type="text" id="notas4" name="notas4" >
    <tr>
    <td><%=frank %> </td>
    <tr>
    <input type="submit" value="Calcular">
</form>
    </body>
</html>
