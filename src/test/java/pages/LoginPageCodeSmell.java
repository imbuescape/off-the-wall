package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

// ISSUE #1: Static WebDriver — NOT thread-safe for parallel execution
public class LoginPageCodeSmell extends PageObject {

    // ISSUE #2: Hard-coded credentials in production code — SECURITY RISK
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "P@ssw0rd123";

    // ISSUE #3: Fragile XPath locator — breaks on minor UI change
    private By usernameField = By.xpath("/html/body/div[2]/form/input[1]");
    private By passwordField = By.xpath("/html/body/div[2]/form/input[2]");
    private By submitButton  = By.xpath("/html/body/div[2]/form/button");

    // ISSUE #4: Thread.sleep — blocks thread, no smart synchronisation
    public void login(String username, String password) throws InterruptedException {
        find(usernameField).sendKeys(username);
        Thread.sleep(3000);   // <<< ISSUE #4
        find(passwordField).sendKeys(password);
        Thread.sleep(2000);   // <<< ISSUE #4
        find(submitButton).click();
    }

    // ISSUE #5: Page Object doing assertion — violates Single Responsibility
    public void verifyLoginSuccess() {
        String title = getDriver().getTitle();
        assert title.equals("Dashboard") : "Login failed!"; // <<< ISSUE #5
    }

    // ISSUE #6: Raw List<WebElement> returned — leaks Selenium internals
    public List<WebElement> getAllLinks() {
        return getDriver().findElements(By.tagName("a")); // <<< ISSUE #6
    }
}
