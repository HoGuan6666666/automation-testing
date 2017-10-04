package com.ecvictor.api;

import com.ecvictor.api.rest.assured.o2o.RestAssuredUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class WPTestHomework {

    @BeforeClass
    public static void setup() {

        RestAssuredUtil.setup();
    }

    @Test
    public void
    wordpress_login_with_created_credential_returns_200() {
        given()
                .param("username", "hoggg6666")
                .param("password", "1qazxsw2")
                .param("client_id", "39911")
                .param("client_secret", "cOaYKdrkgXz8xY7aysv4fU6wL6sK5J8a6ojReEIAPwggsznj4Cb6mW0nffTxtYT8")
                .expect().statusCode(200)
                .expect().body("success", equalTo(true))
                .when()
                .post("/wp-login.php?action=login-endpoint");
//                .body("message", equalTo("Invalid post ID."));
    }
}
