package bean;

import java.util.Calendar;

public class StudentRoleId {
    public int myStudentId(int count,String name){
        System.out.println(count+name);
        //生成学号容器
        StringBuilder stringBuilder=new StringBuilder();
        //生成年
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        System.out.println(year);
        //生成编号
        int myc=Math.abs(count);
        System.out.println(myc);
        //生成班级编号
        int myclass = Math.abs(name.hashCode());
        System.out.println(myclass);
        stringBuilder.append(year);
        stringBuilder.append(myc);
        stringBuilder.append(myclass);
        String middle = stringBuilder.toString();
        int result = Integer.parseInt(middle);
        return result;
    }
}
