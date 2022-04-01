import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class Mini_Assignment2{
    RequestSpecification reqSpe1,reqSpe2;
    ResponseSpecification resSpe;
    @BeforeClass
    public void set(){
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecBuilder requestSpecBuilder1 = new RequestSpecBuilder();
        requestSpecBuilder1.setBaseUri("https://jsonplaceholder.typicode.com").
                addHeader("Content-Type","application/json");
        reqSpe1 = RestAssured.with().spec(requestSpecBuilder1.build());

        RequestSpecBuilder requestSpecBuilder2 = new RequestSpecBuilder();
        requestSpecBuilder2.setBaseUri("https://reqres.in/api").
                addHeader("Content-Type","application/json");
        reqSpe2 = RestAssured.with().spec(requestSpecBuilder2.build());

        resSpe = RestAssured.expect().
                contentType(ContentType.JSON);
    }

    @Test
    public void get(){
        Response response=given().
                spec(reqSpe1).
                when().
                get("/posts").
                then().
                spec(resSpe).statusCode(200).log().status().log().headers().
                extract().response();
        assertThat(response.path("[39].userId"), is(equalTo(4)));
        String s1;
        int k=1;
        JSONArray j=new JSONArray(response.asString());
        for(int l=0;l<j.length();l++){
            Object o = j.getJSONObject(l).get("title");
            if( !(o instanceof String) ) {
                k = 0;
                break;
            }
        }
        assertThat(k,is(equalTo(1)));
    }

    @Test
    public void put(){
        File jsondata=new File("src//test//resource//postdata.json");
        given().
                spec(reqSpe2).
                body(jsondata).
                when().
                put("/users").
                then().
                spec(resSpe).statusCode(200).log().status().log().body().log().headers();
    }
}
