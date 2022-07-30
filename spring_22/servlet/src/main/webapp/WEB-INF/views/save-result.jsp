<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공!
<ul>
<%--    <li>id=<%=((Member)(request.getAttribute("member"))).getId()%></li>   이런식으로 되나 귀찮... --%>
    <%-- get 프로퍼티 접근법.  Attribute의 키로 접근--%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
</body>
</html>
