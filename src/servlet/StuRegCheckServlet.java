package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StuRegCheckServlet", urlPatterns = "/StuRegCh")
public class StuRegCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String roleId = request.getParameter("roleId");
        String username = request.getParameter("username");
        //装载参数
        request.setAttribute("roleId",roleId);
        request.setAttribute("username",username);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/detail/studentRegister.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doPost(request, response);
    }
}
