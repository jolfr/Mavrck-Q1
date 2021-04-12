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
 */
open class GroupByCount(colsOfInterest: Set<Int>): AggFunc {
    override val columns: Set<Int>
    init {
        columns = colsOfInterest
    }
    var aggEntries: MutableMap<List<String>, Int> = mutableMapOf()

    override fun processRow(row: List<String>?): Unit {
        val entries = getEntriesOfInterest(row)
        AddOrAppend(entries!!)
    }

    fun getEntriesOfInterest(row: List<String>?): List<String>? {
        var result = mutableListOf<String>()
        columns.forEach{ result.add(row!!.get(it)) }
        return result
    }

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