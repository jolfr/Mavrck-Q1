package mavrck.question.one

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest
import kotlin.reflect.*

@SpringBootTest
class AggregationFunctionsTests {

    @Test
    fun `object initializes`(){
        val testObject = AggregationFunctions(1)
        assertNotNull(testObject)
    }

    @Test
    fun `calling groupbycount factory returns function`(){
        val testObject = AggregationFunctions(1)
        val testAggFunc = testObject.GroupByCountFactory()
        assertTrue(testAggFunc is KFunction)
    }
}

