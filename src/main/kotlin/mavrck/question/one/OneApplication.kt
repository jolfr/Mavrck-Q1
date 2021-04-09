package mavrck.question.one

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


val PATHNAME= "/home/jolfr/Projects/Mavrck-Q1/src/main/resources/CrunchBase-Companies-2017-09-05.csv"
@SpringBootApplication
class OneApplication

fun main(args: Array<String>) {
	runApplication<OneApplication>(*args)
}
/**
 * Endpoint to run groupby and count
 */
class GroupByCountResource {
    val aggregate: AggregationFunctions = AggregationFunctions(1) // Initialize aggregation object with number of columns to aggregate over
    val groupByCount = aggregate.GroupByCountFactory() // Call factory method to get GroupBy and Count
    val processor: FileProcessor = FileProcessor(PATHNAME, groupByCount) // Initialize file processor object with specific aggregation function

    processor.iterateRows() // Where the magic happens
}

@RestController
class MessageResource {
    @GetMapping
    fun index(): List<Message> = listOf(
        Message("1", "Hello!"),
        Message("2", "Bonjour!"),
        Message("3", "Privet!"),
    )
}

data class Message(val id: String?, val text: String)