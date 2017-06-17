package com.ecvictor.api.rest.assured.o2o.ecvicms;

/**
 * Created by caoc on 3/24/2017.
 */


import com.ecvictor.api.rest.assured.o2o.RestAssuredUtil;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.Properties;

import static com.ecvictor.api.rest.assured.o2o.RestAssuredUtil.getProperties;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class WPDemoTest {

    @BeforeClass
    public static void setup() {
        RestAssuredUtil.setup();
    }

    @Test
    public void testGetPostById() {

        String content =
                given()
                        .when()
                        .get("/wp-json/wp/v2/posts/35").
                        then().
                        body("title.rendered", equalTo("Quia corrupti quaerat et mollitia")).
                        extract().
                        path("content.rendered");
        if (content == null)
            System.out.println("content not exist");
    }

    @Test
    public void testGetPostNotExsit() {
        given()
                .when()
                .get("/wp-json/wp/v2/posts/2")
                .then()
                .statusCode(404)
                .body("message", equalTo("Invalid post ID."));
    }


}