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
 * Endpoint to run groupby and count
 */
@RestController
class AggResources {
    
    @GetMapping("/groupby/count")
    fun GroupByCountResource(@RequestParam(value="columns") columns: Array<Int>): List<Any> {
        val colsOfInterest = columns.toSet()
        val controller = GroupByCountController(PATHNAME, colsOfInterest)
        controller.executeAggregation()
        val result = controller.getResult().toMap().flatMap { (key, values) -> key.plus(listOf(values)) }
        return result
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