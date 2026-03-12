package pages;



import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By dashboard = By.className("app_logo");

    public void openLoginPage() {
        open();
    }

    public void enterUsername(String user) {
        typeText(username, user);

    }

    public void enterPassword(String pwd) {

        typeText(password, pwd);
    }

    public void clickLogin() {

        clickElement(loginButton);
    }

    public boolean isDashboardVisible() {
        return $(dashboard).waitUntilVisible().isDisplayed();
    }
}