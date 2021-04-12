package mavrck.question.one

import kotlin.collections.MutableSet
import kotlin.collections.MutableMap.MutableEntry
// classes have to be open for mockito :(
open class GroupByCountFactory(): AggFuncFactory() {
    override fun getFunction(colsOfInterest: Set<Int>) = GroupByCount(colsOfInterest)
}

open class GroupByCount(colsOfInterest: Set<Int>): AggFunc {
    override val columns: Set<Int>
    init {
        columns = colsOfInterest
    }
    var aggEntries: MutableMap<List<String>, Int> = mutableMapOf()

    override fun processRow(row: List<String>?): Unit {
        println(row?.size)
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