package nl.openvalue.restendpoints.database

import nl.openvalue.restendpoints.service.Temperature
import org.springframework.data.jpa.repository.JpaRepository

interface TemperatureRepository : JpaRepository<Temperature, Int>
