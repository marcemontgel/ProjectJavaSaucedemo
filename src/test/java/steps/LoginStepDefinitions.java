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

    @Then("Para usuario invalido debe mostrar {string}")
    public void verifyMessageErrorUserInvalid(String textErrorInvalid) {
        loginPage.verifyMessageErrorUserInvalid(textErrorInvalid);
    }

    @Then("Para usuario no existente debe mostrar {string}")
    public void verifyErrorMessageNotExist(String textErrorNotExist) {
        loginPage.verifyMessageErrorUserNotExist(textErrorNotExist);
    }

    @Then("El usuario verifica que la UI de la pagina de login sea")
    public void verifyUILogin() {
        loginPage.verifyPage();
    }
}
