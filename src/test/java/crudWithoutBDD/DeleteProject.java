package crudWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	@Test
	public void deleteProj() {
		RestAssured rs=new RestAssured();
		Response del = rs.delete("http://rmgtestingserver:8084/projects/TY_PROJ_066");
		del.then().log().all();
		
		int statuscode=del.getStatusCode();
		Assert.assertEquals(statuscode, 204);
	}

}
