package mavrck.question.one

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import kotlin.reflect.*

class GroupByCountTests{
    lateinit var groupByCount: GroupByCount
    @BeforeEach
    fun setup() {
        val cols = (0..2).toSet()
        groupByCount = GroupByCount(cols)
    }

    @Test
    fun `object initializes`() {
        assertNotNull(groupByCount)
    }

    @Test
    fun `getEntriesOfInterest returns cells of interest`() {
        val row: List<String>? = listOf("zero", "one", "two", "three", "four")
        val actual = groupByCount.getEntriesOfInterest(row)
        val expected = row?.subList(0,3)
        assertNotNull(actual)
        assertLinesMatch(expected, actual)
    }
}