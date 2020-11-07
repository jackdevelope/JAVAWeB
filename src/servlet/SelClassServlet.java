package servlet;

import com.alibaba.fastjson.JSONObject;
import dao.SelectClassDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterClassServlet",urlPatterns = "/myclass")
public class SelClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bzrteacher = request.getParameter("bzrteacher");
        SelectClassDao alterClassDao = new SelectClassDao();
        JSONObject sel = alterClassDao.sel(bzrteacher);
        request.setAttribute("myclassInfor",sel);
        System.out.println(sel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/myclass/editinformyclass.jsp");
        dispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             this.doPost(request, response);
    }
}
