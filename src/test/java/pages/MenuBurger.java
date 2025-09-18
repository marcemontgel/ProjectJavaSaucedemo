package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class MenuBurger extends BasePage {

    private final By logoutButton = By.id("logout_sidebar_link");
    private final By aboutButton = By.id("about_sidebar_link");


    @Override
    public void waitPageToLoad() {
        waitPage(logoutButton, this.getClass().getSimpleName());

        Logs.info("Esperando la visualización de los elementos");
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el menú burguer");

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(logoutButton).isDisplayed()),
                () -> Assertions.assertTrue(find(aboutButton).isDisplayed())
        );
    }

    public void clickButtonLogout() {
        Logs.info("Haciendo click en Log Out");
        find(logoutButton).click();
    }

    public void verifyAboutLink(String expectAbout) {
        final var aboutLabel = find(aboutButton);

        Logs.info("Verificar opción About");

        Assertions.assertAll(
                () -> Assertions.assertTrue(aboutLabel.isDisplayed()),
                () -> Assertions.assertTrue(aboutLabel.isEnabled()),
                () -> Assertions.assertEquals(aboutLabel.getAttribute("href"), expectAbout)
        );
    }
}
