package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import pages.MenuBurger;
import utilities.CommonFlows;

public class BurgerMenuStepsDefinitions {

    private static final Logger log = LoggerFactory.getLogger(BurgerMenuStepsDefinitions.class);
    private final CommonFlows commonFlows = new CommonFlows();
    private final MenuBurger menuBurger = new MenuBurger();
    private final LoginPage loginPage = new LoginPage();

    @Given("El usuario ingresa correctamente y abre el burguer menu")
    public void openBurgerMenu() {
        commonFlows.openBurgerMenu();

    }

    @When("El usuario hace click en la opción de Log Out")
    public void clickLogoutOption() {
        menuBurger.clickButtonLogout();

    }

    @Then("El usuario es redirigido a la pagina de login")
    public void verifyLoginPage() {
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Then("El usuario verifica que la opcion About relacione el enlace correcto {string}")
    public void verifyAboutLink(String aboutUrl) {
        menuBurger.verifyAboutLink(aboutUrl);
    }
}
