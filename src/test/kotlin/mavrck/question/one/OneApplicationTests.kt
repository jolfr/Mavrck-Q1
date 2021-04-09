package mavrck.question.one

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OneApplicationTests {

	@Test
	fun contextLoads() {
	} 

	@Test
	fun `group by count can be called`() {
		val testObject = GroupByCountResource()
		assertNotNull(testObject)
	}

}
