package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.LoginSteps;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

   @Given("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        loginSteps.login("standard_user", "secret_sauce");
    }

    @Then("the user should see the dashboard")
    public void the_user_should_see_the_dashboard() {
        loginSteps.verifyDashboard();
    }
}
