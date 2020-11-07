<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Main</title>
    <meta charset="utf-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>用户列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <title>学生信息</title>
    <style type="text/css">
    </style>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#shai").keyup(function(){
                $("table tbody tr").hide().filter(":contains('"+($(this).val())+"')").show();
            });keyup();//这句一定要有。
        })
    </script>
</head>
<body>
<%
    ArrayList userRegisters=(ArrayList)request.getAttribute("userRegisters");
%>
<form>
    请输入你的查询信息:
    <input id="shai" align="right" type="text" class="form-control-static" placeholder="Search">
</form>
<table align="center">
    <tr align="center">
        <th align="center">All Student Information</th>
    </tr>
    <tr>
        <td>studentid</td>
        <td>studentname</td>
        <td>sex</td>
        <td>birthday</td>
        <td>remark</td>
        <td>email</td>
    </tr>
    <!--
    <c:forEach items="<%=userRegisters%>" var="list">
        <tr>
            <td>${list.studentid}</td>
            <td>${list.studentname}</td>
            <td>${list.sex}</td>
            <td>${list.birthday}</td>
            <td>${list. remark}</td>
            <td>${list.email}</td>
        </tr>
    </c:forEach>
   -->
</table>
</body>
</html>
