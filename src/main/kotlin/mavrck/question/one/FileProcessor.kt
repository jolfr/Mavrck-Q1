package mavrck.question.one

import java.io.* // Fix this lazy import
import java.io.FileNotFoundException
import java.lang.IllegalArgumentException
import kotlin.reflect.*
/**
 * This class parses the CSV row by row to allow aggregations of the data.
 * @param filepath absolute path of CSV file to process
 */
class FileProcessor(val filepath: String) {
    var csvReader: BufferedReader
    var columns: Array<List<String>?>
    var line: String? = null
    /* Initializes CSV reader */
    init {
        try {
            csvReader = BufferedReader(FileReader(filepath));
            columns = arrayOf(csvReader.readLine().split(","))
        } catch (exception: FileNotFoundException) {
            throw IllegalArgumentException(exception.message); 
        } 
    }

    /**
     * Iterate through rows, applying aggregation function for each row
     * @param aggFunc aggregation function to act on CSV file
     */
    fun iterateRows(function: AggFunc) {
        while ({ line = csvReader.readLine(); line }() != null) { // I have a vague understanding of why {} works in this instance, some clarification would be appreciated
            var cells = arrayOf(line?.split(",")); // Parses comma seperated values in row
            function.processRow(cells)
        }
    }
}