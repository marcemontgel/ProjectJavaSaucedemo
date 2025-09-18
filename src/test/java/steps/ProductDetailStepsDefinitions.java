package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ItemDetailPage;
import pages.ShoppingPage;
import utilities.CommonFlows;

public class ProductDetailStepsDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @Given("El usuario detalla el item con nombre {string}")
    public void goToItemDetail(String itemName) {
        commonFlows.goToItemDetail(itemName);
    }

    @Then("El usuario verifica que la UI de la pagina de detalle del producto sea correcta")
    public void verifyItemDetailUI() {
        itemDetailPage.verifyPage();
    }

    @When("El usuario hace clic en el botón Back to Products")
    public void clickBackToProducts() {
        itemDetailPage.clickBackToProducts();
    }

    @Then("El usuario retorna al listado de Productos")
    public void navigateShoppingPage() {
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
