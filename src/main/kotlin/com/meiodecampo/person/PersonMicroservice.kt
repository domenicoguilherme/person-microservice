package com.meiodecampo.person

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(
	servers = [Server(url = "\${SERVER_CONTEXT_PATH:/}")]
)
@SpringBootApplication
class PersonMicroservice

fun main(args: Array<String>) {
	runApplication<PersonMicroservice>(*args)
}