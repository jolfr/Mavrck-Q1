package mavrck.question.one

/**
 * Initiates the two objects required to run the GroupBy action and runs, returning the result
 * @param filepath the absolute path to the .csv file to run the aggregation on
 * @param colsOfInterest unordered list of column numbers WARNING not robust to edge cases
 */
class GroupByCountController(filepath: String, colsOfInterest: Set<Int>, ) {
    val processor: FileProcessor
    val factory: GroupByCountFactory
    val function: GroupByCount
    init {
        try {
            processor = FileProcessor(filepath)
            factory = GroupByCountFactory()
            function = factory.getFunction(colsOfInterest)
            
        } catch (e: Exception) {
            throw RuntimeException("controller initialization failed with message: " + e.message)
        }
    }

    /**
     * Wrapper to call iterate rows after initialization
     */
    fun executeAggregation() {
        processor.iterateRows(function)
    }

    /**
     * Call into function object to retrieve result. 
     * @return mapped object with column names as the key and count as the value
     */
    fun getResult(): MutableMap<List<String>, Int> {
        return function.aggEntries
    }
}