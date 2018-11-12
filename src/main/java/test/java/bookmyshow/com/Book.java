package test.java.bookmyshow.com;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Book {

	
	@Test
public void GetBookInfo(String venue)
{

	RestAssured.baseURI= "https://in.bookmyshow.com" ;
	Response BookDetails=given().header("Content-Type","application/json").
	body
			 ( "{\"ticketsArr\":[{\"VenueCode\":\+ venue\,   " + 
			  " \"selectedQuantity\":1,  " + 
			   "\"SessionID\":\"10116\",\"PriceCode\":\"T471\"}],  "+ 
			   " \"commands\":[\"INITTRANS\",\"ADDSEATS\"],  " + 
			   "\"lngTransId\":\"\",\"appCode\":\"WEBV2\",\"UID\":\"\"}"  ).
			 
	when().post("/nm-api/is/book").
	
	then().statusCode(200).contentType(ContentType.JSON).extract().response();
	String BookResp=BookDetails.asString();
	JsonPath js= new JsonPath(BookResp);
	System.out.println("Booking Details=" +BookResp );

}
	
	
}
