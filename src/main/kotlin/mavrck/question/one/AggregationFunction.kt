package mavrck.question.one

import kotlin.reflect.*

interface AggFunc {
    fun processRow(row: Array<List<String>?>): Unit
}

abstract class AggFuncFactory {
    abstract fun getFunction(): AggFunc
}