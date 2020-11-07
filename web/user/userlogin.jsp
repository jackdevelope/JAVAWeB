<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>my login</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<center>
    <div align="center">
        <caption align="center">My Login</caption>
    </div>
    <form id="form1" action="${pageContext.request.contextPath}/login" method="post" class="form-group" role="form">
        <div class="form-group" align="center">
            username:
            <input type="text" id="username" name="username"
                   placeholder="PLease Input your username" size="23">
        </div>
        <div class="form-group" align="center">
            password:
            <input type="password" id="userpass" name="userpass"
                   placeholder="PLease Input your password" size="23">
        </div>
        <div class="form-group">
            <div class="checkbox" align="center">
                <label>
                    <input id="isUseCookies" name="isUseCookies" type="checkbox" checked="checked"/>请记住我
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="../user/userLoginRegist.jsp">用户注册</a>
                </label>
            </div>
        </div>
        <div class="form-group" align="center">
            <button type="submit" class="btn bg-success">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn bg-warning">重置</button>
        </div>
    </form>
</center>
</body>
</html>
