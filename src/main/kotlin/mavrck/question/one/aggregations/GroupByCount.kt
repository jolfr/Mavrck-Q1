package mavrck.question.one
// classes have to be open for mockito :(
open class GroupByCountFactory(): AggFuncFactory() {
    override fun getFunction() = GroupByCount()
}

open class GroupByCount: AggFunc {
    override fun processRow(row: Array<List<String>?>): Unit {
        println(row.size)
    }
}