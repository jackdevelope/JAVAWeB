package servlet;

import bean.AdminInfor;
import bean.RoleId;
import bean.StudentRoleId;
import com.alibaba.fastjson.JSONObject;
import dao.LoginDao;
import pojo.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/userregiest")
public class LoginRegisterServlet extends HttpServlet {
    //用户id生成路径
    private final static String studentidpath="bean.StudentRoleId";
    //初始化角色ID
    int myId=0;
    //设置cookie的生存时间为一个月(秒*分*时*天)
    private int lifetime = 60 * 60 * 24 * 30;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            //0.获取参数
            String username = request.getParameter("name");
            String password = request.getParameter("password");
            String rolename = request.getParameter("job");
            //1.使用枚举调用管理员账户
            AdminInfor admin = AdminInfor.admin;
            AdminInfor pass = AdminInfor.pass;
            String adminCursor = admin.getCursor();
            String passCursor = pass.getCursor();
          if (username.equals(adminCursor)&&password.equals(passCursor)){
            //初始化application
            ServletContext application=this.getServletContext();
            //设置Application属性
            application.setAttribute("adminname",adminCursor);
            application.setAttribute("adminpass",passCursor);
             //跳转到接收页面
            response.sendRedirect("./user/userlogin.jsp");
          }else {
              //初始化id
              RoleId roleId = new RoleId();
              myId = roleId.myUserId();
              //初始化实体类
              Login login=new Login();
              login.setUsername(username);
              login.setPassword(password);
              login.setRolename(rolename);
              login.setRoleId(myId);
              //装载数据库
              LoginDao loginDao = new LoginDao();
              int addlogin = loginDao.addlogin(username, password, rolename,login.getRoleId());
             // System.out.println(addlogin);
              if (addlogin==0){
                System.out.println("注册失败!!!");
                //跳转到接收页面
                response.sendRedirect("./user/userLoginRegist.jsp");
              } else {
                System.out.println("注册成功!!!");
                //数据库信息储存
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("mylogin",login);
                request.setAttribute("loginInform",jsonObject);
                //跳转页面
                RequestDispatcher dispatcher = request.getRequestDispatcher("main/usermain.jsp");
                dispatcher.forward(request, response);
              }
              /*
                StudentRoleId studentRoleId = (StudentRoleId) Class.forName(studentidpath).getDeclaredConstructor().newInstance();
                int studentid = studentRoleId.myStudentId(count, name);
                System.out.println(studentid);
                //3.初始化实体类
                RequestDispatcher dispatcher = request.getRequestDispatcher("main/usermain.jsp");
                dispatcher.forward(request, response);*/
            }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
