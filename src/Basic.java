import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basic {

	@Test
	public void Test()
	{
		// TODO Auto-generated method stub
		//Base url or host
		RestAssured.baseURI="http://cms-services-qa.dev.cf.private.springer.com";
		
		given().
		param("secondary_id","WJUR-D-19-01191").
		
		when().
		get("/search").
		
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("_links[8].href",equalTo("http://cms-services-qa.dev.cf.private.springer.com/07647920-d667-4de1-bfde-f3c385645acc/enrich_article")).and().
		header("Content-Type","applications/json;charset=UTF-8");
		

	}

}
