package mavrck.question.one

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class GrooupByCountControllerTests() {
    val FILEPATH = "/home/jolfr/Projects/Mavrck-Q1/src/main/resources/100 Sales Records.csv"
    val columns = listOf(1,2,3,4,5,6,7).toSet()
    lateinit var testController: GroupByCountController
    @BeforeEach
    fun setup() {
        testController = GroupByCountController(FILEPATH, columns)
    }


    fun `initialization succeeds`() {
        assertNotNull(testController)
    }

}