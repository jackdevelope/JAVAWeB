package servlet;

import com.alibaba.fastjson.JSONObject;
import dao.SelectMyUserDao;
import pojo.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentloginServlet",urlPatterns = "/student")
public class StudentloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String stuusername = request.getParameter("stuusername");
        String stuuserpass = request.getParameter("stuuserpass");
        System.out.println(stuusername+stuuserpass);
        //2.获取Dao层
        SelectMyUserDao selectMyUserDao = new SelectMyUserDao();
        JSONObject jsonObject = selectMyUserDao.muLogin(stuusername, stuuserpass);
        if (jsonObject.size()!=0){
          //取出相应的ID,返回到学生注册前台
          request.setAttribute("mylogin",jsonObject.getString("login"));
          RequestDispatcher dispatcher = request.getRequestDispatcher("student/studentRegister.jsp");
          dispatcher.forward(request, response);
        }else {
          //装入空ID返回到首页,无权进入到学生模块
          request.setAttribute("mylogin",jsonObject.getString("login"));
          RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
          dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
