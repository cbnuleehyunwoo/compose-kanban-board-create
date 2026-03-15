package woowacourse.kanban.board.model

enum class TaskState(val stateName: String) {
    IN_PROGRESS("In Progress"),
    TODO("To Do"),
    DONE("Done");

    companion object {
        fun getStateNames() = entries.map { it.stateName }
    }
}
