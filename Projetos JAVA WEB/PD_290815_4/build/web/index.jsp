<%-- 
    Document   : index
    Created on : 29/08/2015, 11:23:28
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
        <c:out value="BOm dia rapaziada!!!"/>
        <c:set var="valor" value="10"/>
        <c:out value = "${valor}"/>
        <c:forEach var = "x" begin="1" end="${valor}" step="1">
            <c:if test="${x%2==0}">
            <c:out value = "O numero ${x} e par!"/>
            </br>
        </c:if>
        </c:forEach>
               
    </body>
</html>
