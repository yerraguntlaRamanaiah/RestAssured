package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;


public class waysToCreatePostRequestBody {
	
	//post request creating using hashmap
	//@Test(priority=1)
	void testpostusingHashMap()
	{
		HashMap data =new HashMap();
		data.put("name","srinidhi");
		data.put("location","Banglore");
		String corsesArr[] = {"phython","javascript"};
		data.put("courses", corsesArr);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/Students")
			
		.then()
		.statusCode(201)
		.body("name",equalTo("srinidhi"))
		.body("location",equalTo("Banglore"))
		.body("courses[0]", equalTo("phython"))
		.body("courses[1]",equalTo("javascript"))
		.header("content-Type","application/json; charset=uts-8")
		.log().all();
		
	}
	
	
	//creating request body using org.json
	//@Test(priority=1)
	void testpostusingJSONObject()
	{
		JSONObject data =new JSONObject();
		data.put("name","srinidhi");
		data.put("location","Banglore");
		String corsesArr[] = {"phython","javascript"};
		data.put("courses", corsesArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/Students")
			
		.then()
		.statusCode(201)
		.body("name",equalTo("srinidhi"))
		.body("location",equalTo("Banglore"))
		.body("courses[0]", equalTo("phython"))
		.body("courses[1]",equalTo("javascript"))
		.header("content-Type","application/json; charset=uts-8")
		.log().all();
		
	}
	
	//creating request body using pojo class
	
	//@Test(priority=1)
	void testpostusingPojo()
	{
		Pojo data = new Pojo();
		data.setName("Ramana");
		data.setLocation("Banglore");
		String coursesArr[] = {"c","c++"};
		
		data.setCousesArr(coursesArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/Students")
			
		.then()
		.statusCode(201)
		.body("name",equalTo("srinidhi"))
		.body("location",equalTo("Banglore"))
		.body("courses[0]", equalTo("phython"))
		.body("courses[1]",equalTo("javascript"))
		.header("content-Type","application/json; charset=uts-8")
		.log().all();
		
	}
	
	//creating request body using exteranl file
	
	@Test(priority=1)
	void testpostusingExternalJson() throws FileNotFoundException
	{
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/Students")
			
		.then()
		.statusCode(201)
		.body("name",equalTo("srinidhi"))
		.body("location",equalTo("Banglore"))
		.body("courses[0]", equalTo("phython"))
		.body("courses[1]",equalTo("javascript"))
		.header("content-Type","application/json; charset=uts-8")
		.log().all();
		
	}
	
	
	@Test(priority=2)
	void deleteUSer() 
	{
		given()
		
		.when()
	
		.delete("http://localhost:3000/Students/4")
		
		.then()
		.statusCode(200);

	}

}
