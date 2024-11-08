<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Role Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type=" text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
<div class="container mt-5 border border-1">
    <div class="container">
        <div class="fs-1">
            <h1 class="fw-bolder">Manage Role</h1>
        </div>
        <form:form action="/roles/saveRole" method="post" cssClass="row g-3" modelAttribute="role">
            <form:hidden path="roleId"/>
            <div class="col-12 mt-5">
                <form:label path="roleType" cssClass="form-label fw-bold">Role</form:label>
                <form:input path="roleType" cssClass="form-control"/>
                <form:errors path="roleType" cssClass="text-danger"/>
            </div>
            <div class="col-12 d-grid gap-2">
                <button type="submit" class="btn btn-success">Submit</button>
            </div>
        </form:form>
    </div>
    <div class="container mt-5">
        <c:if test="${!empty roleList}">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th class="col-6 fw-bold">Role</th>
                        <th class="col-6 fw-bold">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${roleList}" var="role">
                        <c:url var="editLink" value="/roles/manageRole">
                            <c:param name="roleId" value="${role.roleId}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/roles/deleteRole">
                            <c:param name="roleId" value="${role.roleId}"/>
                        </c:url>
                        <tr>
                            <td class="col-6">${role.roleType}</td>
                            <td>
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
<div class="container mt-5">
    <a href="${pageContext.request.contextPath}/back" class="link-success fs-4">Back</a>
</div>
</body>
</html>