package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class BasePage extends PageObject {
    protected void waitForElement(By locator) {
        $(locator).waitUntilVisible();
    }

    protected void clickElement(By locator) {
        waitForElement(locator);
        $(locator).click();
    }

    protected void typeText(By locator, String text) {
        waitForElement(locator);
        $(locator).type(text);
    }
}
