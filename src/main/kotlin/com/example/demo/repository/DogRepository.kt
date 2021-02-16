package com.example.demo.repository

import com.example.demo.entity.Dog
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface DogRepository : Neo4jRepository<Dog, Long>


