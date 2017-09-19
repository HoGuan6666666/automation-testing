package com.ecvictor.api;

import cucumber.api.java.en.Given;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.apache.commons.lang3.StringUtils.containsOnly;
import static org.hamcrest.core.IsEqual.equalTo;

public class GoogleAPI {
    @Test
    public void
    o2o_loign_returns_200_with_expected_formatted_user_information() {
        given().param("username", "test001@gmail.com").param("password", "123456h").expect().
                statusCode(200).
                expect().body("user.userName", equalTo("test001@gmail.com")).
                expect().body("user.active", equalTo(1)).
                when().
                post("http://192.168.88.187:8080/o2oeat/api/login.json");

    }
}
