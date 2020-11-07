package bean;

public enum RoleName {
    stu("student");
    //准备装载器
    private String cursor;
    RoleName() {
    }
    //初始数据装菜器
    RoleName(String cursor){
        this.cursor=cursor;
    }
    //获取数据
    public String getCursor() {
        return cursor;
    }
}
