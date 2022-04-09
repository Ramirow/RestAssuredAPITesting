package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;


public class Testing {

   final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

//   public static void main(String args[]) {
//
//     getResponseBody();
//     getResponseStatus();
//
//; }

   //This will fetch the response body as is and log it. given and when are optional here
@Test   
public void getResponseBody(){
       given().when().get(url).then().log()
      .all();

  given().queryParam("CUSTOMER_ID","68195")
               .queryParam("PASSWORD","1234!")
               .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
   }

@Test
public void getResponseStatus(){
   int statusCode= given().queryParam("CUSTOMER_ID","68195")
           .queryParam("PASSWORD","1234!")
           .queryParam("Account_No","1")
           .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
   System.out.println("The response status is "+statusCode);

//   given().when().get(url).then().assertThat().statusCode(200);
}

}