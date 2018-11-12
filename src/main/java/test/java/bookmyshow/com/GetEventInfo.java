package test.java.bookmyshow.com;

import static io.restassured.RestAssured.given;
//import org.apache.logging.log4j.*;

import java.util.Iterator;

import org.testng.Assert;

//import java.util.logging.LogManager;
//import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import java.util.List;
import java.util.Map;
//import org.json.JSONException;
//import org.json.JSONObject;

import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public  class GetEventInfo {

	@Test()
	public static void GetEventCode() 
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
	//System.out.println("response" + resp);
	
	//JsonPath js= new JsonPath(resp);
String json=resp;
	System.out.println("Response = " + json);
	
	/************** EVENTCARD INFO *******************/   
	Map<String, Object> eventCards = JsonPath.read(json, "$.eventCards");
	System.out.println("EVENTCARDS = " + eventCards);
	
	/************** VENUE *******************/               
    String venue = eventCards.entrySet().iterator().next().getKey();
    System.out.println("VENUE = " + venue);
    Assert.assertNotNull("STATUS NOT NULL"+venue);
    //Assert.assertNotNull(venue.isNotNull();
    /************** DATE *******************/   
    Map<String, Object> sessions = JsonPath.read(json, String.format("$.eventCards.%s",venue));
    String date = sessions.entrySet().iterator().next().getKey();
    System.out.println("DATE = " +date);
    
    /************** PRICE *******************/   
    Map<String, Object> prices = JsonPath.read(json, String.format("$.eventCards.%s.%s",venue,date));
    String price = prices.entrySet().iterator().next().getKey();
    System.out.println("PRICE = " + price);
    
    /************** ETCODE *******************/   
    Map<String, Object> etCodeMap = JsonPath.read(json, String.format("$.eventCards.%s.%s.%s",venue,date,price));
    String etCode = etCodeMap.entrySet().iterator().next().getKey();
    System.out.println("ETCODE = " + etCode);
    
 Map<String, String> data = JsonPath.read(json, String.format("$.eventCards.%s.%s.%s.%s",venue,date,price,etCode));
   System.out.println("Session ID = " + data.get("SessionID"));
//    System.out.println(data.get("ShowDateDisplay"));
//    System.out.println(data.get("VenueName"));
//	
		
		
		
		
	}
	

}
		
//		JSONObject jsonObj = new JSONObject(resp.toString());
//	    System.out.println(jsonObj);
//	    Iterator<String> keys = jsonObj.keys();
//
//	    while(keys.hasNext()) {
//		
//	        String key = keys.next();
//	        System.out.println(key);
////	        JSONObject object = jsonObj.getJSONObject(key);
////	    	        System.out.println(object);
//	    	        
//	    	     // if(key=='eventCards'){
//    	        	
////	    	        }
////	    }
//	    	        
//	    }}}
	    	       // if(key=='eventCards'){
	    	        	
//	    	        }
//	    }
	  ////
	  
		//Object Eventcards= js.get("eventcards");

//		String Eventcards= js.getObject("eventCards", null);
//		System.out.println(Eventcards);
////
////		
		
		
		
		
		
		
		
//		RestAssured.baseURI = "https://in.bookmyshow.com" ;
//		RequestSpecification httpRequest = RestAssured.given().param(" type","event").param("eventCode", "ET00083081");
//		Response response = httpRequest.get("/nm-api/de/getEventInfo");
//		
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		 String s= jsonPathEvaluator.get("eventCards").toString();
//		 System.out.println(s);
//		 String t="" ;
//		 for( int i=34;i<39;i++)
//		 {
//			 t+= s.charAt(i);
//		 }
//		 System.out.println(t);
	//String eventCards=	js.getJsonObject("eventCards[0]").toString();
	//	System.out.println("eventCards"+eventCards );
//   Gson gson = new Gson(); // Or use new GsonBuilder().create();
//   String key="EventInfo";//array key (as it mentioned in your Json)
//  
//Response response=//your API call which will return Json Object
//   List<String,Object>> booksList=response.jsonPath().getList(key);
//   //Now parse value from List
//   HashMap<String,Object> firstBookDetails=booksList.get(0);// for first index
//   String author=(String)firstBookDetails.get("author");
//   
   
//        

//		Map<String, Object> map = gson.fromJson(resp, new TypeToken<Map<String, Object>>(){}.getType());
//	map.forEach((x,y)-> System.out.println("key : " + x + " , value : " + y));
//	
//	
//	Object sessionId = ((Map<String,Object>)((Map<String,Object>)((Map<String,Object>)((Map<String,Object>)
//			map.get("eventCards"))
//			.get("JNSD")).get("20181118")).get("1500")).get("SessionID");
//	//System.out.println("sessionId");
//	Map<String, Object> dataset_1 = new HashMap<String, Object>();
//	((Map<String,Object>)((Map<String,Object>)((Map<String,Object>)((Map<String,Object>)((Map<String,Object>)
//			map.get("eventCards")).get("JNSD")).get("20181118")).get("1500")).get("SessionID"));
////   Object str = map.get("eventCards");
//		//String eventCards = map.get("eventCards");
//		System.out.println("response" + str);
//		//Map<String, Object> map1 = gson.fromJson(resp, new TypeToken<Map<String, Object>>(){}.getType());
//		
//    	Map<String, Object> map2 = gson.fromJson(resp, new TypeToken<Map<String, Object>>(){}.getType());
//    	Object str1 = map.get("Venue");
//    	System.out.println("response" + str1);
////		String SessionID= js.get("eventCards.JNSD.20181118.1500.ET00083081-10116-T472.SessionID");
////		System.out.println("response" + SessionID);
////		
		
		
	

	
	
	

