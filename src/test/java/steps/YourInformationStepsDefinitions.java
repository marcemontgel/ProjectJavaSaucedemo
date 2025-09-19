package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.YourInformationPage;
import utilities.CommonFlows;

public class YourInformationStepsDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final YourInformationPage yourInformationPage = new YourInformationPage();

    @Given("El usuario navega a la pagina para ingresar su informacion")
    public void goToInformationPage() {
        commonFlows.goYourInformationPage();
    }

    @When("El usuario ingresa nombre {string} apellido {string} zipcode {string} y da clic en Continue")
    public void fillUserInfo(String name, String lastName, String zipcode) {
        yourInformationPage.fillDataCheckOut(name, lastName, zipcode);
    }

    @Then("Mostrar el mensaje de error indicado {string}")
    public void ShowMessageError(String errorMessage) {
        yourInformationPage.verifyErrorMessage(errorMessage);
    }
}
