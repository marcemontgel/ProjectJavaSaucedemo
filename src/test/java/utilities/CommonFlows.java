package utilities;

import data.DataGiver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.ItemDetailPage;
import pages.LoginPage;
import pages.MenuBurger;
import pages.ShoppingPage;
import pages.TopBar;

public class CommonFlows {


    private WebDriver getDriver() {
        return WebDriverProvider.get();
    }

    private void assignLoginCookie() {
        Logs.debug("Asignando la cookie al Login");
        getDriver().get("https://www.saucedemo.com/404");
        final var credencialesValidas = DataGiver.getValidCredential();
        final var loginCookie =
                new Cookie("session-username", credencialesValidas.getUsername());
        getDriver().manage().addCookie(loginCookie);
    }

    public void goToLoginPage() {
        Logs.info("Navegando a la url");
        getDriver().get("https://www.saucedemo.com/");

        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage() {
        assignLoginCookie();
        getDriver().get("https://www.saucedemo.com/inventory.html");

        new ShoppingPage().waitPageToLoad();
    }

    public void openBurgerMenu() {
        goToShoppingPage();

        new TopBar().openMenuBurger();
        new MenuBurger().waitPageToLoad();
    }

    public void goToItemDetail(String itemName) {
        goToShoppingPage();

        new ShoppingPage().goToItemDetail(itemName);
        new ItemDetailPage().waitPageToLoad();
    }
}
