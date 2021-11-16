package post_http_request_method;

import Utils.JsonUtil;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.HerOkuAppPostResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostGetWithObjectMapperAndPojo01 extends HerOkuAppBaseUrl {
    /*
        Given
	        https://restful-booker.herokuapp.com/booking

	        {
                "firstname": "Selim",
                "lastname": "Ak",
                "totalprice": 11111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-09",
                    "checkout": "2021-09-21"
                 },
                 "additionalneeds": "Breakfast
              }
        When
	 		I send POST Request to the Url
	   And
	        I send GET Request to the Url
	 	Then
	 		Status code is 200
	 	And
	 	    GET response body should be like {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        },
                                                     "additionalneeds": "Breakfast
											    }
     */
    @Test
    public void postGetWithObjectMapperAndPojo01(){
                //TO SEND POST REQUEST WE DID 1.STEP, 2.STEP, 3.STEP
        //1.Step: Set the url
        spec.pathParam("first","booking");

        //2.Step: Set the request body
        BookingDatesPojo bookingDates = new BookingDatesPojo("2021-09-09", "2021-09-21");
        BookingPojo requestBody = new BookingPojo("Selim","Ak",1111, true, bookingDates, "Breakfast");
        System.out.println(requestBody);

        //3.Step: Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBody).when().post("/{first}");
        response.prettyPrint();

                //CONVEEEEEERT POOST RESPONSE BODY  TO JAVA OJECT VY USING OBJECT MAPPER
        HerOkuAppPostResponseBodyPojo postResponseBodyInPojo = JsonUtil.convertJsonToJava(response.asString(), HerOkuAppPostResponseBodyPojo.class);
        System.out.println(postResponseBodyInPojo);

                //FROM postResponseBodyInPojo WE GOT THE VALUE OF bookingId by using GETTER of bookingId
        Integer bookingId = postResponseBodyInPojo.getBookingid();

                //BY USING bookingId I WILL SEND GET REQUEST IN 1.STEP, 2.STEP, 3.STEP
        //1.Step: Set the url for GET Request
        spec.pathParams("first", "booking", "second", bookingId);

        //2.Step:Set the expected data
        //No need to create expected data because the data is sent in the POST Request will be expected data

        //3.Step: Send the Get request and get the response
        Response response2 = given().spec(spec).when().get("/{first}/{second}");
        response2.prettyPrint();

                //I CONVERT GET RESPONSE BODY TOO JAVA OBJECT BY USING OBJECT MAPPER
        BookingPojo getResponseBodyPojo = JsonUtil.convertJsonToJava(response2.asString(), BookingPojo.class);

                //BY USING request and postResponseBodyInPojo, I DID ASSERTIONS
        //4.Step: Do assertion
        assertEquals(200, response2.getStatusCode());

        assertEquals(requestBody.getFirstname(), getResponseBodyPojo.getFirstname());
        assertEquals(requestBody.getLastname(), getResponseBodyPojo.getLastname());
        assertEquals(requestBody.getTotalprice(), getResponseBodyPojo.getTotalprice());
        assertEquals(requestBody.getDepositpaid(), getResponseBodyPojo.getDepositpaid());
        assertEquals(requestBody.getBookingdates().getCheckin(), getResponseBodyPojo.getBookingdates().getCheckin());
        assertEquals(requestBody.getBookingdates().getCheckout(), getResponseBodyPojo.getBookingdates().getCheckout());
        assertEquals(requestBody.getAdditionalneeds(), getResponseBodyPojo.getAdditionalneeds());




    }
}
