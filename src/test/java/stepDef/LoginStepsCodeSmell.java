package stepDef;


import io.cucumber.java.en.*;
import net.serenitybdd.core.Serenity;
import pages.LoginPageCodeSmell;

// ISSUE #7: Step definition doing business logic — should delegate to a task/action layer
public class LoginStepsCodeSmell {

    LoginPageCodeSmell loginPage = new LoginPageCodeSmell();  // <<< ISSUE #8: Manual instantiation, not @Steps

    @Given("the admin logs in with valid credentials")
    public void adminLogin() throws InterruptedException {
        // ISSUE #9: Hard-coded test data inside step definition
        loginPage.login("admin", "P@ssw0rd123");  // <<< ISSUE #9
        Serenity.recordReportData().withTitle("Login").andContents("admin logged in");
    }

    @When("user navigates to {string}")
    public void navigateTo(String url) {
        // ISSUE #10: Environment URL hard-coded — should come from serenity.conf - review
        loginPage.getDriver().get("https://uat.homeoffice.gov.uk/" + url); // <<< ISSUE #10
    }

    // ISSUE #11: Catching Exception instead of specific exceptions — hides real errors
    @Then("the dashboard should be displayed")
    public void verifyDashboard() {
        try {
            loginPage.verifyLoginSuccess();
        } catch (Exception e) {  // <<< ISSUE #11
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
