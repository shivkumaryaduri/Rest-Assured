package reqresREST;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class withoutBDD {
	
	@Test
	public void CreateUser() {
		

		
		
		JSONObject jobj=new JSONObject();
		jobj.put("name", "shiv");
		jobj.put("job", "leader");
		RequestSpecification req =  RestAssured.given();
		
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		//step 2 : perform the action
		Response post = req.post("https://reqres.in/api/users");
		ResponseBody body = post.getBody();
		String contentType = post.getContentType();
		System.out.println(body.asString());
		System.out.println(contentType);
		System.out.println(body.prettyPrint());
		
	}
	
	@Test
	public void GetUser() {
		RestAssured rs=new RestAssured();
		Response get = rs.get("https://reqres.in/api/users?page=2");
		 get.then().log().all();
		 
		 //Validate the response
		 int actStatus=get.statusCode();
		 System.out.println(actStatus);
		 Assert.assertEquals(actStatus, 200);
		
	}
	
	@Test
	public void updateUser() {
		JSONObject jobj=new JSONObject();
		jobj.put("name", "shiv");
		jobj.put("job", "ced");
		
		RequestSpecification rs = RestAssured.given();
		rs.body(jobj);
		rs.contentType(ContentType.JSON);
		
		Response put = rs.put("https://reqres.in/api/users/2");
		System.out.println(put.getBody().asString());
		System.out.println(put.getContentType());
		System.out.println(put.getBody().prettyPrint());
		System.out.println(put.getBody().prettyPeek());
		
		
	}
	
	@Test
	public void deleteUser() {
		RestAssured rs=new RestAssured();
		Response del = rs.delete("https://reqres.in/api/users/2");
		del.then().log().all();
		
		int statuscode=del.getStatusCode();
		Assert.assertEquals(statuscode, 204);
	}

}
