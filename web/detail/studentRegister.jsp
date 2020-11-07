<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/28
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Student Register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="../js/bootstrap.js"></script>
  </head>
  <body>
  <%
    String roleId = request.getParameter("roleId");
    String username = request.getParameter("username");
  %>
    <form action="${pageContext.request.contextPath}/studentReg" method="post">
      <fieldset>
        <table align="center">
          <td align="center">
            <th align="center">Student Information</th>
          </td>
          <tr>
            <td><label>用户ID:</label></td>
            <td><input type="text" id="roleId" name="roleId" class="form-control" value="<%=roleId%>" readonly></td>
          </tr>
          <tr>
            <td><label>姓名:</label></td>
            <td><input type="text" id="studentname" name="studentname" class="form-control" value="<%=username%>" readonly></td>
          </tr>
          <tr>
            <td><label>性别:</label></td>
            <td>
              男:<input id="boy" name="sex" type="radio" value="boy">
              女:<input id="girl" name="sex" type="radio" value="girl" >
            </td>
          </tr>
          <tr>
            <td><label>生日:</label></td>
            <td><input type="date" id="birthday" name="birthday" class="form-control"></td>
          </tr>
          <tr>
            <td><label>email:</label></td>
            <td><input type="email" id="email" name="email" class="form-control"></td>
          </tr>
          <tr>
            <td><label>remark:</label></td>
            <td><input id="remark" name="remark" class="form-control"/></td>
          </tr>
        </table>
      </fieldset>
      <fieldset>
        <table align="center">
          <td align="center">
          <th>Class Information</th>
          </td>
          <tr>
            <td><label>班级名:</label></td>
            <td><input type="text" id="classname" name="classname" class="form-control"></td>
          </tr>
          <tr>
            <td><label>年级:</label></td>
            <td><input type="text" id="sturank" name="sturank" class="form-control"></td>
          </tr>
          <tr>
            <td><label>班主任:</label></td>
            <td><input type="text" id="bzrteacher" name="bzrteacher" class="form-control"></td>
          </tr>
          <tr>
            <td><label>班级口号:</label></td>
            <td><input id="classnotes" name="classnotes" class="form-control"/></td>
          </tr>
          <tr>
            <td><label>班级人数:</label></td>
            <td><input type="text" id="classhumannum" name="classhumannum" class="form-control"></td>
          </tr>
          <tr align="center">
            <td><button type="submit" class="btn btn-success" data-dismiss="modal"><span class="" aria-hidden="true"></span>注册</button></td>
            <td><button type="reset" id="btn_submit" class="btn bg-warning" data-dismiss="modal"><span class="" aria-hidden="true"></span>重置</button></td>
          </tr>
        </table>
      </fieldset>
      <!--附加信息-->
      <div class="modal-footer" align="left"><p style="text-align:center;">Jack@publish</p></div>
    </form>
</body>
</html>
