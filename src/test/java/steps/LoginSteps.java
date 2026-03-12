package steps;


import net.serenitybdd.annotations.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Step("User logs in")
    public void login(String username, String password) {

        loginPage.openLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Step("User should see the Dashboard")
    public void verifyDashboard() {

        assert loginPage.isDashboardVisible();
    }
}