package crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.javaLIB;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class postMethod {

	@Test
	public void createProject() {
		
		javaLIB jl=new javaLIB();
		int num = jl.randomNum(500);
		
		//RestAssured rs=new RestAssured();
		
		
	
		//step 1: create pre requites-request body
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Shiv");
		obj.put("projectName", "RMGEcomm"+num);
		obj.put("status", "Completed");
		obj.put("teamSize", 12);
		
		RequestSpecification req =  RestAssured.given();
		
		req.body(obj);
		req.contentType(ContentType.JSON);
		
		//step 2 : perform the action
		Response post = req.post("http://rmgtestingserver:8084/addProject");
		ResponseBody body = post.getBody();
		String contentType = post.getContentType();
		System.out.println(body.asString());
		System.out.println(contentType);
		System.out.println(body.prettyPrint());
	}

}
