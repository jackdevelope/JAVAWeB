package pojo;


import java.io.Serializable;
import java.sql.Date;

public class Studentinfor implements Serializable {
    private static final long serialVersionUID = 5975119550378824635L;
    private int roleId;
    private int studentid;
    private String studentname;
    private String sex;
    private Date birthday;
    private String email;
    private String remark;
    private String classname;
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Studentinfor{" +
                "roleId=" + roleId +
                ", studentid=" + studentid +
                ", studentname='" + studentname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
