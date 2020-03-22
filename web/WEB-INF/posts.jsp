<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guest posts</title>
</head>
<body>
        <table border="3">
            <c:forEach items="${requestScope.posts}" var="post">
            <tr>
                <td>${post.id}</td>
                <td><c:out value="${post.name}"/></td>
                <td><c:out value="${post.surname}"/></td>
                <td>
                    <a href="delete?id=${post.id}">
                    <img src="delete.png" alt="delete"/>
                    </a>
                </td>
            </tr>
            </c:forEach>
            <form action="/add" method="post">
            <tr>
                <td colspan="3">
                <input name="name" type="text">
                <input name="surname" type="text">
                </td>
                <td>
                    <input type="submit">
                </td>
            </tr>
            </form>
        </table>
</body>
</html>
