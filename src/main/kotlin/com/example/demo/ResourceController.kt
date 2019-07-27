package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ResourceController {

    @RequestMapping("/v1/resources")
    fun payment(): Resource{
        return Resource("123","some value", 9000, Date())
    }
}