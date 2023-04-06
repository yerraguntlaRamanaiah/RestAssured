package Day3;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Headers {
	
	@Test(priority = 1)
	void getHeader()
	{
		given()
		
		.when()
		.get("https://www.youtube.com/")
		
		.then()
		.header("Content-Type","text/html; charset=utf-8");
	}
	
	@Test
	void getAllHeaders()
	{
		Response res = given()
		
		.when()
		.get("https://www.youtube.com/");
		
		//get the one header info
		String Headervalue = res.getHeader("Content-Type");
		System.out.println(Headervalue);
		
		//get all headers info
		io.restassured.http.Headers myheaders = res.getHeaders();
		
		for(Header hd :myheaders)
		{
			System.out.println(hd.getName()+ "     "+hd.getValue());
			
		}
		
	}

}
