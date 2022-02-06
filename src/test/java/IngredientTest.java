
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] setIngredient(){
        return new Object[][]{
                {IngredientType.FILLING, "name1", 200},
                {IngredientType.SAUCE, "name2", 500}
        };
    }
    @Test
    public void getTypeIngredientTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        IngredientType expectedType = ingredient.type;
        assertEquals(actualType, expectedType);

    }

    @Test
    public void getNameIngredientTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        String expectedName = ingredient.name;
        assertEquals(actualName, expectedName);
    }

    @Test
    public void getPriceIngredientTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float  actualPrice = ingredient.getPrice();
        float  expectedPrice = ingredient.price;
        assertEquals(actualPrice, expectedPrice, 0);
    }

}
