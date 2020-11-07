package filter;

import com.alibaba.fastjson.JSONObject;
import dao.SelectMyUserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/user/userlogin.jsp")
public class LoginFiler implements Filter {
    public LoginFiler(){
    }
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    //0.初始化装载容器
     String username = null;
     String userpass= null;
     JSONObject loginInform =null;
    //1.request和response类型转换
     HttpServletRequest request1=(HttpServletRequest)request;
     HttpServletResponse response1=(HttpServletResponse)response;
    //2.cookie检验进行免登录
     Cookie[] cookies = request1.getCookies();
     //查看浏览器中是否有cookie
     if (cookies!=null&&cookies.length>0) {
      username = cookies[0].getValue();
      userpass = cookies[1].getValue();
      System.out.println(username+userpass);
      //调用Dao层获取查询结果
      SelectMyUserDao selectAllUserDao = new SelectMyUserDao();
      loginInform = selectAllUserDao.muLogin(username, userpass);
      //收集参数返回到用户界面
      request1.setAttribute("loginInform", loginInform);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/main/usermain.jsp");
      dispatcher.forward(request, response);
     } else {
       response1.sendRedirect(request1.getContextPath()+"/user/userlogin.jsp");
     }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
