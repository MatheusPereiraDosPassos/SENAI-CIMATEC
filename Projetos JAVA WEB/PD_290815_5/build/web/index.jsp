<%-- 
    Document   : index
    Created on : 29/08/2015, 11:43:50
    Author     : Matthew
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:out value="Calculando Fibronacci....."/>
        <c:set var = "valor" value ="0"/>
        <c:set var = "valor" value="1"/>
        <c:forEach var ="x" begin="1" end="${param.txtnum}" step="1">
            <c:set var = "temp" value="$serie"/>
            <c:set var = "serie" value="$serie+txtnum"/>
            <c:set var = "valor" value="$temp"/>
            <c:out value="${serie}"/>
        </c:forEach>
    </body>
</html>
