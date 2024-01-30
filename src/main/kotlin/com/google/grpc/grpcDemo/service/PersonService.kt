package com.google.grpc.grpcDemo.service

import com.example.grpcDemo.adapters.grpc.person.PersonRequest
import com.example.grpcDemo.adapters.grpc.person.PersonResponse
import com.example.grpcDemo.adapters.grpc.person.PersonServiceGrpc.PersonServiceImplBase
import io.grpc.stub.StreamObserver
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class PersonService : PersonServiceImplBase() {

    override fun createPerson(request: PersonRequest?, responseObserver: StreamObserver<PersonResponse>?) {
        val response = request?.let {
            PersonResponse.newBuilder()
                .setId(Random.nextLong())
                .setName(it.name)
                .setCpf(it.cpf)
                .setEmail(it.email)
                .build()
        }
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

}