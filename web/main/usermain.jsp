<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Main</title>
    <meta charset="utf-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>my user information</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheetz" type="text/css" href="http://at.alicdn.com/t/font_1585782_6qlzf8ijeln.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script>
        function ed() {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "http://localhost:8080/webdemo_war_exploded/editelogin",//url
                data: $('#form1').serialize(),
                async: false,
                success: function (data) {
                  //console.log("接口调用成功!!!!")
                  if (data.editlogin!=0){
                    console.log(data.username);
                    document.location.href = "${pageContext.request.contextPath}/index.jsp?newpassword="+escape(data.username)//编码传值
                   // var elementById = document.getElementById("mypass_word");
                    //alert("Successfull!!!!!"+document.getElementById("new_password").val());
                    //$("#myModal").modal('hide');
                  }else {
                     alert("Sorry!!!!Edit fail!!!!");
                  }
                  //document.location.href = "${pageContext.request.contextPath}/center/loginedit.jsp?date="+escape(data)//编码传值
                },
                error: function (request) {
                    alert("Connection Or data error!!!!PLease Connect Administrator!!!!!");
                }
            });
        }
    </script>
    <script>
        function re() {
          var myname=document.getElementById("myuser_name").innerText;
          var url="http://localhost:8080/webdemo_war_exploded/remyloser";
          $.post(url,{"myname":myname},function(data){
              var mylogin = eval("("+data+")");
              alert(mylogin.name+"已删除完毕,将返回主页!!!");
            document.location.href = "${pageContext.request.contextPath}/index.jsp";
          });
        }
    </script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    JSONObject mylogin =JSON.parseObject(request.getAttribute("loginInform").toString());
    JSONObject login =mylogin.getJSONObject("mylogin");
    String roleId=null;
    String username=null;
    String password=null;
    String rolename=null;
   // if (login.size()>0) {
     //   System.out.println("login0" + login);
        roleId = login.getString("roleId");
        username = login.getString("username");
        password = login.getString("password");
        rolename = login.getString("rolename");
   // }
   // else {
       // System.out.println("login1" + login);
   // }
    //System.out.println(rolename+roleId+username+passwoed);
%>
</body>
<center>
<table align="center" class="table table-hover">
    <center><caption align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户信息</caption></center>
    <thead>
    <tr>
        <th>ID</th>
        <th>username</th>
        <th>password</th>
        <th>job</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td id="myuser_id"><%=roleId%></td>
        <td id="myuser_name"><%=username%></td>
        <td id="mypass_word"><%=password%></td>
        <td id="myrole_name"><%=rolename%></td>
        <td><a data-toggle="modal" data-target="#myModal">修改</a> &nbsp;&nbsp;&nbsp;<a onclick="re()">删除</a>&nbsp;&nbsp;&nbsp;<a href=<%=request.getContextPath()+"/StuRegCh?roleId="+roleId+"&&username="+username%>>详细信息注册</a></td>
    </tr>
    </tbody>
</table>
</center>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
                 <div class="modal-content">
                     <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                             ×
                         </button>
                         <h4 class="modal-title" id="myModalLabel">
                             用户信息
                         </h4>
                     </div>
                     <div class="modal-body">
                         <form id="form1" class="form-horizontal" role="form">
                             <div class="form-group">
                                 <label for="user_id" class="col-sm-3 control-label">用户ID</label>
                                 <div class="col-sm-9">
                                     <input id="user_id" name="user_id" type="text" class="form-control"  value="<%=roleId%>"
                                            readonly>
                                 </div>
                             </div>
                             <div class="form-group">
                                 <label  class="col-sm-3 control-label">用户名</label>
                                 <div class="col-sm-9">
                                     <input id="user_name" name="username" type="text" class="form-control"  value="<%=username%>"
                                            placeholder="PLease Input Username">
                                 </div>
                             </div>
                             <div class="form-group">
                                 <label class="col-sm-3 control-label">原密码</label>
                                 <div class="col-sm-9">
                                     <div class="form-text-login nob">
                                         <input id="origpassword" name="origpassword" style="border: none" maxlength="16" type="password" class="form-text" placeholder="PLease Input Original Password" value="<%=password%>"/>
                                         <i class="r loginI iconfont icon-biyanjing" id="togglePassword"></i>
                                     </div>
                                 </div>
                             </div>
                             <div class="form-group">
                                 <label class="col-sm-3 control-label">新密码</label>
                                 <div class="col-sm-9">
                                <input id="new_password" name="newpassword" type="password"  class="form-control" placeholder="PLease Input New Password" />
                                 </div>
                             </div>
                         </form>
                     </div>
                     <div class="modal-footer">
                         <button type="submit" class="btn btn-primary" onclick="ed()">
                             提交
                         </button><span id="tip"> </span>
                         <button type="reset" class="btn btn-default" data-dismiss="modal">
                             关闭
                         </button>
                     </div>
                 </div>
             </div>
</div>
</html>