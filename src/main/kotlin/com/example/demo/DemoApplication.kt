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
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.annotation.Transactional

@SpringBootApplication
@EnableNeo4jRepositories
@Transactional
class DemoApplication{
    @Bean
    fun init (kennelRepository: KennelRepository, dogRepository:DogRepository): CommandLineRunner {
        return CommandLineRunner {
            kennelRepository.deleteAll()
            dogRepository.deleteAll ()
            val dogFido = Dog(name = "fido")
            // fido saves correctly
            dogRepository.save<Dog>(dogFido)
            val dogRover = Dog(name = "rover")
            val kennelForRover = Kennel(dog = dogRover)
            // kennelforRover does not save correctly
            kennelRepository.save<Kennel>(kennelForRover)
            print("complete")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
