package bookmyshow.com;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTest {

	

		@Test()
		public void GetEventCode()
		{
			
			//final Logger log = Logger.getLogger(GetEventInfo.class.getName());
			//private static Logger log =LogManager.getLogger(GetEventInfo.class.getName());
			RestAssured.baseURI = "https://in.bookmyshow.com" ;
			
			Response res=given().
			param(" type","event").
			param("eventCode", "ET00083081").
			when().get("/nm-api/de/getEventInfo").
			then().statusCode(200).extract().response();
		    String resp=res.asString();
			System.out.println("response" + resp);
}
}
