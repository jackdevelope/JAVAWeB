package bean;

public enum AdminInfor {
    admin("administrator"),
    pass("123456qwe");
    //准备装载器
    private String cursor;
    AdminInfor() {
    }
    //初始数据装菜器
    AdminInfor(String cursor){
        this.cursor=cursor;
    }
    //获取数据
    public String getCursor() {
        return cursor;
    }
}
