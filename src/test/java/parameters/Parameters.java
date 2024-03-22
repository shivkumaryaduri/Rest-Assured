package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Parameters {
	
	@Test
	public void pathparameter() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given().pathParam("pid", "TY_PROJ_354").
		when().get("/projects/{pid}").then().statusCode(200)
		.log().all();
	}
	@Test
	public void querryParameter() {
		baseURI="https://reqres.in/";
		given().queryParam("page", 2).
		when().get("/api/users").
		then().statusCode(200).log().all();
		
	}
	
	@Test
	public void formParameter() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		given().formParam("createdBy", "gayle").
		formParam("projectName", "rcb").
		formParam("status", "Completed")
		.formParam("teamSize", 48).when().post("/addProject").then().statusCode(201).contentType(ContentType.JSON).log().all();
		
	}

}
