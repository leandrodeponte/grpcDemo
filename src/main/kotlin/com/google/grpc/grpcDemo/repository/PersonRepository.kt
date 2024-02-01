package com.google.grpc.grpcDemo.repository

import com.example.grpcDemo.adapters.grpc.person.PersonListResponse
import com.example.grpcDemo.adapters.grpc.person.PersonQuery
import com.example.grpcDemo.adapters.grpc.person.PersonRequest
import com.example.grpcDemo.adapters.grpc.person.PersonResponse

interface PersonRepository {

    fun find(query: PersonQuery): PersonListResponse

    fun save(request: PersonRequest): PersonResponse

}