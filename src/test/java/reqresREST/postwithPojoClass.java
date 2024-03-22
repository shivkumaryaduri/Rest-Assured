package reqresREST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojo.pojoClassReq;

public class postwithPojoClass {
	
	@Test
	public void pojoReq() {
		
		pojoClassReq po = new pojoClassReq("Bumrah", "Bowler");
		baseURI="https://reqres.in/";
		
		given().body(po).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().statusCode(201).contentType(ContentType.JSON).log().all();
		
	}
		

}
