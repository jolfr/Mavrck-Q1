package mavrck.question.one

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FileProcessorTests {
    @Test
    fun `object initializes`() {
        val testAggFunc = fun (_ : Array<List<String>?>){}
        val processor = FileProcessor("testPath", testAggFunc)
        assertNotNull(processor)
    }
}