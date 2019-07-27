package com.example.demo.config

import com.example.demo.model.Resource
import com.example.demo.repository.ResourceDao
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class DataInit {
    @Bean
    fun run(repository: ResourceDao) = ApplicationRunner {
        repository.save(Resource("123", "some value", 9000, "12:00:00"))
        repository.save(Resource("456", "another value", 1337, "14:45:00"))
    }
}