package bean;

import java.util.Calendar;

public class StuYear {
    public int myStuId(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }
}
