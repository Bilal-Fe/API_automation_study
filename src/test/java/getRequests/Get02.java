package getRequests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Comments;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get02 extends JsonPlaceHolderBaseUrl {
    /*
         When
             I send a GET Request to the URL https://jsonplaceholder.typicode.com/comments
         Then
             HTTP Status Code should be 200
        And
             Search all ids that are less than 30
             the number of ids less than 30 should be 29
     */
    @Test
    public void test1(){
        spec.pathParam("first","comments");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        List<Integer> actualIds = json.getList("findAll{it.id<30}.id");
        System.out.println("actual Id List "+actualIds);
        Assert.assertTrue("The expected data does not Match!", actualIds.size() == 29);


    }




    /**
    @Test
public void get11(){
    spec.pathParam("first", "comments");
    Response response = given().spec(spec).when().get("/{first}");
    //response.prettyPrint();
    response.then().statusCode(200);
    JsonPath json = response.jsonPath();
    List<Integer> idList = json.getList("findAll{it.id<30}.id");
    System.out.println(idList);
    assertTrue(idList.size()==29);
}
     */
    /*
         When
             I send a GET Request to the URL https://jsonplaceholder.typicode.com/comments
         Then
             HTTP Status Code should be 200
        And
             Search all ids and make sure there are 500 total records
             Use Pojo and deserialize them to Java
     */
    @Test
    public void test2(){
        spec.pathParam("first", "comments");
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();
        Comments[] comments = response.as(Comments[].class);

        for (int i=0; i<comments.length; i++)
            System.out.println(i+". name=> "+comments[i].getName());

        Assert.assertTrue("The expected data does not match!", comments.length == 500);

    }



}
