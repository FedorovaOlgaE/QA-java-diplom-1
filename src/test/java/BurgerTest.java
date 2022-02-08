import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }


    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertNotNull("Что-то не так с добавлением ингредиентов", burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Длина списка не совпадает", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name1", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name2", 100));
        burger.moveIngredient(0, 1);
        assertEquals("Имя ингредиента не совпадает", "name1", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        float price = 100;
        float expectedPrice = price * 2 + price;
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals("Расчитаная цена не совпадает", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        float bunPrice = 100f;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        String bunName = "black bun";
        Mockito.when(bun.getName()).thenReturn(bunName);

        float ingredientPrice = 100f;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        String ingredientName = "cutlet";
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);

        IngredientType expectedIngredientType = IngredientType.FILLING;
        Mockito.when(ingredient.getType()).thenReturn(expectedIngredientType);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();

        String expectedReceipt = String.format("(==== black bun ====)%n= filling cutlet =%n(==== black bun ====)%n%nPrice: 300,000000%n");

        assertEquals("Квитанция не совпадает", expectedReceipt, actualReceipt);

    }

}
