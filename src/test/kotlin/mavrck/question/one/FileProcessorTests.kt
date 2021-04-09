package mavrck.question.one

import java.lang.IllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class FileProcessorTests {
    @Test
    fun `object initializes`() {
        val testAggFunc = fun (_ : Array<List<String>?>){} // MOCKS!!!
        val processor = FileProcessor("testPath", testAggFunc)
        assertNotNull(processor)
    }

    fun `iterate rows with proper path`() {

    }

    fun `iterate rows throws IllegalArgumentException on bad path`() {
        val testAggFunc = fun (_ : Array<List<String>?>){} // MOCKS!!!
        assertThrows(IllegalArgumentException::class.java) {
            val processor = FileProcessor("BADPATH", testAggFunc)
            processor.iterateRows()
        }
    }
}