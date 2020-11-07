<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Student Register</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script>
      function finish() {
       window.location.href="${pageContext.request.contextPath}/index.jsp"
      }
    </script>
    <script src="../js/bootstrap.js"></script>
    <style type="text/css">
     #container{
      width:400px;
      height:110px;
      border:1px solid black;
     }
     .content{
      width:100px;
      margin: 0 auto;
     }
     .content div{
      width:100px;
      height:100px;
      float:left;
     }
    </style>
</head>
<body>
<%
    String mystu = request.getAttribute("mystu").toString();
    String myclass = request.getAttribute("myclass").toString();
    JSONObject student = JSONObject.parseObject(mystu);
    JSONObject myclass0 = JSONObject.parseObject(myclass);
    JSONObject stu = (JSONObject) student.get("stu");
    JSONObject myclass1 = (JSONObject) myclass0.get("class");
    String roleId = stu.getString("roleId");
    String studentid = stu.getString("studentid");
    String studentname = stu.getString("studentname");
    String sex = stu.getString("sex");
    String birthday = stu.getString("birthday");
    String email = stu.getString("email");
    String remark = stu.getString("remark");
    System.out.println(remark);
    //获取班级信息
    String classname = stu.getString("classname");//班级名
    String sturank = myclass1.getString("sturank");//年级
    String bzrteacher = myclass1.getString("bzrteacher");//班主任
    String classnotes = myclass1.getString("classnotes");//班级口号
    String classhumannum = myclass1.getString("classhumannum");//班级人数
    System.out.println(classnotes);
%>
<center>
        <form>
            <fieldset>
                <table align="center">
                    <tr align="center">
                            <th colspan="2" align="center"><center>Student Information</center></th>
                    </tr>
                    <tr>
                        <td><label>用户ID:</label></td>
                        <td><input type="text" id="roleId" name="roleId" class="form-control" value="<%=roleId%>" readonly></td>
                    </tr>
                    <tr>
                        <td><label>姓名:</label></td>
                        <td><input type="text" id="name" name="name" class="form-control" value="<%=studentname%>" readonly></td>
                    </tr>
                    <tr>
                        <td><label>性别:</label></td>
                        <td><input id="boy" name="sex" type="text" value="<%=sex%>" readonly></td>
                    </tr>
                    <tr>
                        <td><label>生日:</label></td>
                        <td><input type="date" id="birthday" name="birthday" value="<%=birthday%>" class="form-control" readonly></td>
                    </tr>
                    <tr>
                        <td><label>email:</label></td>
                        <td><input type="email" id="email" name="email" value="<%=email%>" class="form-control" readonly></td>
                    </tr>
                    <tr>
                        <td><label>remark:</label></td>
                        <td><input id="remark" name="remark" value="<%=remark%>" class="form-control" readonly/></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <table align="center">
                    <tr align="center">
                        <th colspan="2" align="center"><center>Class Information</center></th>
                    </tr>
                    <tr>
                      <td><label>学号:</label></td>
                      <td><input type="text" id="studentid" name="studentid" class="form-control" value="<%=studentid%>"></td>
                    </tr>
                    <tr>
                      <td><label>学生姓名:</label></td>
                      <td><input type="text" id="studentname" name="studentname" class="form-control" value="<%=studentname%>"></td>
                    </tr>
                    <tr>
                        <td><label>年级</label></td>
                        <td><input type="text" id="sturank" name="sturank" class="form-control" value="<%=sturank%>"></td>
                    </tr>
                    <tr>
                        <td><label>班级名:</label></td>
                        <td><input type="text" id="classname" name="classname" class="form-control" value="<%=classname%>" readonly></td>
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
                        <td><input type="text" id="classhumannum" name="classhumannum" class="form-control" value="<%=classhumannum%>" readonly></td>
                    </tr>
                    <tr align="center">
                      <td height="41" colspan="2"><button type="button" class="btn btn-success" data-dismiss="modal" value="返回" onClick="finish()">返回</button></td>
                    </tr>
                </table>
            </fieldset>
            <!--附加信息-->
            <div class="modal-footer" align="left"><p style="text-align:center;">Jack@publish</p></div>
        </form>
</center>
</body>
</html>

