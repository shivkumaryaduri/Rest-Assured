package crudWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getSingleProject {
	
	@Test
	public void getSingleProj() {
	RestAssured rs=new RestAssured();
	Response get = rs.get("http://rmgtestingserver:8084/projects");
	 get.then().log().all();
	 
	 //Validate the response
	 int actStatus=get.statusCode();
	 System.out.println(actStatus);
	 Assert.assertEquals(actStatus, 200);
	 
	
	}
}
