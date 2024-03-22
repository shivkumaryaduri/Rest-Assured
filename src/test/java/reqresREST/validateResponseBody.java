package reqresREST;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class validateResponseBody {
	
	@Test
	public void validateStaticResponse() {
		baseURI="https://reqres.in/";
		String expdata = "michael.lawson@reqres.in";
		//action
		Response response = when().get("/api/users?page=2");
		
		String email = response.jsonPath().get("data[0].email");
		assertEquals(expdata, email);
		System.out.println("data is present");
		
		
	}
	
	@Test
	public void validateDynamicResponse() {
		
		baseURI="https://reqres.in/";
		String expdata ="michael.lawson@reqres.in";
		
		//action
		Response response = when().get("/api/users?page=2");
		List<String> emails = response.jsonPath().get("data.email");
		boolean flag = false;
		for(String email:emails) {
			if(email.equals(expdata)) {
				flag=true;
			}
			
			
			
		}
		assertTrue(flag);
		System.out.println("data is present");
		
	}

}
