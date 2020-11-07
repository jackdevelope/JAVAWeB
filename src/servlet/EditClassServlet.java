package servlet;

import com.alibaba.fastjson.JSONObject;
import dao.EditClassDao;
import dao.SelClassDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditClassServlet",urlPatterns = "/editclass")
public class EditClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String classnotes = request.getParameter("classnotes");
        String classnum = request.getParameter("classnum");
        String bzrteacher = request.getParameter("bzrteacher");
        String sturank = request.getParameter("sturank");
        EditClassDao editClassDao = new EditClassDao();
        int editclass = editClassDao.editclass(classnotes, classnum, bzrteacher,sturank);
        if (editclass>0){
            SelClassDao selClassDao = new SelClassDao();
            JSONObject selclass = selClassDao.selclass(bzrteacher);
            request.setAttribute("classinfor",selclass);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myclass/removemyclass.jsp");
            dispatcher.forward(request, response);
        }else {
            System.out.println("修改失败!!!!!!");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request, response);
    }
}
