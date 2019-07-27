package com.example.demo.repository

import com.example.demo.model.Resource
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceDao : PagingAndSortingRepository<Resource, Long>