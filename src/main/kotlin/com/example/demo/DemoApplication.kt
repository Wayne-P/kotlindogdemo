package com.example.demo

import com.example.demo.entity.Dog
import com.example.demo.entity.Kennel
import com.example.demo.repository.DogRepository
import com.example.demo.repository.KennelRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.Transactional

@SpringBootApplication
@EnableNeo4jRepositories
@Transactional
class DemoApplication{
    @Bean
    fun init (kennelRepository: KennelRepository, dogRepository:DogRepository): CommandLineRunner {
        return CommandLineRunner {
            kennelRepository.deleteAll()
            dogRepository.deleteAll()
            var dogFido: Dog = Dog(name = "fido")
            dogRepository.save<Dog>(dogFido)
            var dogRover: Dog = Dog(name = "rover")
            var kennelForRover: Kennel = Kennel(dog = dogRover)
            kennelRepository.save<Kennel>(kennelForRover)
            print("complete")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
