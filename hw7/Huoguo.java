//火锅抽象类
public abstract class Huoguo {

    protected String name;

    public void prepareFoods(){
        System.out.println("准备火锅食材~~~");
    }
    public void plate(){
        System.out.println("摆盘，加干冰~~~");
    }
    public void serving(){
        System.out.println("上菜~~~");
    }
}