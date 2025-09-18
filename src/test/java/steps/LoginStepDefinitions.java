package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.CommonFlows;

public class LoginStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final LoginPage loginPage = new LoginPage();

    @Given("El usuario navega a la pagina de login")
    public void goToLoginPage() {
        commonFlows.goToLoginPage();
    }

    @When("El usuario escribe las credenciales {string} con password {string}")
    public void fillLoginForm(String username, String password) {
        loginPage.fillLogin(username, password);
    }

    @Then("Mostrar mensaje de error segun el caso: {string}")
    public void verifyMessageTextError(String textErrorInvalid) {
        loginPage.verifyMessageTextError(textErrorInvalid);
    }

    @Then("El usuario verifica que la UI de la pagina de login sea")
    public void verifyUILogin() {
        loginPage.verifyPage();
    }
}
