package crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		
		RequestSpecification req = RestAssured.given();
		
		
		JSONObject obj =new JSONObject();
		obj.put("createdBy", "rahul");
		obj.put("projectName", "Sales");
		obj.put("status", "Completed"); 
		obj.put("teamSize", 7);
		
		req.body(obj);
		req.contentType(ContentType.JSON);
		
		Response put = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_066");
		//validation
		System.out.println(put.getBody().asString());
		System.out.println(put.getContentType());
		System.out.println(put.getStatusCode());
		System.out.println(put.getBody().prettyPrint());
		System.out.println(put.getBody().prettyPeek());
		
		
		
		
	} 

}
