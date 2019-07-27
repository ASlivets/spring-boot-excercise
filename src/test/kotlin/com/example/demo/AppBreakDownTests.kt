package com.example.demo

import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppBreakDownTests (@LocalServerPort val port: Int) {

    @Test
    fun `when get resources then status code is 200`() {
        RestAssured.given().port(port)
                .log().all()
                .get("/v1/resources")
                .then()
                .statusCode(200)
    }
}