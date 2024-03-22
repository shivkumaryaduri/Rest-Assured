package reqresREST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class diffrentWaysToPost {
	
	@Test
	public void jsonObject() {
			
			JSONObject jobj=new JSONObject();
			jobj.put("name", "virat");
			jobj.put("job", "king");
			
			baseURI="https://reqres.in/";
			given().body(jobj).contentType(ContentType.JSON)
			.when().post("/api/users")
			.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
			
			
		}
	

	@Test
	public void hashMap() {
		
		HashMap hobj=new HashMap();
		hobj.put("name", "Dhoni");
		hobj.put("job", "finisher");
		
		baseURI="https://reqres.in/";
		given().body(hobj).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	
	@Test
	public void jsonFile() {
		
		baseURI="https://reqres.in/";
		File f = new File("./BodyDataReq.json");
		
		given().body(f).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().statusCode(201).contentType(ContentType.JSON).log().all(); 
		
		
	}
}

