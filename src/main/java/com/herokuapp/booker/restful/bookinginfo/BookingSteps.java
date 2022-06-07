package com.herokuapp.booker.restful.bookinginfo;

import com.herokuapp.booker.restful.constants.EndPoints;
import com.herokuapp.booker.restful.model.BookingPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BookingSteps {
    @Step("Creating booking info with Name : {0} ")

    public ValidatableResponse CreateTheBookinginfo(String uname,String password){
       BookingPojo bookingPojo=new BookingPojo();
        bookingPojo.setUsername(uname);
        bookingPojo.setPassword(password);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(bookingPojo)
                .when()
                .post()
                .then();

    }
    @Step("Verify all booking  list with id: {0}")
    public ValidatableResponse verifyAllbookingWithid(int id){
        return SerenityRest.given()
                //  .contentType(ContentType.JSON)
                .pathParam("bookingID",id)
                .when()
                .get(EndPoints.GET_SINGLE_Booking)
                .then();

    }
    @Step("Update all booking data :{0}")
    public ValidatableResponse UpdateServiceId(int id,String uname){
        BookingPojo bookingPojo=new BookingPojo();
        bookingPojo.setUsername(uname);


        return  SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("bookingID",id)
                .body(bookingPojo)
                .when()
                .patch(EndPoints.UPDATE_Booking_BY_ID)
                .then();


    }
    @Step("Delete id:{0}")
    public ValidatableResponse deletebookingId(int id){
        return  SerenityRest.given().log().all()
                .pathParam("bookingID",id)
                .when()
                .delete(EndPoints.DELETE_Booking_BY_ID)
                .then();
    }
    @Step("verify that booking id is delete:{0}")
    public ValidatableResponse verifybookingid(int id){
        return SerenityRest.given().log().all()
                .pathParam("bookingID",id)
                .when()
                .get(EndPoints.GET_ALL_Booking)
                .then();

    }





}
