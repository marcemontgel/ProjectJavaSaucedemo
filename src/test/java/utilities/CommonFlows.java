package utilities;

import data.DataGiver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class CommonFlows {
    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    private void assignLoginCookie() {
        Logs.debug("Asignando la cookie al Login");
        getDriver().get("https://www.saucedemo.com/404");
        final var credencialesValidas = DataGiver.getValidCredential();
        final var loginCookie = new Cookie("session-username", credencialesValidas.getUsername());
        getDriver().manage().addCookie(loginCookie);
    }

    public void goToLoginPage() {
        Logs.info("Navegando a la url");
        getDriver().get("https://www.saucedemo.com/");

        new LoginPage().waitPageToLoad();
    }

//    private void goToShoppingPage() {
//        assignLoginCookie();
//        getDriver().get("https://www.saucedemo.com/inventory.html");
//        new ShoppingPage().waitPageToLoad();
//    }
//
//    public void openBurgerMenu() {
//        goToShoppingPage();
//        new TopBar().openMenuBurger();
//        new MenuBurger().waitPageToLoad();
//    }
//
//    public void goToItemDetail() {
//        goToShoppingPage();
//        new ShoppingPage().goToItemDetail(itemName);
//        new ItemDetailPage().waitPageToLoad();
//    }
//
//    public void goToYourCartPage() {
//        goToShoppingPage();
//        new TopBar().clickShoppingCart();
//        new YourCartPage().waitPageToLoad();
//    }
//
//    public void goYourInformationPage() {
//        goToYourCartPage();
//        new YourCartPage().clicCheckout();
//        new YourInformationPage().waitPageToLoad();
//    }
}
