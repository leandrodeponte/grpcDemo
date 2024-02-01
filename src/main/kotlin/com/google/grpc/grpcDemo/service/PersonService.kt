package com.google.grpc.grpcDemo.service

import com.example.grpcDemo.adapters.grpc.person.PersonListResponse
import com.example.grpcDemo.adapters.grpc.person.PersonQuery
import com.example.grpcDemo.adapters.grpc.person.PersonRequest
import com.example.grpcDemo.adapters.grpc.person.PersonResponse
import com.example.grpcDemo.adapters.grpc.person.PersonServiceGrpc.PersonServiceImplBase
import com.google.grpc.grpcDemo.repository.PersonRepository
import io.grpc.stub.StreamObserver
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) : PersonServiceImplBase() {

    override fun createPerson(
        request: PersonRequest?,
        responseObserver: StreamObserver<PersonResponse>?
    ) {
        val response = request?.let {
            personRepository.save(it)
        }
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun find(
        request: PersonQuery?,
        responseObserver: StreamObserver<PersonListResponse>?
    ) {
        val response = request?.let {
            personRepository.find(it)
        }
        println("""Esta frase 
            |ocupa mais de uma linha""".trimMargin())
        println("Esta frase"
            + "ocupa mais de"
            + "uma linha")
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

}