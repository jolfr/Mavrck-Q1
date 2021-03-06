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

    @Test
    fun `AddOrAppend adds two counts`() {
        val row: List<String> = listOf("zero", "one", "two")
        groupByCount.AddOrAppend(row)
        groupByCount.AddOrAppend(row)
        assertTrue(groupByCount.aggEntries.containsKey(row))
        val count = groupByCount.aggEntries.get(row)
        assertEquals(count, 2)
    }

    @Test
    fun `AddOrAppend appends new entry to list`() {
        val row1: List<String> = listOf("zero", "one", "two")
        val row2: List<String> = listOf("three", "four", "five")
        groupByCount.AddOrAppend(row1)
        groupByCount.AddOrAppend(row2)
        assertTrue(groupByCount.aggEntries.containsKey(row1))
        assertTrue(groupByCount.aggEntries.containsKey(row2))
        val count1 = groupByCount.aggEntries.get(row1)
        val count2 = groupByCount.aggEntries.get(row2)
        assertEquals(count1, 1)
        assertEquals(count2, 1)
    }
}