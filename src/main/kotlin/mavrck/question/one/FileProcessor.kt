package mavrck.question.one

import java.io.* // Fix this lazy import
/**
 * This class parses the CSV row by row to allow aggregations of the data.
 * @param filepath absolute path of CSV file to process
 * @param aggFunc aggregation function to act on CSV file
 */
class FileProcessor(val filepath: String, val aggFunc: () -> Unit) {

}