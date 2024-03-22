package reqresREST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class withBDD {
	
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

	@Test
	public void getUsers() {
		
		baseURI="https://reqres.in";
		
		when().get("/api/users/8")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
		
	}
	
	@Test
	public void updateUser() {
		
		baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("name", "rahul");
		jobj.put("job", "founder");
		
		
		given().body(jobj).contentType(ContentType.JSON)
		.when().put("api/users/2")
		
		.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON).
		log().all();
		
	}
	
	@Test
	public void deleteUser() {
		baseURI="https://reqres.in";
		
		when().delete("api/users/2")
		.then().statusCode(204).log().all();
		
	}
}
