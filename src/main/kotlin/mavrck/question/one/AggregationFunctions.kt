package mavrck.question.one

import kotlin.reflect.*

/**
 * Contains factories to construct various aggregation functions
 * @param columns number of columns to perform aggregation on
 */
class AggregationFunctions(val columns: Int) {

    /**
     * Constructs function to run groupby and count on row iterations
     * @return function that performs gorupby and count, returning result
     */
    fun GroupByCountFactory():KFunction<Any>{
        if (columns < 1) throw IllegalArgumentException("Column count must be greater than 0") // This is sloppy, need to check arguments at object init

        fun groupByCount():Int {
            return 1
        }
        return ::groupByCount
    }
}