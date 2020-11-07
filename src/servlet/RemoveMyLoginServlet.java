package servlet;

import com.alibaba.fastjson.JSONObject;
import dao.RemoveMyLoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveMyLoginServlet",urlPatterns = "/remyloser")
public class RemoveMyLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取参数
      String myname = request.getParameter("myname");
      //实例化Dao层
      RemoveMyLoginDao removeMyLoginDao = new RemoveMyLoginDao();
      int rmmark = removeMyLoginDao.rmlogin(myname);
      JSONObject rmmylogin=new JSONObject();
      rmmylogin.put("rmmark",rmmark);
      rmmylogin.put("name",myname);
      //删除数据返回
      response.getWriter().write(rmmylogin.toString());
     System.out.println("successfulll!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
