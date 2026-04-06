package woowacourse.kanban.board.component.taskboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.component.taskcard.KanbanCardForm
import woowacourse.kanban.board.component.taskmodal.ModalCreateFormState

class KanbanBoardState(
    initialTasks: List<KanbanCardForm> = listOf()
) {
    var showDialog by mutableStateOf(false)
    var taskList by mutableStateOf(initialTasks)
    val modalState = ModalCreateFormState()

    val taskGroup
        get() = taskList.groupBy { it.status }

    fun addTask(task: KanbanCardForm) {
        taskList += task
    }
}


