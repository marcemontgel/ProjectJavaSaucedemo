package steps;

import io.cucumber.java.en.Then;
import pages.Footer;

public class FooterStepsDefinitions {
    private final Footer footer = new Footer();

    @Then("Verificar que los enlaces sean correctos {string}, {string}, {string}")
    public void verifySocialMediaLinks(String twitterUrl, String linkedinUrl, String facebookUrl) {
        footer.verifySocialMediaLinks(twitterUrl, linkedinUrl, facebookUrl);
    }
}
