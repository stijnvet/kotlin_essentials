package nl.openvalue.restendpoints.web

import nl.openvalue.restendpoints.service.Temperature
import nl.openvalue.restendpoints.service.TemperatureService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TemperatureController(val temperatureService: TemperatureService) {

    @GetMapping("/temperature")
    fun getTemperature(): ResponseEntity<Temperature> {
        val temperature = temperatureService.getTemperature()
        return ResponseEntity.ok(temperature)
    }
}


