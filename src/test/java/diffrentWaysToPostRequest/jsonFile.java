package diffrentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class jsonFile {
	
	@Test
	public void postWithJSONFile() {
		
		File f = new File("./BodyData.json");
		
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given().body(f)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		
		.then().assertThat()
		.statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
		
		
	}

}
