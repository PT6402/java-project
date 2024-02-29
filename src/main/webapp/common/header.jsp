<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header style="display:flex;justify-content:flex-end;align-items:center;width:100%;gap:1rem">
    <div>
        <a href="<%=request.getContextPath()%>/store" class="btn btn-secondary" role="button">Home</a>
    </div>
   <div class="dropdown">
        <button class="btn btn-warning dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          Hi! ${user.getName()}
        </button>
        <ul class="dropdown-menu">
          <c:if test="${user.getRole()=='admin'}">
            <li><a class="dropdown-item" href="<%= request.getContextPath()%>/admin/book">Book</a></li>
            <li><a class="dropdown-item" href="<%= request.getContextPath()%>/admin/account">Account</a></li>
          </c:if>
          <li><a class="dropdown-item" href="<%= request.getContextPath()%>/login?action=logout">Logout</a></li>
        </ul>
    </div>
</header>