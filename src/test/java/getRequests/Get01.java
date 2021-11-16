package geyRequests;

import base_urls.DummyApiBaseUrl;

public class Get01 extends DummyApiBaseUrl {
    /*
     When
         I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/
     Then
         HTTP Status Code should be 200
     And
         Content Type should be JSON
     And
        Make sure Rhona Davidson earns more than Herrod Chandler
       {
        "id": 7,
        "employee_name": "Herrod Chandler",
        "employee_salary": 137500,
        "employee_age": 59,
        "profile_image": ""
    },
    {
        "id": 8,
        "employee_name": "Rhona Davidson",
        "employee_salary": 327900,
        "employee_age": 55,
        "profile_image": ""
    },
 */
    /*
@Test
    public void test(){

//    Response response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
//    response.prettyPrint();

    spec.pathParams("first","api","second", "v1","third","employee","fourth",7);

    Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");
    response.prettyPrint();

    JsonPath json = response.jsonPath();
    System.out.println("employee_salary => "+json.getString("Data.employee_salary"));

    spec.pathParams("first","api","second", "v1","third","employee","fourth",8);

    Response response2 = given().spec(spec).get("/{first}/{second}/{third}/{fourth}");
    JsonPath json2 = response2.jsonPath();
    System.out.println("employee_salary => "+json2.getString("Data.employee_salary"));

    Assert.assertTrue(Integer.parseInt("data.employee_salary"))<Integer.parseInt(json2.getString("data.employee_salary"));
*/
/*
 @Test
    public void test(){
        spec.pathParams("first","api","second","v1","third","employee","final",7);
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        System.out.println("employee_salary => "+json.getString("data.employee_salary"));
        spec.pathParams("first","api","second","v1","third","employee","final",8);
        Response response2 = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        JsonPath json2 = response2.jsonPath();
//        System.out.println("employee_salary => "+json2.getString("data.employee_salary"));
        Assert.assertTrue("The expected data does not mstch!",Integer.parseInt(json.getString("data.employee_salary"))<Integer.parseInt(json2.getString("data.employee_salary")));
    }


    import base_urls.DummyAPi3BaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
 */
/*
{
        //1) Set the url
        spec.pathParams("first","api","second","v1","third","employee","final",7);

        //3) Type  automation script to send GET Request and get response
        Response response=given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response.prettyPrint();

        //4) Do assertion

        response.
                then().
                assertThat().statusCode(200).contentType(ContentType.JSON).
                body("data.id",equalTo(7),
                        "data.employee_name",equalTo("Herrod Chandler"),
                       "data.employee_salary",equalTo(137500),
                       "data.employee_age",equalTo(59));


        JsonPath json=response.jsonPath();

        spec.pathParams("first","api","second","v1","third","employee","final",8);

        Response response2=given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response.prettyPrint();

        JsonPath json2=response2.jsonPath();
       Assert.assertTrue(Integer.parseInt(json.getString("data.employee_salary"))<Integer.parseInt(json2.getString("data.employee_salary")));


    }
 */


}

