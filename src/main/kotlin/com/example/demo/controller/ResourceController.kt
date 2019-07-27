package com.example.demo.controller

import com.example.demo.config.Const.CACHE_AGE_IN_SEC
import com.example.demo.model.Resource
import org.springframework.http.CacheControl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
class ResourceController {

    @RequestMapping("/v1/resources")
    fun payment(): ResponseEntity<Resource> {
        val resource = Resource("123", "some value", 9000, "12:00:00")
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(CACHE_AGE_IN_SEC, TimeUnit.SECONDS))
                .eTag(resource.hashCode().toString())
                .body(resource)
    }
}