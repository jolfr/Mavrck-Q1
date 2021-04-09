package mavrck.question.one

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AggregationFunctionsTests {

    @Test
    fun `object initializes`(){
        val testObject = AggregationFunctions(1)
        assertNotNull(testObject)
    }
}

