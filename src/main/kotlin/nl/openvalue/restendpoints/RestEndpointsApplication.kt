package nl.openvalue.restendpoints

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestEndpointsApplication

fun main(args: Array<String>) {
	runApplication<RestEndpointsApplication>(*args)
}
