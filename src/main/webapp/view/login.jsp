<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
   <h1>Login</h1>
   <c:if test="${error!=null}">
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
          <p>${error}</p>
         <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
   </c:if>
   <form action="<%= request.getContextPath( )%>/login" method="post" style="width:350px;">
      <div class="mb-3">
        <label for="emailFor" class="form-label">Email address</label>
        <input type="email" class="form-control" id="emailFor" name="email">
      </div>
      <div class="mb-3">
        <label for="passwordFor" class="form-label">Password</label>
        <input type="password" class="form-control" id="passwordFor" name="password">
      </div>
      <button type="submit" class="btn btn-primary">Login</button>
   </form>
</body>