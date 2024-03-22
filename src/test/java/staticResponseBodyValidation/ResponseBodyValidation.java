package staticResponseBodyValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResponseBodyValidation {
	
	@Test
	public void staticBodyValidation() {
		
		//pre requistes
		String expdata = "TY_PROJ_022";
		
		baseURI="http://rmgtestingserver";
		port=8084;
		//action
		Response response = when().get("/projects");
		
		//validation
		String pid = response.jsonPath().get("[2].projectId");
		
		Assert.assertEquals(pid, expdata);
		System.out.println("data is present in DB");
		
	}
	
	@Test
	public void dynamicBodyValidation() {
		//pre requites
		String expdata="TY_PROJ_327";
		
		//action
		baseURI="http://rmgtestingserver";
		port=8084;
		Response response = when().get("/projects");
		
		//validation
		List<String> projectIDs = response.jsonPath().get("projectId");
		boolean flag=false;
		for(String pid:projectIDs) {
			if(pid.equalsIgnoreCase(expdata)) {
				flag=true;
				
			}
		}
		assertTrue(flag);
		System.out.println("data is present");
		response.then().log().all();
	}
	
	@Test
	public void timeValidate() {
		//action
			baseURI="http://rmgtestingserver";
			port=8084;
	when().get("/projects/TY_PROJ_030").
	
	//validation
	then().assertThat().statusCode(200)
	.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
	.contentType(ContentType.JSON)
	.log().all();
	}

}
