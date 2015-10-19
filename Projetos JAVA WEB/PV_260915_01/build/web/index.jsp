<%-- 
    Document   : index
    Created on : 26/09/2015, 10:35:13
    Author     : Matthew
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <c:forEach var ="x" begin="${param.txtnum}" end="1" step="1">
            <c:out value="${x}"/>
        </c:forEach>
    </body>
</html>
