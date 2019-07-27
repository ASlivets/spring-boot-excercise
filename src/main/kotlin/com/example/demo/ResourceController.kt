package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ResourceController {

    @RequestMapping("/v1/resources")
    fun payment(): Int{
        return 42
    }
}