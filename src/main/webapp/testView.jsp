<%-- 
    Document   : testView.jsp
    Created on : 25 oct. 2023, 13:27:37
    Author     : a895279
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br>Nb d'employees</br>
        <br><%=request.getSession().getAttribute("count")%></br> 
        <br></br> 
            
         <br>montant de l'inventaire </br>
        <br><%=request.getSession().getAttribute("value")%></br>
        
           <br>montant de l'inventaire IN </br>
        <br><%=request.getSession().getAttribute("valueStcIn")%></br>
        
    </body>
</html>
