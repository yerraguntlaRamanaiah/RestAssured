package Day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Logging {
	
@Test
void loggingMethods()
{
	given()
	
	.when()
	.get("https://www.youtube.com/")
	.then()
	//.log().body();
	//.log().headers();
	//.log().cookies();
	.log().all();
}

}
