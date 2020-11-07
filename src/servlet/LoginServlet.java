package servlet;

import bean.AdminInfor;
import bean.CookChoose;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dao.SelectMyUserDao;
import pojo.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static bean.AdminInfor.admin;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private int lifetime = 60 * 60 * 24 * 30;// 设置cookie的生存时间为一个月(秒*分*时*天)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //System.out.println("sucessful!!!");
        //初始化装载容器
        JSONObject loginInform = null;
        //0.使用枚举调用管理员账户
        AdminInfor admin = AdminInfor.admin;
        AdminInfor pass = AdminInfor.pass;
        String adminCursor = admin.getCursor();
        String passCursor = pass.getCursor();
        //System.out.println(adminCursor+passCursor);
        //获取用户参数
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        //空值判断
        if (username == "" && userpass == "") {
            request.setAttribute("username", loginInform);
            request.setAttribute("password", loginInform);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/user/userlogin.jsp");
            dispatcher.forward(request, response);
        } else {
            //角色判断
            if (username.equals(adminCursor) && userpass.equals(passCursor)) {
                //收集参数返回到管理员界面
                System.out.println("管理员成功登录!!!!!");
                //收集参数返回到管理员界面
                request.setAttribute("adminname", adminCursor);
                request.setAttribute("adminpass", passCursor);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/main/adminmain.jsp");
                dispatcher.forward(request, response);
            } else {
                //System.out.println("cookie用户登录!!!!");
                //判断是否使用cookie,是则取出，不是查询数据库并返回到前台
                String[] isUseCookies = request.getParameterValues("isUseCookies");
                if (isUseCookies != null && isUseCookies.length > 0) {
                    System.out.println("数据库用户登录!并进行cookie记录!!!");
                    Cookie usercookie = new Cookie("username", username);
                    Cookie passwordcookie = new Cookie("password", userpass);
                    usercookie.setMaxAge(lifetime);
                    passwordcookie.setMaxAge(lifetime);
                    //调用Dao层获取查询结果
                    SelectMyUserDao selectAllUserDao = new SelectMyUserDao();
                    loginInform = selectAllUserDao.muLogin(username, userpass);
                    //收集参数返回到用户界面
                    request.setAttribute("loginInform", loginInform);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/main/usermain.jsp");
                    dispatcher.forward(request, response);
                } else {
                    System.out.println("数据库用户登录!!!!");
                    //调用Dao层获取查询结果
                    SelectMyUserDao selectAllUserDao = new SelectMyUserDao();
                    loginInform = selectAllUserDao.muLogin(username, userpass);
                    //收集参数返回到用户界面
                    request.setAttribute("loginInform", loginInform);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/main/usermain.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               this.doPost(request, response);
    }
}