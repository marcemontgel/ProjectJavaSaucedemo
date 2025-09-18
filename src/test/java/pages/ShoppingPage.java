package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

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
}
