<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>my login</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script>
    $(function () { $('.tooltip-show').tooltip('If You are Student,you can choose Student');});
    </script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<center>
    <div align="center">
        <caption align="center">My Register</caption>
    </div>
    <form action="${pageContext.request.contextPath}/userregiest"  method="post" class="form-group" role="form">
        <div class="form-group" align="center">
            username:
            <input id="name" name="name" type="text"
                   placeholder="PLease Input your username" size="23">
        </div>
        <div class="form-group" align="center">
            password:
            <input id="password" name="password" type="password"
                   placeholder="PLease Input your password" size="23">
        </div>
        <div class="form-group">
            Job:
            <input id="job" name="job" class="tooltip-show" data-toggle="tooltip" title="If You are Student,you can choose Student" placeholder="PLease Input Your position" type="text" value="student" readonly>
        </div>
        <div class="form-group" align="center">
            <button type="submit" class="btn bg-success">注册</button>&nbsp;
            <button type="reset" class="btn bg-warning">重置</button>
        </div>
    </form>
</center>
</body>
</html>