package glue.util;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class RestClient {

	private CircularLinkedList restResponseHistory = new CircularLinkedList(10);

	public void getRequest(String url) {
		Response response = given().when().get(url);
		restResponseHistory.add(response);
	}

	public Response getLastReponse() {
		return (Response) restResponseHistory.getLast();
	}

}
