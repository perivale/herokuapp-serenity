package com.herokuapp.booker.restful.testbase;


import com.herokuapp.booker.restful.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;


/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
      //  RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
       // RestAssured.basePath = Path;
    }

}
