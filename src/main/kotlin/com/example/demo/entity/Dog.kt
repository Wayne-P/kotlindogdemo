package com.example.demo.entity

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class Dog constructor(@Id @GeneratedValue val id: Long? = null, val name: String)