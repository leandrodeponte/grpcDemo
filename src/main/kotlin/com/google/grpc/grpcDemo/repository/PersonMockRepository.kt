package com.google.grpc.grpcDemo.repository

import com.example.grpcDemo.adapters.grpc.person.PersonListResponse
import com.example.grpcDemo.adapters.grpc.person.PersonQuery
import com.example.grpcDemo.adapters.grpc.person.PersonRequest
import com.example.grpcDemo.adapters.grpc.person.PersonResponse
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class PersonMockRepository : PersonRepository {

    val people = mutableListOf<PersonResponse>()

    override fun find(query: PersonQuery): PersonListResponse = PersonListResponse.newBuilder()
        .addAllPersonListResponse(people)
        .build()

    override fun save(request: PersonRequest): PersonResponse = PersonResponse.newBuilder()
        .setId(Random.nextLong())
        .setName(request.name)
        .setCpf(request.cpf)
        .setEmail(request.email)
        .build().also { people.add(it) }

}