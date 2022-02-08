import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {"white bun", 123.45F},
                {"black bun", 200},
                {null, 0},
                {" ", -100}
        };

    }

    @Test
    public void getNameTest() {
        String actualName = bun.getName();
        assertEquals("Имя не совпадает", name, actualName);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = bun.getPrice();
        assertEquals("Цена не совпадает", price, actualPrice, 0);

    }

}
