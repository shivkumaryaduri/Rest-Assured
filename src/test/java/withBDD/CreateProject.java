package withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.javaLIB;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	
	@Test
	public void createProject() {
		
		javaLIB jl=new javaLIB();
		int num = jl.randomNum(500);
		
		
		
	
		//step 1: create pre requites-request body
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Shivkumar");
		obj.put("projectName", "Zalendo"+num);
		obj.put("status", "Completed");
		obj.put("teamSize", 12);
		
		given().body(obj)
		.contentType(ContentType.JSON)
		.when().post("http://rmgtestingserver:8084/addProject")
		
		.then().assertThat()
		.statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}

}
