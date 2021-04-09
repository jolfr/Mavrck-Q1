package mavrck.question.one

import java.lang.IllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest
import kotlin.reflect.*

@SpringBootTest
class FileProcessorTests {
    @Test
    fun `object initializes`() {
        val processor = FileProcessor("testPath")
        assertNotNull(processor)
    }

    fun `iterate rows with proper path`() {

    }

    @Test
    fun `iterate rows throws IllegalArgumentException on bad path`() {
        fun testAggFunc(){} // MOCKS!!!
        assertThrows(IllegalArgumentException::class.java) {
            val processor = FileProcessor("BADPATH")
            processor.iterateRows(::testAggFunc)
        }
    }
}