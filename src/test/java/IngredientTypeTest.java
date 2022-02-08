import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void getIngredientTypeTest() {

        IngredientType sauce = IngredientType.SAUCE;
        IngredientType filling = IngredientType.FILLING;

        String expectedSauces = "SAUCE\n" + "FILLING";
        String actualSauce = sauce.name() + "\n" + filling.name();

        assertEquals("Типы ингредиентов не совпадают!", expectedSauces, actualSauce);

    }
}
