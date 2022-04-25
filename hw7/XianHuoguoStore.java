/**
 * 火锅西安分店
 */
public class XianHuoguoStore extends HuoguoStore{
    @Override
    public Huoguo createHuoguo(String type) {

        Huoguo huoguo = null;

        if("肥牛".equals(type)){
            huoguo = new BeefHuoguo();
        }
        else if("肥羊".equals(type)){
            huoguo = new MuttonHuoguo();
        }
        return huoguo;
    }
}