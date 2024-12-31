<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Department Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type=" text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
<div class="container mt-5 border border-1">
    <div class="container">
        <div class="fs-1">
            <div class="fw-bolder">Manage Department</div>
        </div>
        <form:form action="/departments/saveDepartment" method="post" cssClass="row g-3" modelAttribute="department">
            <form:hidden path="departmentId"/>
            <div class="col-12 mt-5">
                <form:label path="departmentName" cssClass="form-label fw-bold">Department</form:label>
                <form:input path="departmentName" cssClass="form-control"/>
                <form:errors path="departmentName" cssClass="text-danger"/>
            </div>
            <div class="col-12 d-grid gap-2">
                <button type="submit" class="btn btn-success">Submit</button>
            </div>
        </form:form>
    </div>
    <div class="container mt-5">
        <c:if test="${!empty departmentList}">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th class="col-6">Department</th>
                        <th class="col-6">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${departmentList}" var="department">
                        <c:url var="editLink" value="/departments/manageDepartment">
                            <c:param name="departmentId" value="${department.departmentId}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/departments/deleteDepartment">
                            <c:param name="departmentId" value="${department.departmentId}"/>
                        </c:url>
                        <tr>
                            <td class="col-6">${department.departmentName}</td>
                            <td class="col-6">
                                <a href="${editLink}" class="link-success">Edit</a>
                                &nbsp;|&nbsp;
                                <a href="${deleteLink}" class="link-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<div class="container mt-3">
    <a href="${pageContext.request.contextPath}/back" class="link-primary fs-4">Back</a>
</div>
</body>
</html>