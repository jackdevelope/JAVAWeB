<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/7
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class Manager</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/myclass" method="post">
    修改人(你必须是老师):<input id="bzrteacher" name="bzrteacher"></br>
    <input type="submit" value="sub">
</form>
</body>
</html>

