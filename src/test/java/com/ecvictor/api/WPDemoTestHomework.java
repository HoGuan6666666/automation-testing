package com.ecvictor.api;

/**
 * Created by caoc on 3/24/2017.
 */


import com.ecvictor.api.rest.assured.o2o.RestAssuredUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class WPDemoTestHomework {

    @BeforeClass
    public static void setup() {

        RestAssuredUtil.setup();
    }

    @Test
    public void
    wordpress_demo_posts_test_by_id() {

        String content =
                given()
                        .when()
                        .get("/wp-json/wp/v2/posts/1").
                        then().

                        body("title.rendered", equalTo("Hello world!")).
                        extract().
                        path("content.rendered");
        if (content == null)
            System.out.println("content not exist");
    }

    @Test
    public void
    wordpress_demo_posts_test_return_invalid_post_id() {
        given()
                .when()
                .get("/wp-json/wp/v2/posts/2")
                .then()
                .statusCode(404)
                .body("message", equalTo("Invalid post ID."));
    }

    @Test
    public void
    wordpress_demo_categories_test_by_id() {
        when()
                .get("/wp-json/wp/v2/categories/1")
                .then()
                .body("name", equalTo("Uncategorized"));
    }

    @Test
    public void
    wordpress_demo_tags_test_by_id() {
        when()
                .get("/wp-json/wp/v2/tags/6")
                .then()
                .body("name", equalTo("Eum non dolorem ducimus libero"));
    }

    @Test
    public void
    wordpress_demo_comments_test_by_author_name() {
        given()
                .param("author_name", "A WordPress Commenter")
                .expect()
                .statusCode(200)
                .expect()
                .body("author_url", equalTo("http://wp-api.org/"))
        .when()
                .get("/wp-json/wp/v2/comments/1");
    }

    @Test
    public void
    wordpress_demo_search_test_returns_formatted_results() {
        given()
                .param("s", "s")
                .expect()
                .statusCode(200)
                .when()
                .get();
    }

//    @Test
//    public void
//    wordpress_demo_comments_post_test_returns_200() {
//        given()
//                .param("comment", "I dunno how it worked, but I've tired a couple of times already.")
//                .param("author", "HoGGG6666")
//                .param("hoggg@hoggg.com")
//                .expect()
//                .statusCode(200)
//                .when()
//                .post("/wp-comments-post.php");
//    }
}