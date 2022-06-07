package com.herokuapp.booker.restful.bookinginfo;

import com.herokuapp.booker.restful.testbase.TestBase;
import com.herokuapp.booker.restful.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class BookingCURDWithStpes extends TestBase {
    static String username = "string" + TestUtils.getRandomValue();
    static String password="string"+TestUtils.getRandomValue();
    static int id;
    ValidatableResponse response;

    @Steps
   BookingSteps bookingSteps;

    @Title("This will create a new booking data")
    @Test
    public void test001() {
       bookingSteps.CreateTheBookinginfo(username,password).log().all();
//        response.log().all().statusCode(201);
//        id=response.extract().path("id");
//        System.out.println(id);
  }
    @Title("Verify if the servicesdata was added to the application")
    @Test
    public void test002() {
        response = bookingSteps.verifyAllbookingWithid(id);
        response.body("username", equalTo(username));

    }
    @Title("update the user information and verify the update info ")
    @Test
    public void test003 (){
        username=username+"_update03";
        ValidatableResponse response=bookingSteps.UpdateServiceId(id,username);
        response.log().all().statusCode(200);
        response = bookingSteps.verifyAllbookingWithid(id);
        response.body("username", equalTo(username));
    }
    @Title("Delete the product and verify if the product is deleted!")
    @Test
    public void test004() {
        bookingSteps.deletebookingId(id).statusCode(200);
        bookingSteps.verifybookingid(id).statusCode(404);

    }


}
