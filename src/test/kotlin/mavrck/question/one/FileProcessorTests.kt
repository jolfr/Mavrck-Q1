package mavrck.question.one

import java.lang.IllegalArgumentException
import org.mockito.Mockito
import org.mockito.Mock
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest
import kotlin.reflect.*

@SpringBootTest
class FileProcessorTests {
    val FILEPATH = "/home/jolfr/Projects/Mavrck-Q1/src/main/resources/100 Sales Records.csv"
    lateinit var processor: FileProcessor
    lateinit var mockFunction: GroupByCount
    lateinit var mockFactory: GroupByCountFactory

    @BeforeEach
    fun setup() {
        mockFunction = Mockito.mock(GroupByCount::class.java)
        mockFactory = Mockito.mock(GroupByCountFactory::class.java)
        Mockito.`when`(mockFactory.getFunction()).thenReturn(mockFunction)
    }


    @Test
    fun `initialization succeeds with proper path`() {
        processor = FileProcessor(FILEPATH)
        assertNotNull(processor)
    }

    @Test
    fun `initialization fails with improper path`() {
        assertThrows(IllegalArgumentException::class.java) {
            processor = FileProcessor("BAD PATH")
        }
    }

    @Test
    fun `calling iterateRows calls function for each row`() {
        processor = FileProcessor(FILEPATH)
        processor.iterateRows(mockFunction)

        val invocations = Mockito.mockingDetails(mockFunction).getInvocations();
        val numberOfCalls = invocations.size
        assertEquals(numberOfCalls, 100)
    }

}