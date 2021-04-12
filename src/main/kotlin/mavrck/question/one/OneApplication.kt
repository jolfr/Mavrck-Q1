package mavrck.question.one

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import kotlin.reflect.*
import kotlin.collections.*


val PATHNAME= "/home/jolfr/Projects/Mavrck-Q1/src/main/resources/CrunchBase-Companies-2017-09-05.csv"
@SpringBootApplication
class OneApplication

fun main(args: Array<String>) {
	runApplication<OneApplication>(*args)
}
/**
 * Endpoint to run aggregation functions
 */
@RestController
class AggResources {
    
    /**
     * Endpoint for groupby and count
     * @param columns array of column numbers to aggregate over
     * @return formatted response back to user
     */
    @GetMapping("/groupby/count")
    fun GroupByCountResource(@RequestParam(value="columns") columns: Array<Int>): List<Any> {
        val colsOfInterest = columns.toSet()
        val controller = GroupByCountController(PATHNAME, colsOfInterest)
        controller.executeAggregation()
        val result = controller.getResult()
        return formatResponse(result)
    }

    /**
     * Helper function to format the response data in the specified form
     * @param aggEntries aggregation entries fetched by getResult
     * @return 2D list conforming to response spec
     */
    fun formatResponse(aggEntries: MutableMap<List<String>, Int>): List<List<String>> {
        var response: MutableList<List<String>> = mutableListOf()
        var entry: MutableList<String> 
        for((k, v) in aggEntries) {
            entry = k.toMutableList()
            entry.add(v.toString())
            response.add(entry)
        }
        return response
    }

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