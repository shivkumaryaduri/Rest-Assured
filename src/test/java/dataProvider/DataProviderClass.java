package dataProvider;

import org.codehaus.groovy.runtime.dgmimpl.arrays.ObjectArrayGetAtMetaMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.javaLIB;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojo.PojoClass;

public class DataProviderClass {
	
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[3][4];
		
		obj[0][0]="virat";
		obj[0][1]="rcb";
		obj[0][2]="not started";
		obj[0][3]=11;
		
		obj[1][0]="faf";
		obj[1][1]="rcb";
		obj[1][2]="not started";
		obj[1][3]=11;
		
		obj[2][0]="Maxwell";
		obj[2][1]="rcb";
		obj[2][2]="not started";
		obj[2][3]=11;
		
		return obj;
	}
	
	@Test(dataProvider = "data")
	public void postWithDataProvider(String createdby,String prjectName,String status,int teamsize) {
		
		//pre-requistes
	
		javaLIB	js=new	javaLIB();
		PojoClass pg=new PojoClass(createdby, prjectName+js.randomNum(500), status, teamsize);
		 baseURI="http://rmgtestingserver";
		 port=8084;
		 
		 given().body(pg).contentType(ContentType.JSON)
		 .when().post("/addProject")
		 .then().statusCode(201).log().all();
		

}
}