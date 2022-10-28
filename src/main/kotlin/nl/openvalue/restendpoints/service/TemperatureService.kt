package nl.openvalue.restendpoints.service

import nl.openvalue.restendpoints.database.TemperatureRepository
import nl.openvalue.restendpoints.events.MyEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Service
class TemperatureServiceImpl(val temperatureRepository: TemperatureRepository, val eventPublisher: ApplicationEventPublisher) : TemperatureService {

    override fun getTemperature(): Temperature {
        val result = temperatureRepository.findAll().first().also {
            eventPublisher.publishEvent(MyEvent(it))
        }

        return result
    }
}

interface TemperatureService {
    fun getTemperature(): Temperature
}

@Entity
@Table(name = "temperature")
data class Temperature(
    @Id var id: Int? = null,
    var celsius: Int? = null,
    var fahrenheit: Float? = null
)
