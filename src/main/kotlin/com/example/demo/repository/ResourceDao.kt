package com.example.demo.repository

import com.example.demo.model.Resource
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceDao : CrudRepository<Resource, Long>