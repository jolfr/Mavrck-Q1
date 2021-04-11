package mavrck.question.one

class GroupByCountFactory(): AggFuncFactory() {
    override fun getFunction() = GroupByCount()
}

class GroupByCount: AggFunc {
    override fun processRow(row: Array<List<String>?>): Unit {
        println(row.size)
    }
}