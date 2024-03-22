package reqresREST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ResponseTimeVal {
	
	@Test
	public void timeValidate() {
		//action
			baseURI="https://reqres.in/";
			
	when().get("/api/users/2").
	
	//validation
	then().assertThat().statusCode(200)
	.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
	.contentType(ContentType.JSON)
	.log().all();
	}

}
