package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {
    //Create an Object in RequestSpecification Data type
    protected RequestSpecification spec;

    //If you use @Before annotation at the top of a method, it means the method will be executed before every tst method
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }

}
