package pages;

import modelos.ItemProducto;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.BasePage;
import utilities.Logs;

import java.util.List;

public class ShoppingPage extends BasePage {

    private final By productTitle = By.xpath("//span[text()='Products']");
    private final By inventoryList = By.className("inventory_list");
    private final By selectItemContainer = By.cssSelector("select[data-test='product-sort-container']");


    private By getItemName(String itemName) {
        final var xpath = String.format("//div[text()='%s']", itemName);
        return By.xpath(xpath);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(inventoryList, this.getClass().getSimpleName());

    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando Cargue de la Pagina de Shopping");

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(productTitle).isDisplayed()),
                () -> Assertions.assertTrue(find(inventoryList).isDisplayed()),
                () -> Assertions.assertTrue(find(selectItemContainer).isDisplayed())
        );
    }

    public void goToItemDetail(String itemName) {
        Logs.info("Navegando al detalle del item: %s", itemName);
        find(getItemName(itemName)).click();
    }

    private By getProductPrice(String itemName) {
        return RelativeLocator
                .with(By.className("inventory_item_price"))
                .below(getItemName(itemName));

    }

    public void verifyProductPrice(List<ItemProducto> listItems) {
        Logs.info("Verificando el precio de los productos");

        Assertions.assertAll(
                listItems.stream().map(item -> () -> {
                    final var priceLabel = find(getProductPrice(item.getNombre()));
                    final var price = Double.parseDouble(
                            priceLabel.getText().replace("$", "")
                    );

                    // Convertir cualquier tipo a String y luego a Double
                    String precioStr = item.getPrecio().toString().replace(",", ".");
                    double expectedPrice = Double.parseDouble(precioStr);

                    Assertions.assertEquals(
                            price,
                            expectedPrice,
                            0.001, // delta para comparaciones de punto flotante
                            String.format("fallo: %s", item.getNombre())
                    );
                })
        );
    }

}
