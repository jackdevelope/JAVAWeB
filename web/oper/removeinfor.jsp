<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Remove User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="../js/bootstrap.js"></script>
</head>
<body>
<center>
    <h1 align="center">删除信息</h1>
    <form id="form" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/restu" method="post">
        <div class="form-group" align="center">
            <label class="col-sm-4 control-label">管理员名:</label>
            <div class="col-sm-4">
                <input id="adminname" name="adminname" type="text" class="form-control"  placeholder="Admin Name" size="25">
            </div>
        </div>
        <div class="form-group" align="center">
            <label class="col-sm-4 control-label">所删除的学生姓名:</label>
            <div class="col-sm-4">
                <input id="studentname" name="studentname" type="text" class="form-control"  placeholder="user Name" size="25">
            </div>
        </div>
        <div align="center">
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </div>
    </form>
</center>
</body>
</html>

