package com.example.demo.controller

import com.example.demo.config.Const.CACHE_AGE_IN_SEC
import com.example.demo.model.Resource
import com.example.demo.repository.ResourceDao
import org.springframework.data.domain.Sort
import org.springframework.http.CacheControl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
class ResourceController(val repository: ResourceDao) {

    @RequestMapping("/v1/resources")
    fun resources(@RequestParam("order", required = false, defaultValue = "ASC") order: String): ResponseEntity<MutableIterable<Resource>> {
        val resources = repository.findAll(Sort.by(Sort.Direction.fromString(order), "id"))
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(CACHE_AGE_IN_SEC, TimeUnit.SECONDS))
                .eTag(resources.hashCode().toString())
                .body(resources)
    }
}