package bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SetBirthday {
    public Date setMyBirthday(String birthday){
        java.util.Date mybirthday=null;
        Date rebirthday=null;
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            mybirthday = (java.util.Date) simpleDateFormat.parse(birthday);
            rebirthday= new Date(mybirthday.getTime());
            return rebirthday;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rebirthday;
    }
}
