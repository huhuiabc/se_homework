/**
 * 火锅店总店，其作为一个抽象类
 */
public abstract class HuoguoStore {
    public abstract Huoguo createHuoguo(String type);

    //根据客人要求提供不同类型的火锅
    public Huoguo provideHuoguo(String type) {

        Huoguo huoguo = createHuoguo(type);

        {
            huoguo.prepareFoods();
            huoguo.plate();
            huoguo.serving();
        }

        return huoguo;
    }
}