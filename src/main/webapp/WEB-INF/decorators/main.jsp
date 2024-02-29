<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Store</title>
    <link rel="stylesheet" href="<c:url value='/lib/bootstrap/css/bootstrap.min.css'/>">
    
</head>
<body>
   <body class="p-3" style="display:flex;justify-content:flex-start;flex-direction:column;align-items:center;min-height:100vh">
         <sitemesh:write property="body"/>
   </body>
   <script src="<c:url value='/lib/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

</body>
</html>