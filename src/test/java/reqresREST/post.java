package reqresREST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class post {
	
	@Test
	public void createUser() {
		
		JSONObject jobj=new JSONObject();
		jobj.put("name", "shiv");
		jobj.put("job", "leader");
		
		baseURI="https://reqres.in/";
		given().body(jobj).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
		
	}

}
