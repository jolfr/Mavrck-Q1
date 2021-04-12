package mavrck.question.one

import kotlin.reflect.*
import kotlin.collections.MutableMap
import kotlin.collections.MutableMap.MutableEntry

interface AggFunc {
    val columns: Set<Int>
    fun processRow(row: Array<List<String>?>): Unit
}

abstract class AggFuncFactory {
    abstract fun getFunction(colsOfInterest: Set<Int>): AggFunc
}