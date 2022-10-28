package nl.openvalue.restendpoints.service

import nl.openvalue.restendpoints.database.TemperatureRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock

import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class TemperatureServiceImplTest {

    @Mock
    lateinit var temperatureRepository: TemperatureRepository

    @InjectMocks
    lateinit var temperatureServiceImpl: TemperatureServiceImpl

    @Test
    fun getTemperature() {
        whenever(temperatureRepository.findAll()).thenReturn(
            listOf(Temperature(0, 37, 100.0F))
        )

        val expect = Temperature(0, 37, 100.0F)
        val result = temperatureServiceImpl.getTemperature()

        assertThat(result).isEqualTo(expect)
    }
}
