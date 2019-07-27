package com.example.demo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Resource")
data class Resource(
        @Id
        @Column
        var id: String = "",
        @Column
        var value1: String = "",
        @Column
        var value2: Int = -1,
        @Column
        var createdAt: String = ""
)