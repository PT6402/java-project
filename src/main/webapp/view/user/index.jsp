<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <%@ include file="/common/header.jsp" %>    
     <h1>Book Store</h1>
     <table class="table">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Photo</th>
            <th scope="col">Download</th>
          </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${!list.isEmpty()}" >
                    <c:forEach var="item" items="${list}">
                        <tr>
                            <th scope="row">${item.getId()}</th>
                            <td>${item.getName()}</td>
                            <td>
                                <img src="<c:url value='/uploads/${item.getPhoto()}'/>" alt="${item.getPhoto()}">
                            </td>
                            <td>
                                <a href="" class="btn btn-info" role="button">Download</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:when test="${list.isEmpty()}" >
                    <tr>
                        <td colspan="4">
                            <p class="text-center">No data</p>
                        </td>
                    </tr>
                </c:when>
            </c:choose>   
    </tbody>
</table>
</body>
