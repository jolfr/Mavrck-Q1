package mavrck.question.one

import java.io.* // Fix this lazy import
import java.io.FileNotFoundException
import java.lang.IllegalArgumentException
import kotlin.reflect.*
import kotlin.collections.*
/**
 * This class parses the CSV row by row to allow aggregations of the data.
 * @param filepath absolute path of CSV file to process
 */
class FileProcessor(val filepath: String) {
    var csvReader: BufferedReader
    var columns: List<String>?
    /* Initializes CSV reader */
    init {
        try {
            csvReader = BufferedReader(FileReader(filepath));
            columns = csvReader.readLine().split(",")
        } catch (exception: FileNotFoundException) {
            throw IllegalArgumentException(exception.message); 
        } 
    }

    /**
     * Iterate through rows, applying aggregation function for each row
     * @param aggFunc aggregation function to act on CSV file
     */
    fun iterateRows(function: AggFunc) {
        var line: String? = null
        while ({ line = csvReader.readLine(); line }() != null) { // I have a vague understanding of why {} works in this instance, some clarification would be appreciated
            val pattern = "\\,(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)".toRegex() // https://stackoverflow.com/questions/46284336/ignore-comma-between-double-quotes-while-reading-csv-file/46331228
            var cells:List<String>? = pattern.split(line!!); // Parses comma seperated values in row
            function.processRow(cells)
        }
    }
}