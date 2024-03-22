package parameters;

import org.testng.annotations.Test;

import genericUtility.javaLIB;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojo.PojoClass;

public class RequestChaining {
	
	@Test
	public void CreateProjectGetProject() {
		javaLIB js=new javaLIB();
		int num = js.randomNum(500);
		
		PojoClass pg=new PojoClass("ABD", "RCB"+num, "Retired", 15);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		//Create Project
		Response res = given().body(pg)
		.contentType(ContentType.JSON)
		.when().post("/addProject");
		
		String proid = res.jsonPath().get("projectId");
		System.out.println(proid);
		res.then().log().all();
		
		//Get the project
		given().pathParam("pid", proid).
		when().get("/projects/{pid}")
		.then().statusCode(200).log().all();
		
	}

}
