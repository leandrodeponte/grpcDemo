package com.google.grpc.grpcDemo

import io.grpc.BindableService
import io.grpc.ServerBuilder
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GrpcDemoApplication(val services: List<BindableService>): ApplicationRunner {

	override fun run(args: ApplicationArguments?) {
		val serverBuilder = ServerBuilder
			.forPort(9090)
//			.addService(PersonService())
		services.forEach{
			serverBuilder.addService(it)
		}
		serverBuilder
			.build()
			.start()
	}
}

fun main(args: Array<String>) {
	runApplication<GrpcDemoApplication>(*args)
}
