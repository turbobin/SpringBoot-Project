<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 前端JSP页面中循环取值 -->
<c:forEach items="${list}" var="item" varStatus="status">
    <li>
        <a target="_black">
                ${item}
        </a>
    </li>
</c:forEach>
</body>
</html>
