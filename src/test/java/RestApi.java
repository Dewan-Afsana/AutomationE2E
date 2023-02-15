import io.restassured.RestAssured;
import org.checkerframework.checker.index.qual.LessThan;
import org.testng.annotations.Test;

public class RestApi {
    @Test
    public void getMethodCall() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        given().queryParam("page", "2").header("Content-Type", "application/json").
                when().get().
                then().log().all()
                .assertThat().statusCode(200)
                .assertThat().time(LessThan(5000L))
                .assertThat().header("Content-Type", "application/json", "charset=utf-8")
                .header("connection", "keep-alive")
                .assertThat().body("page", equalTo(2));
    }
    }
}
