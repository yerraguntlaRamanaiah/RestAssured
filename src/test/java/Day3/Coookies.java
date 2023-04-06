package Day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Coookies {
   // cookiees info will change dynamically 
	//@Test(priority = 1)
	void getOneCookie()
	{
		given()
		
		.when()
		.get("https://www.youtube.com/")
		
		.then()
		.cookie("YSC","AS_ce9mjZYo")
		.log().all();
		
	}
	
	@Test(priority=2)
	void getInfoCookies()
	{
		Response res = given()
		
		.when()
		.get("https://www.youtube.com/");
		
		//get single cookie info
		//String cookie_value = res.getCookie("YSC");
		//System.out.println(cookie_value);
		
		//get the total cookie info
		Map<String,String> Cookie_values = res.getCookies();
		
		//System.out.print(Cookie_values.keySet());
		for(String k:Cookie_values.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"           "+cookie_value);
			
		}
		
		
	}
	
}
