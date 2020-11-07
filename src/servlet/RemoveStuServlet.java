package servlet;

import dao.CheckAdmin;
import dao.RemoveStudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveStuServlet",urlPatterns = "/restu")
public class RemoveStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        String studentname = request.getParameter("studentname");
        CheckAdmin checkAdmin = new CheckAdmin();
        int key0 = checkAdmin.adminCheck(adminname);
        if (key0>0){
            RemoveStudentDao removeStudentDao = new RemoveStudentDao();
            int key1 = removeStudentDao.removeStudentInfor(studentname);
            if (key1!=0){ response.sendRedirect("index.jsp");}else {response.sendRedirect("oper/removeinfor.jsp");}
            System.out.println(key1);
            System.out.println(key0);
        } else {
            System.out.println(key0);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                               this.doPost(request,response);
    }
}
