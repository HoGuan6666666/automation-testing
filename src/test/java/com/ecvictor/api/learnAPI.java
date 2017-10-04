package com.ecvictor.api;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;


public class learnAPI {

    @Before
    public void setup(){
        RestAssured.baseURI = "https://maps.googleapis.com/maps/api/";
        RestAssured.port = 8080;
        RestAssured.config.getSSLConfig().relaxedHTTPSValidation();
    }

    @Test
    public void
    google_map_search_with_geocode_returns_200_with_expected_formatted_address() {
        when().
                get("geocode/json?address=香港&language=zh-CN").
                then().
                statusCode(200).
                body("results[0].formatted_address", equalTo("香港"));
    }

    @Test
    public void
    google_map_search_with_place_returns_200_with_expected_formatted_address() {
        when().
                get("geocode/json?address=Rue+du+Fort+Street+Montreal").
                then().
                statusCode(200).
                body("results[0].address_components[2].long_name", equalTo("Montréal"));
    }

    @Test
    public void
    google_map_search_with_direction_returns_200_with_expected_formatted_address() {
        when().
                get("directions/json?origin=Toronto&destination=Montreal").
                then().
                statusCode(200).
                body("routes[0].copyrights", equalTo("Map data ©2017 Google"));
    }

    @Test
    public void
    google_map_search_with_direction_returns_200() {
        expect().
                statusCode(200).
                body("geocoded_waypoints[0].geocoder_status", equalTo("OK")).
                when().
                get("directions/json?origin=Montreal&destination=Toronto");
    }
    @Test
    public void
    o2oeat_login_returns_200_with_expected_formatted() {
        given().param("username", "hoggg@gmail.com").param("password", "1qazxsw2")
                .expect()
                .statusCode(200).
                expect().body("user.userName", equalTo("hoggg@gmail.com")).
                expect().body("role[0].name", equalTo("Customer")).
                expect().body("role[0].type", equalTo("1")).
        when().
                post("http://192.168.88.187:8080/o2oeat/api/login.json");
    }

    @Test
    public void
    o2oeat_change_pwr_returns_200_with_expected_formatted() {
        given().
                header("username", "hoggg@gmail.com").
                header("authzCode", "827fc0d919af2c40c6da6984f222700bc059229ab0bdcefb1d0094b0d7f91972").
                and().
                param("oldPassword", "1qazxsw2").param("newPassword", "1qazxsw2").
                expect().
                statusCode(200).
//                expect().body("message", equalTo("Fail! Cause: Old password isn't correct!")).
                when().
                    post("http://192.168.88.187:8080/o2oeat/customers/api/myAccount/changePassword");
    }
}
