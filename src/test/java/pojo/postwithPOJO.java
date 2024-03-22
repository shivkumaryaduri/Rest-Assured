package pojo;

import org.testng.annotations.Test;

import genericUtility.javaLIB;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class postwithPOJO {
	
	@Test
	public void postWithPOJO()
	{
		javaLIB j=new javaLIB();
		int num = j.randomNum(500);
		PojoClass pg=new PojoClass("shiv", "Zaln"+num, "on going", 7);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(pg).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
	}

}
