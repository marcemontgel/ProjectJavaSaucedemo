package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ShoppingPage;
import utilities.CommonFlows;

public class ShoppingStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @Given("El usuario ingresa con credenciales validas a la pagina de Inventario")
    public void goToShoppingPage() {
        commonFlows.goToShoppingPage();
    }

    @Then("El usuario verifica que la pagina de Productos cargue de manera correcta")
    public void verifyUIShoppingPage() {
        shoppingPage.verifyPage();
    }
}
