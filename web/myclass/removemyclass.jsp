<%@ page import="com.alibaba.fastjson.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/18
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>remove myclass</title>
</head>
<body>
<%
    String classinfor = request.getAttribute("classinfor").toString();
    JSONObject result = JSONObject.parseObject(classinfor);
    String classname = result.getString("classname");
    String sturank = result.getString("sturank");
    String bzrteacher = result.getString("bzrteacher");
    String classnotes = result.getString("classnotes");
    String classnum = result.getString("classnum");
    System.out.println(classinfor);
%>
<form action="${pageContext.request.contextPath}/remclass" method="post">
    <center>
     <table align="center">
                    <tr align="center">
                        <th colspan="2" align="center"><center>Class Information</center></th>
                    </tr>
                    <tr>
                        <td><label>班级名:</label></td>
                        <td><input type="text" id="studentid" name="studentid" class="form-control" value="<%=classname%>"></td>
                    </tr>
                    <tr>
                        <td><label>年级</label></td>
                        <td><input type="text" id="sturank" name="sturank" class="form-control" value="<%=sturank%>"></td>
                    </tr>
                    <tr>
                        <td><label>按主任:</label></td>
                        <td><input type="text" id="bzrteacher" name="bzrteacher" class="form-control" value="<%=bzrteacher%>" readonly></td>
                    </tr>
                    <tr>
                        <td><label>班级口号:</label></td>
                        <td><input id="classnotes" name="classnotes" class="form-control" value="<%=classnotes%>" readonly/></td>
                    </tr>
                    <tr>
                        <td><label>班级人数:</label></td>
                        <td><input type="text" id="classhumannum" name="classhumannum" class="form-control" value="<%=classnum%>" readonly></td>
                    </tr>
                    <tr align="center">
                        <td height="41" colspan="2"><button type="button" class="btn btn-success" data-dismiss="modal" value="返回" onClick="finish()">删除</button></td>
                    </tr>
                </table>
            <!--附加信息-->
            <div class="modal-footer" align="left"><p style="text-align:center;">Jack@publish</p></div>
    </center>
        </form>
</body>
</html>
