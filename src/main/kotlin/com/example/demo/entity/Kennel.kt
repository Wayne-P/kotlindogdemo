package com.example.demo.entity

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Kennel constructor (@Id @GeneratedValue val id: Long? = null, @Relationship val dog: Dog) {
    fun withId(id: Long): Kennel {
        return if (this.id == id) {
            this
        } else {
            this.copy(id = id)
        }
    }
}