package pojo;

import java.io.Serializable;

public class MyClass implements Serializable {
    private static final long serialVersionUID = -5715760608315054686L;
    private String classname;
    private String sturank;
    private String bzrteacher;
    private String classnotes;
    private String classhumannum;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSturank() {
        return sturank;
    }

    public void setSturank(String sturank) {
        this.sturank = sturank;
    }

    public String getBzrteacher() {
        return bzrteacher;
    }

    public void setBzrteacher(String bzrteacher) {
        this.bzrteacher = bzrteacher;
    }

    public String getClassnotes() {
        return classnotes;
    }

    public void setClassnotes(String classnotes) {
        this.classnotes = classnotes;
    }

    public String getClasshumannum() {
        return classhumannum;
    }

    public void setClasshumannum(String classhumannum) {
        this.classhumannum = classhumannum;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "classname=" + classname +
                ", sturank='" + sturank + '\'' +
                ", bzrteacher='" + bzrteacher + '\'' +
                ", classnotes='" + classnotes + '\'' +
                ", classhumannum='" + classhumannum + '\'' +
                '}';
    }
}
