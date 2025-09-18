package steps;

import data.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelos.ItemProducto;
import pages.ShoppingPage;
import utilities.CommonFlows;

import java.util.List;

public class ShoppingStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private List<ItemProducto> listItems;

    @Given("El usuario ingresa con credenciales validas a la pagina de Inventario")
    public void goToShoppingPage() {
        commonFlows.goToShoppingPage();
    }

    @Then("El usuario verifica que la pagina de Productos cargue de manera correcta")
    public void verifyUIShoppingPage() {
        shoppingPage.verifyPage();
    }

    @When("Leo los productos esperados de excel")
    public void readExcelProductsList() {
        listItems = ExcelReader.leerListaItemProductoExcel();
    }

    @Then("Verificando que los productos de Excel sean los mismos que la pagina")
    public void verifyPrices() {
        shoppingPage.verifyProductPrice(listItems);

    }
}
