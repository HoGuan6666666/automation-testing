package com.ecvictor.api.rest.assured.o2o.twitter;

/**
 * Created by caoc on 3/24/2017.
 */

import com.ecvictor.api.rest.assured.o2o.RestAssuredUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.Properties;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class TimelineTest {
    private String token;
    Properties prop = RestAssuredUtil.getProperties();

    @BeforeClass
    public static void setup() {
        RestAssuredUtil.setup();
        {
            RestAssuredUtil.setup();

        }
    }

    /**
     * Should not be able to access.
     */
    @Test
    public void testGetUserTimeline() {
        expect().statusCode(200)
                .body("[0].id_str", equalTo("850726222111924225"))
                .log().all()
                .contentType("application/json;charset=utf-8")
                .given().auth().oauth("XmSm0xDZB6FJlEliDJhRMEEPY","XtJV5zXKUhGkBQtDZ0ETmX1n8s3SSu5yM72pTSMgjhhBXNrRrr",
                "846843580882866176-rgW5abXjp2KJZwqUSSgFa3ayNQ8jRzL","Z6Xwl8HryhevFxlagXbVFILeQlaVATGZQVMvlpUKalAn3")
                .when().get("https://api.twitter.com/1.1/statuses/user_timeline.json");
    }    /**
     * Should not be able to access.
     */
    @Test
    public void testPostUserTimeline() {
        expect().statusCode(200);
        expect().body("id_str", equalTo(Collections.singletonList("848231288238735362")))
                .contentType("application/json;charset=utf-8")
                .given().auth().oauth("FZgc5QTn0OIW8Qvln7F6pdoi6","WoqPhr1HrwsjdYKnyAj3BScMD6Dd8K6SsvZxxPCjF41YFMrTuR",
                "846843580882866176-nftaoCwd5WQKZz11KBZoq6MBEG9AcNf","3yK3sI82l4ZMR0e2HKgLgIQ68g2TssxEoodG1OuzSsPsX")
                .param("status", "Post from Rest Assured")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
    }


}