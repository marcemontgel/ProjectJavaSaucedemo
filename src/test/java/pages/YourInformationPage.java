package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class YourInformationPage extends BasePage {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorLabel = By.cssSelector("h3[data-test='error']");


    @Override
    public void waitPageToLoad() {
        waitPage(firstNameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el formulario para ingresar información");

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(firstNameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(lastNameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(zipCodeInput).isDisplayed()),
                () -> Assertions.assertTrue(find(continueButton).isDisplayed())
        );
    }

    public void fillDataCheckOut(String name, String lastName, String zipcode) {
        if (!name.isEmpty()) {
            Logs.info("Escribir el primer nombre");
            find(firstNameInput).sendKeys(name);
        }
        if (!name.isEmpty()) {
            Logs.info("Escribir el apellido");
            find(lastNameInput).sendKeys(lastName);
        }
        if (!name.isEmpty()) {
            Logs.info("Escribir el zipcode");
            find(zipCodeInput).sendKeys(zipcode);
        }
        Logs.info("Dar clic en el boton continuar");
        find(continueButton).click();
    }

    public void verifyErrorMessage(String errorMessage) {
        Logs.info("Dar clic en el boton continuar");
        final var errorLabelElement = find(errorLabel);

        Assertions.assertAll(
                () -> Assertions.assertTrue(errorLabelElement.isDisplayed()),
                () -> Assertions.assertEquals(errorLabelElement.getText(), errorMessage)
        );
    }
}
