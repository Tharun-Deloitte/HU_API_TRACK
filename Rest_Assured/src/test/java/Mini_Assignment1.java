import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class Mini_Assignment1 {

    @Test
    public void get(){
        RestAssured.useRelaxedHTTPSValidation();
        Response response=given().
                header("Content-type","application/json").
                when().
                get("https://jsonplaceholder.typicode.com/posts").
                then().
                statusCode(200).
                log().status().log().headers().extract().response();
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
        RestAssured.useRelaxedHTTPSValidation();
        File jsondata=new File("src//test//resource//postdata.json");
        given().
                body(jsondata).
                header("Content-type","application/json").
                when().
                get("https://reqres.in/api/users").
                then().
                statusCode(200).log().body().log().status().log().headers();

    }
    }
