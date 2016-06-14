package glue;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class StepDefinitions extends AbstractGlue {

	@Autowired TestService testService;

	@Given("^I am logged in as \"([^\"]*)\"$")
	public void iAmLoggedInAs(String name) throws Throwable {
		testService.test();
		assertEquals("admin", name);
	}

}
