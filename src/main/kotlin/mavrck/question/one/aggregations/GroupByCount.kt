package mavrck.question.one

import kotlin.collections.MutableSet
import kotlin.collections.MutableMap.MutableEntry
/**
 * Concrete implementation of abstract AggFuncFactory
 */
open class GroupByCountFactory(): AggFuncFactory() { // classes have to be open for mockito :(
    override fun getFunction(colsOfInterest: Set<Int>) = GroupByCount(colsOfInterest)
}

/**
 * Concrete implmenetation of interface AggFunc
 * @param colsOfInterest set of column numbers to perform aggregations on
 * @return function which is ready to be used by a file processor
 */
open class GroupByCount(colsOfInterest: Set<Int>): AggFunc {
    override val columns: Set<Int>
    init {
        columns = colsOfInterest
    }
    var aggEntries: MutableMap<List<String>, Int> = mutableMapOf()

    /**
     * Processes a single row of the dataframe by first getting the cells of interest,
     * and then checking against the existing list with AddOrAppend
     * @param row 
     */
    override fun processRow(row: List<String>?): Unit {
        val entries = getEntriesOfInterest(row)
        AddOrAppend(entries!!)
    }

    /**
     * Helper function. Filters row object by columns selected by user
     * @param row
     * @return Same object, just with fewer entries
     */
    fun getEntriesOfInterest(row: List<String>?): List<String>? {
        var result = mutableListOf<String>()
        columns.forEach{ result.add(row!!.get(it)) }
        return result
    }

    /**
     * Helper function. If entries exists in the final structure, then increment that count by one. 
     * Otherwise, append structure to end of the list.
     * @param entries Entries of columns that have been previously selected
     */
    fun AddOrAppend(entries: List<String>) {
        var count: Int
        if(aggEntries.containsKey(entries)) {
            count = aggEntries[entries]!!.plus(1)
        } else {
            count = 1
        }
        aggEntries.put(entries, count)
    }
}