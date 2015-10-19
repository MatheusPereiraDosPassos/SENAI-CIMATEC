<%-- 
    Document   : index
    Created on : 29/08/2015, 10:25:44
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
            int fat=0;
            for(int i = 1 ;  i<=num ; i++){  
                fat*=i;
                out.println("O fatorial calculado é : " + fat);
            }
            
                %>
    </body>
</html>
