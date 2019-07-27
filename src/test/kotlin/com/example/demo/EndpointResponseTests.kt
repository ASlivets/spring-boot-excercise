package com.example.demo

import io.restassured.RestAssured
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EndpointResponseTests(@LocalServerPort val port: Int) {


    @Test
    fun testDateAsc() {
        RestAssured.given().port(port)
                .log().all()
                .queryParam("order", "ASC")
                .get("/v1/resources")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .header(HttpHeaders.ETAG, notNullValue())
                .header(HttpHeaders.CACHE_CONTROL, "max-age=10")
                .body("", notNullValue())
                .body("[0].id", equalTo("123"))
                .body("[0].value1", equalTo("some value"))
                .body("[0].value2", equalTo(9000))
                .body("[0].createdAt", equalTo("12:00:00"))
                .body("[1].id", equalTo("456"))
                .body("[1].value1", equalTo("another value"))
                .body("[1].value2", equalTo(1337))
                .body("[1].createdAt", equalTo("14:45:00"))
    }

    @Test
    fun testDateDesc() {
        RestAssured.given().port(port)
                .log().all()
                .queryParam("order", "DESC")
                .get("/v1/resources")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .header(HttpHeaders.ETAG, notNullValue())
                .header(HttpHeaders.CACHE_CONTROL, "max-age=10")
                .body("", notNullValue())
                .body("[0].id", equalTo("456"))
                .body("[0].value1", equalTo("another value"))
                .body("[0].value2", equalTo(1337))
                .body("[0].createdAt", equalTo("14:45:00"))
                .body("[1].id", equalTo("123"))
                .body("[1].value1", equalTo("some value"))
                .body("[1].value2", equalTo(9000))
                .body("[1].createdAt", equalTo("12:00:00"))
    }
}