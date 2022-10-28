package nl.openvalue.restendpoints.service

import nl.openvalue.restendpoints.events.MyEvent
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
@Profile("prod")
class EventListener {
    private val log by lazy { LoggerFactory.getLogger(javaClass) }

    @EventListener
    fun listenForEvents(myEvent: MyEvent) {
        val result = myEvent.temperature
        log.info("Returning temperature: celsius[{}] fahrenheit [{}]", result.celsius, result.fahrenheit)
    }

}
