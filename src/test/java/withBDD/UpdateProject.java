package withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void updateProj() {
		
	
	
	//step 1: create pre requites-request body
			JSONObject obj = new JSONObject();
			
			obj.put("createdBy", "ShivkumarY");
			obj.put("projectName", "Zalendo00000000");
			obj.put("status", "Completed");
			obj.put("teamSize", 4);
			
			baseURI="http://rmgtestingserver";
			port=8084;
			
			
			given().body(obj).contentType(ContentType.JSON)
			.when().put("/projects/TY_PROJ_126")
			
			.then().assertThat().statusCode(200)
			.contentType(ContentType.JSON).
			log().all();

}
}
