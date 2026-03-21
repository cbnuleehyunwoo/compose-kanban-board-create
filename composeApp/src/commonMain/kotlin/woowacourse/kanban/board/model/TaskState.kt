package woowacourse.kanban.board.model

enum class TaskState(val stateName: String) {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    companion object {
        fun getStateNames() = entries.map { it.stateName }
    }
}
