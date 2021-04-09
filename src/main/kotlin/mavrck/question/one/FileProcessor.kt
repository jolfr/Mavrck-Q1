package mavrck.question.one

import java.io.* // Fix this lazy import
import java.io.FileNotFoundException
import java.lang.IllegalArgumentException
/**
 * This class parses the CSV row by row to allow aggregations of the data.
 * @param filepath absolute path of CSV file to process
 * @param aggFunc aggregation function to act on CSV file
 */
class FileProcessor(val filepath: String, val aggFunc: (cells: Array<List<String>?>) -> Unit) {

    /**
     * Iterate through rows, applying aggregation function for each row
     * NOTE: could pass in agg function here to allow multiple aggregations
     */
    fun iterateRows() {
        var csvReader: BufferedReader? // initialize empty var outside try block for proper scope
        try {
            csvReader = BufferedReader(FileReader(filepath));
        } catch (exception: FileNotFoundException) {
            throw IllegalArgumentException(exception.message);
        } 
        var line: String? = null
        while ({ line = csvReader.readLine(); line }() != null) { // I have a vague understanding of why {} works in this instance, some clarification would be appreciated
            var cells = arrayOf(line?.split(",")); // Parses comma seperated values in row
            aggFunc(cells); // 
        }
    }
}