<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <%@ include file="/common/header.jsp" %>
    <h1> 
        <a href="<%=request.getContextPath()%>/admin/book" class="btn btn-secondary" role="button">Back</a> 
        Edit Book ${book.getName()}
    </h1>
    <form action="<%=request.getContextPath()%>/admin/book" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${book.getId()}" name="id">
        <div class="mb-3">
          <label for="nameFor" class="form-label">Name Book</label>
          <input type="text" class="form-control" id="nameFor" name="name" value="${book.getName()}">
        </div>
        <div class="mb-3">
          <label for="photoFor" class="form-label">Upload File</label>
          <input type="file" class="form-control" id="photoFor" name="photo">
        </div>
        <input type="submit" class="btn btn-primary" value="create" name="action"/>
    </form>
</body>