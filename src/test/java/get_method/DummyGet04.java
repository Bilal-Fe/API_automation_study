package get_method;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DummyGet04 extends DummyApiBaseUrl {
    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
            This user exists in the system
            "status": "success",
            "data": {
                "id": 5,
                "employee_name": "Airi Satou",
                "employee_salary": 162700,
                "employee_age": 33,
                "profile_image": ""
            },
    "message": "Successfully! Record has been fetched."
        },
     */
    @Test
    public void test04() {
        spec.pathParams("first", "api", "second", "v1", "third", "employee","fourth",5);
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON).
                body("status", equalTo("success")).
                body("data.id",equalTo(5)).
                body("data.employee_name", equalTo("Airi Satou")).
                body("data.employee_salary", equalTo(162700)).
                body("data.employee_age",equalTo(33)).
                body("message",equalTo("Successfully! Record has been fetched."));
    }


}
