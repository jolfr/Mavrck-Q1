package mavrck.question.one

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.*


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
    //val aggregate: AggregationFunction
    //val groupByCount: KFunction<Any>
    //val processor: FileProcessor

    init {
        //aggregate = AggregationFunctions(1) // Initialize aggregation object with number of columns to aggregate over
        //groupByCount = aggregate.GroupByCountFactory() // Call factory method to get GroupBy and Count
        //processor = FileProcessor(PATHNAME) // Initialize file processor object
    }

    //processor.iterateRows(groupByCount) // MAGIC
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