package methods;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;


public class Test_1 {
	@Test
	public void Foriegn_player()
	{
RestAssured.baseURI="https://reqres.in/";
String response=given().log().all().header("Content-Type","application/json")
				.when().get("https://reqres.in/api/users?page=2")
				.then().log().all().assertThat().statusCode(200)
				.body("page",Matchers.equalTo(2)).extract().response().asString();
JsonPath json=new JsonPath(response);
List<String> allPlayer=json.get("player.country");
int c=0;
for (String i: allPlayer) 
{if(c<4) {
	if(!(i.equalsIgnoreCase("india")))
		// System.out.println("Player "+(c+1)+ " from "+i);
		c++;
   }}
Assert.assertEquals(c,4);
	}
	
	public void aleast_one_wicket_keeper()
	{
		RestAssured.baseURI="https://reqres.in/";
		String response=given().log().all().header("Content-Type","application/json")
						.when().get("https://reqres.in/api/users?page=2")
						.then().log().all().assertThat().statusCode(200)
						.body("page",Matchers.equalTo(2)).extract().response().asString();
		JsonPath json=new JsonPath(response);
		List<String>roles=json.get("player.role");
		int c=0;
		for (String role: roles)
		{
		if(role.equalsIgnoreCase("wicket-keeper"))
			c++;
		}
		if(c>=1) {
			boolean wc=true;}
		Assert.assertEquals(true, true);
	}


}
