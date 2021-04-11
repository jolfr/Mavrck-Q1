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
    lateinit var processor: FileProcessor
    lateinit var mockFunction: GroupByCount
    lateinit var mockFactory: GroupByCountFactory

    @BeforeEach
    fun setup() {
        processor = FileProcessor("/home/jolfr/Projects/Mavrck-Q1/src/main/resources/100 Sales Records.csv")
        mockFunction = Mockito.mock(GroupByCount::class.java)
        mockFactory = Mockito.mock(GroupByCountFactory::class.java)
        Mockito.`when`(mockFactory.getFunction()).thenReturn(mockFunction)
    }


    @Test
    fun `object initializes`() {
        assertNotNull(processor)
    }
}