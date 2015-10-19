<%-- 
    Document   : index
    Created on : 29/08/2015, 10:11:59
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int num = Integer.parseInt(request.getParameter("txtnum"));
            for(int i =1 ; i<=num ; i++){
                %>
                <h1>Faculdade Senai</h1>
                <%
                out.println("Hoje é sabado");
            }
          %>      
            
    </body>
</html>
