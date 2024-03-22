package diffrentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.javaLIB;
import io.restassured.http.ContentType;

public class jsonobject {

	@Test
	public void postWithJsonObject() {
		javaLIB jl=new javaLIB();
		int num = jl.randomNum(500);
		
		
		
	
		//step 1: create pre requites-request body
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Shivkumar");
		obj.put("projectName", "Zalendo"+num);
		obj.put("status", "Completed");
		obj.put("teamSize", 12);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().body(obj)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		
		.then().assertThat()
		.statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
	}

