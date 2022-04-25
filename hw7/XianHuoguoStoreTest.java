import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XianHuoguoStoreTest {

    @Test
    void createHuoguo() {
        HuoguoStore xianstore = new XianHuoguoStore();
        xianstore.provideHuoguo("肥羊");
    }
}