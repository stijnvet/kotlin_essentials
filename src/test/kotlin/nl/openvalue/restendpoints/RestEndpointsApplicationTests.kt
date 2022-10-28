package nl.openvalue.restendpoints

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class RestEndpointsApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `Expect that we get a json string containing the temperature in celsius and fahrenheit`() {
        mockMvc.get("/temperature")
            .andExpect {
                status { isOk() }
                jsonPath("$.celsius") { value(37) }
                jsonPath("$.fahrenheit") { value(100.0) }
            }
    }

}
