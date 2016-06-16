package glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.util.RestClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends AbstractGlue {

	@Autowired TestService testService;
	@Autowired RestClient restClient;

	@Given("^I am logged in as \"([^\"]*)\"$")
	public void iAmLoggedInAs(String name) throws Throwable {
		testService.test();
		assertEquals("admin", name);
	}

	@Given("^I save user \"([^\"]*)\" with email \"([^\"]*)\"$")
	public void iSaveUserWithEmail(String name, String email) throws Throwable {
		Map<String, String> jsonAsMap = new HashMap<>();
		jsonAsMap.put("name", name);
		jsonAsMap.put("email", email);
		given().
				contentType(ContentType.JSON).
				body(jsonAsMap).
				when().
				post("http://localhost:8080/user").
				then().
				statusCode(200);
	}

	@When("^I retrieve user with id \"([^\"]*)\"$")
	public void iRetrieveUserWithId(String id) throws Throwable {
		restClient.getRequest("http://localhost:8080/user/" + id);
	}

	@Then("^we receive the following user details$")
	public void weReceiveTheFollowingUserDetails(Map<String, String> userDetails) throws Throwable {
		Response userResponse = restClient.getLastReponse();
		for (Map.Entry<String, String> entry : userDetails.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			userResponse.then().assertThat().body(key, CoreMatchers.equalTo(value));
		}
	}
}
