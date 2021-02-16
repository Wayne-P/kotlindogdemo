package com.example.demo.repository

import com.example.demo.entity.Kennel
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface KennelRepository : Neo4jRepository<Kennel, Long>


