package bean;

public class RoleId {
    public int myUserId(){
        long init = System.currentTimeMillis();
        int result = Math.abs((int) Math.abs(init));
       // System.out.println(result);
        return result;
    }
}
