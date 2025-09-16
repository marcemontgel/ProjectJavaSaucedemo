package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class Footer extends BasePage {

    private final By twiterButton = By.xpath("//a[text()='Twitter']");
    private final By linkedinButton = By.xpath("//a[text()='LinkedId']");
    private final By facebookButton = By.xpath("//a[text()='Facebook']");

    @Override
    public void waitPageToLoad() {

    }

    @Override
    public void verifyPage() {

    }

    @Step("Verificando los links de las redes sociales")
    public void verifySocialMediaLinks(
            String twitterUrl,
            String linkedinUrl,
            String facebookUrl
    ) {
        final var twitterLabel = find(twiterButton);
        final var linkedinLabel = find(linkedinButton);
        final var facebookLabel = find(facebookButton);

        Logs.info("Verificando los links de las redes Sociales");

        Assertions.assertAll(
                () -> Assertions.assertTrue(twitterLabel.isDisplayed()),
                () -> Assertions.assertTrue(twitterLabel.isEnabled()),
                () -> Assertions.assertEquals(twitterLabel
                        .getAttribute("href"), twitterUrl
                ),
                () -> Assertions.assertTrue(linkedinLabel.isDisplayed()),
                () -> Assertions.assertTrue(linkedinLabel.isEnabled()),
                () -> Assertions.assertEquals(linkedinLabel
                        .getAttribute("href"), linkedinUrl
                ),
                () -> Assertions.assertTrue(facebookLabel.isDisplayed()),
                () -> Assertions.assertTrue(facebookLabel.isEnabled()),
                () -> Assertions.assertEquals(facebookLabel
                        .getAttribute("href"), facebookUrl
                )
        );
    }

}
