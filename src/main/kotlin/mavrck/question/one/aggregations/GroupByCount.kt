package mavrck.question.one

import kotlin.collections.MutableMap
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

    override fun processRow(row: Array<List<String>?>): Unit {
        println(row.size)
    }
}