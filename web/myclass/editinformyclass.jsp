<%@ page import="com.alibaba.fastjson.JSONObject" %><%--


Date: 2020/9/18
Time: 21:11
To MVBM change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>edit my class</title>
</head>
<body>
<%
  String myclassInfor = request.getAttribute("myclassInfor").toString();
  JSONObject myclassInfor0 = JSONObject.parseObject(myclassInfor);
  JSONObject classInfor =(JSONObject)myclassInfor0.get("classInfor");
  //System.out.println(classInfor);
  String studentname = classInfor.getString("studentname");
    String sturank = classInfor.getString("sturank");
    String bzrteacher = classInfor.getString("bzrteacher");//班主任
%>
<center>
  <div align="center">
    <caption align="center">My Edit Form</caption>
  </div>
  <form action="${pageContext.request.contextPath}/editclass" method="post" class="form-group" role="form">
    <div class="form-group" align="center">
      学生姓名:
      <input id="studentname" name="studentname" type="text" size="23" value="<%=studentname%>" readonly>
    </div>
    <div class="form-group" align="center">
      年级:
      <input id="sturank" name="sturank" type="text" size="23" value="<%=sturank%>" readonly>
    </div>
    <div class="form-group">
      班主任:
      <input id="bzrteacher" name="bzrteacher" class="tooltip-show" data-toggle="tooltip" type="text" value="<%=bzrteacher%>" readonly>
    </div>
    <div class="form-group">
      班级口号:
      <input id="classnotes" name="classnotes" class="tooltip-show" data-toggle="tooltip" type="text">
    </div>
    <div class="form-group">
      班级人数:
      <input id="classnum" name="classnum" class="tooltip-show" data-toggle="tooltip" type="text">
    </div>
    <div class="form-group" align="center">
      <button type="submit" class="btn bg-success">注册</button>&nbsp;
      <button type="reset" class="btn bg-warning">重置</button>
    </div>
  </form>
</center>
</body>
</html>
