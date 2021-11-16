package post_methods;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
     /*
        Given    https://jsonplaceholder.typicode.com/comments
            {
                "name": "This class has smart people",
                "postId": 80,
                "id": 503,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
            When I send Post Request to the URL
            Then the status code should be 201
            Response should be like
                 {
                "name": "This class has smart people",
                "postId": 80,
                "id": 503,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
         */
    /*
     @Test
     public void post01(){
         spec.pathParam("first", "comments");

         Map<String, Object> requestBody = new HashMap<>();
         requestBody.put("name", "This class has smart people");
         requestBody.put("postId", 80);
         requestBody.put("id", 503);
         requestBody.put("body", "Congratulations Everyone");
         requestBody.put("email", "techproedstudents@gmail.com");

         Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBody).post("/{first}");
         response.prettyPrint();

         Map<String, Object> actualData = response.as(HashMap.class);

         assertEquals(requestBody.get("name"), actualData.get("name"));
         assertEquals(requestBody.get("postId"), actualData.get("postId"));
         assertEquals(requestBody.get("body"), actualData.get("body"));
         assertEquals(requestBody.get("email"), actualData.get("email"));
         // assertEquals(requestBody.get("id"), actualData.get("id"));
     }
     */
    @Test
    public void test01(){
        spec.pathParam("first","comments");

        Map<String, Object> expecteData = new HashMap<>();
        expecteData.put("name","This class has smart people");
        expecteData.put("postId", 80);
        expecteData.put("id",503);
        expecteData.put("body", "Congratulations Everyone");
        expecteData.put("email", "techproedstudents@gmail.com");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expecteData).when().post("/{first}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("expected Data=>"+expecteData);
        System.out.println("actual Data=>"+actualData);

        assertEquals(expecteData,actualData);

        assertEquals(expecteData.get("name"),actualData.get("name"));

    }
}

//package post_methods;
//import base_urls.JsonPlaceHolderBaseUrl;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.junit.Test;
//import java.util.HashMap;
//import java.util.Map;
//import static io.restassured.RestAssured.given;
//import static org.testng.AssertJUnit.assertEquals;
//public class Post01  extends JsonPlaceHolderBaseUrl {
//    @Test
//    public void test01(){
//        /*
//        Given    https://jsonplaceholder.typicode.com/comments
//            {
//                "name": "This class has smart people",
//                "postId": 82,
//                "id": 501,
//                "body": "Congratulations Everyone",
//                "email": "techproedstudents@gmail.com"
//            }
//            When I send Post Request to the URL
//            Then the status code should be 201
//            Response should be like
//                 {
//                "name": "This class has smart people",
//                "postId": 82,
//                "id": 501,
//                "body": "Congratulations Everyone",
//                "email": "techproedstudents@gmail.com"
//            }
//         */
//        spec.pathParam("first","comments");
//                Map<String, Object> expectedData = new HashMap<>();
//        expectedData.put("name","This class has smart people");
//        expectedData.put("postId",82);
//        expectedData.put("id",501);
//        expectedData.put("body","Congratulations Everyone");
//        expectedData.put("email","techproedstudents@gmail.com");
//        Response response  = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
//        response.prettyPrint();
//        Map<String, Object> actualData = response.as(HashMap.class);
//        System.out.println("expectedData => "+expectedData);
//        System.out.println("actualData => "+actualData);
//        assertEquals(expectedData,actualData);
//        assertEquals(expectedData.get("name"),actualData.get("name"));
//        }
//        }

