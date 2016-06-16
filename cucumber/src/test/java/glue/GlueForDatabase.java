package glue;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import glue.util.GlueDbManager;
import org.springframework.beans.factory.annotation.Autowired;

public class GlueForDatabase extends AbstractGlue {

	@Autowired GlueDbManager glueDbManager;

	@Before
	public void cleanDatabase() {
		glueDbManager.cleanUserTable();
	}

	@Given("^I have a user \"([^\"]*)\" with email \"([^\"]*)\"$")
	public void iHaveAUserWithEmail(String name, String email) throws Throwable {
		glueDbManager.addUser(name, email);
	}
}
