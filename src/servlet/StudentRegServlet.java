package servlet;

import bean.SetBirthday;
import bean.StuYear;
import com.alibaba.fastjson.JSONObject;
import dao.ClassRegisterDao;
import dao.StudentRegisterDao;
import pojo.MyClass;
import pojo.Studentinfor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "studentRegServlet",urlPatterns = "/studentReg")
public class StudentRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.获取参数
        //学生信息
        String roleId = request.getParameter("roleId");
        String studentname = request.getParameter("studentname");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String remark = request.getParameter("remark");
        //班级信息
        String classname = request.getParameter("classname");
        String sturank = request.getParameter("sturank");
        String bzrteacher = request.getParameter("bzrteacher");
        String classnotes = request.getParameter("classnotes");
        String classhumannum = request.getParameter("classhumannum");
        //获取入学年份
        StuYear stuYear = new StuYear();
        int year = stuYear.myStuId();
        //生成所属学生ID
        String userID = roleId.substring(roleId.length() -2,roleId.length());   //从个人ID中截取
        String classID= classname.substring(classname.length() -2,classname.length());   //从班级名中截取
        System.out.println(userID);
        String studentid=year+userID+classID;
        System.out.println(studentid);
        //1.初始化pojo容器
        Studentinfor studentinfor = new Studentinfor();
        MyClass myClass = new MyClass();
        //学生装入
        studentinfor.setRoleId(Integer.parseInt(roleId));
        studentinfor.setStudentid(Integer.parseInt(studentid));
        studentinfor.setStudentname(studentname);
        studentinfor.setSex(sex);
        SetBirthday setBirthday = new SetBirthday();
        Date myBirthday = setBirthday.setMyBirthday(birthday);
        studentinfor.setBirthday(myBirthday);
        studentinfor.setEmail(email);
        studentinfor.setRemark(remark);
        studentinfor.setClassname(classname);
        //班级装入
        myClass.setClassname(classname);
        myClass.setSturank(sturank);
        myClass.setBzrteacher(bzrteacher);
        myClass.setClassnotes(classnotes);
        myClass.setClasshumannum(classhumannum);
        //2.实例化学生和班级Dao层,进行多表注册
        //实例化学生Dao层
        StudentRegisterDao studentRegisterDao = new StudentRegisterDao();
        //实例化班级Dao层
        ClassRegisterDao classRegisterDao = new ClassRegisterDao();
        //3.获取各自成功标志值
        //学生
        int result0 = studentRegisterDao.studentReg(studentinfor);
        System.out.println(result0);
        //班级
        int result1 = classRegisterDao.classReg(myClass);
        System.out.println(result1);
        if (result0>0&&result1>0){
          //System.out.println(studentinfor.toString());
          //System.out.println(myClass.toString());
          //准备json进行返回
          JSONObject student=new JSONObject();
          JSONObject myclass=new JSONObject();
          student.put("stu",studentinfor);
          myclass.put("class",myClass);
          request.setAttribute("mystu",student);
          request.setAttribute("myclass",myclass);
          RequestDispatcher dispatcher = request.getRequestDispatcher("/detail/studetail.jsp");
          dispatcher.forward(request, response);
        }else {
          System.out.println("请联系管理员");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                          doPost(request, response);
    }
}
