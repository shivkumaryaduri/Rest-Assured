package withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject {
	
	@Test
	public void deleteProj() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().delete("/projects/TY_PROJ_121")
		 
		.then().assertThat().statusCode(204);
		
	}

}
