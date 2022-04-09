package test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.hamcrest.Matchers.equalTo;


public class Testcases {
	 final static String createspaceurl="https://api.hub.knime.com/repository/Users/rami123/New%20space%204";
	 final static String deletespaceurl = "https://api.hub.knime.com/repository/Users/rami123/New%20space%204";
	 final static String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ2SHpuYUhTS3RMWmszcnczVlJBN2M4eThsUHlVazU3YndMejRvekFZT1o4In0.eyJqdGkiOiI3MGQ4YTQ3MC01MWQwLTRkNjEtOTE3OC1hM2U0Nzk4MTQxYTQiLCJleHAiOjE2NDk1Mzg3NTAsIm5iZiI6MCwiaWF0IjoxNjQ5NTI3OTUwLCJpc3MiOiJodHRwczovL2F1dGguaHViLmtuaW1lLmNvbS9hdXRoL3JlYWxtcy9rbmltZSIsInN1YiI6IjIxMzNiZGQwLTExZTItNDJiNi04ZmU1LTU2YWIzYjNjOWE5YiIsInR5cCI6IkJlYXJlciIsImF6cCI6Imh1Yi11aSIsIm5vbmNlIjoicUZ1eUVlSmVrUlRGRENZU1VHdXpTMTBScHhuUnMxWkd6RzEzVDZnZUxqOCIsImF1dGhfdGltZSI6MTY0OTI1NjAxNSwic2Vzc2lvbl9zdGF0ZSI6ImFjZGU5NWY5LWE2YmMtNDMyMy05MGZiLTA3Yjk3YjY2MTFiYyIsImFjciI6IjAiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly9zdGFnZS5odWIua25pbWUuY29tIiwiaHR0cHM6Ly9odWIua25pbWUuY29tIl0sInJlc291cmNlX2FjY2VzcyI6eyJicm9rZXIiOnsicm9sZXMiOlsicmVhZC10b2tlbiJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgZ3JvdXBzIHJvbGVzIGVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IlJhbWkxMjMiLCJncm91cHMiOlsiaHVidXNlciJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJyYW1pMTIzIiwiZ2l2ZW5fbmFtZSI6IlJhbWkxMjMiLCJlbWFpbCI6InJhbWltb3VyYW5pMzZAZ21haWwuY29tIn0.sNfYqM6w9Mqi3EHHaB-88iPVLvkKhckQUPKaBqnKOdCzx_R4_u1Ta3548BcKdlbRcXjMpgNjACWou0Q-_eYxq5K0joIs1Ma-IML7Q8AGMjfb2J6N1G3kFCDnTTzIYMQAhuInn27YhvsSTdm_PBAD7Q-9f_7E1t_wOj7BmczmBBRE6R3DAGTjs6eVLyhXQULam81v4KDKUCe6Jp1kyND0-XuB3OCFxvs4KhyBvMdVQik_tcHzmt6x7lfnkTTCb8bVNJh-yqrnPe2W1P3ezi_tkRcUCkGrwJ7HaNjtETjfnGttZuhvWydUUiOg4lo1w5e2FjU8nJUqp46XwUZ0-qackA";

@Test
public void Addspace(){ 
	   given().
	   queryParam("overwrite",false).
	   headers("Authorization", "Bearer "+ token).
	   body("{\"private\":false, \"type\":\"Space\"}").
	   when().put(createspaceurl).then().
	   body("path", equalTo("/Users/rami123/New%20space%204"));
	  }

@Test	   
public void SpaceDetails() {
		 given().
		queryParam("details","aggregated").queryParam("spaceDetails",true).headers("Authorization", "Bearer "+ token)
		.when().
		get("https://api.hub.knime.com/repository/*qGpKlY2eYNegSoCK").
		then().assertThat().statusCode(200);			   		   
	   } 	   
@Test	   
public void ChildrenSpaceDetails() {
		 given().
		queryParam("contribSpaces","children").queryParam("spaceDetails",true).headers("Authorization", "Bearer "+ token)
		.when().
		get("https://api.hub.knime.com/repository/Users/rami123").
		then().assertThat().statusCode(200);			   		   
	   } 	   
@Test	   
public void DeleteSpace() {
		given().
		headers("Authorization", "Bearer "+ token)
		.when().
		delete(deletespaceurl).
		then().assertThat().statusCode(204);			   		   
	   } 	   
@Test	   
public void Onboarding() {
		given().
		headers("Authorization", "Bearer "+ token)
		.when().
		get("https://api.hub.knime.com/accounts/*CxrxARNRm5PNyiMh/onboarding").
        then().assertThat().body("componentExists", equalTo(false))
        .body("workflowExists", equalTo(false));
	   } 

	   
}
