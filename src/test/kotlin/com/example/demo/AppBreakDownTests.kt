package com.example.demo

import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType

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

    @Test
    fun `when requests resources then set content type AppJson`() {
        RestAssured.given().port(port)
                .log().all()
                .get("/v1/resources")
                .then()
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
    }
}