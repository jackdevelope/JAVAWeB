package servlet;

import com.alibaba.fastjson.JSONObject;
import dao.CheckAdmin;
import dao.EditUserDao;
import dao.UserLoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditeloginServlet",urlPatterns = "/editelogin")
public class EditeLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String user_id = request.getParameter("user_id");
        String username = request.getParameter("username");
        String origpassword = request.getParameter("origpassword");
        String newpassword = request.getParameter("newpassword");
        //System.out.println(username+origpassword+newpassword);
        //初始化Dao层
        EditUserDao editUserDao = new EditUserDao();
        int editmark = editUserDao.EditLogin(username, origpassword, newpassword);
        //初始化封装容器
        JSONObject newulogin=new JSONObject();
        newulogin.put("editlogin",editmark);
        newulogin.put("username",username);
        //进行数据返回
        response.getWriter().write(newulogin.toString());
        /*JSONObject myuserinfor=new JSONObject();
        myuserinfor.put("username",username);
        myuserinfor.put("origpassword",origpassword);
        myuserinfor.put("newpassword",newpassword);
        PrintWriter out = response.getWriter();
        out.print(myuserinfor);*/
        //request.setAttribute("myuserinfor",myuserinfor);
        /*
        String adminname = request.getParameter("adminname");
        String studentname = request.getParameter("studentname");
        String newemail = request.getParameter("newemail");
        CheckAdmin checkAdmin = new CheckAdmin();
        int key0 = checkAdmin.adminCheck(adminname);
        if (key0>0){
            EditUserDao editUserDao = new EditUserDao();
            int key1 = editUserDao.EditStudentInfor(studentname, newemail);
            if (key1>0){  response.sendRedirect("index.jsp");}
            else { response.sendRedirect("error/inforerror.jsp");}
        }else {
            response.sendRedirect("oper/alertinfor.jsp");
        }
        /*
        System.out.println(adminname);
        System.out.println(username);
        System.out.println(orginpassword);
        System.out.println(newpass);
        System.out.println("successfull!!!");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
    }
}
