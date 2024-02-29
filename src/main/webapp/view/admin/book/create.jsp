<body>
    <%@ include file="/common/header.jsp" %>
    <div style="position:relative;width:100%;display:flex;justify-content:center;align-items:center">
        <a  href="<%=request.getContextPath()%>/admin/book" class="btn btn-secondary" role="button" style="position:absolute;left:0;top:0;display:block">Back</a>
        <h1>Create Book</h1>
    </div>
    <form action="<%=request.getContextPath()%>/admin/book" method="post"  enctype="multipart/form-data">
        <div class="mb-3">
          <label for="nameFor" class="form-label">Name Book</label>
          <input type="text" class="form-control" id="nameFor" name="name">
        </div>
        <div class="mb-3">
          <label for="photoFor" class="form-label">Upload File</label>
          <input type="file" class="form-control" id="photoFor" name="photo">
        </div>
        <input type="submit" class="btn btn-primary" value="create" name="action"/>
    </form> 
</body>
