package woowacourse.kanban.board.component.taskboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.taskcard.KanbanCardForm
import woowacourse.kanban.board.component.taskmodal.ModalCreateFormState
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.TaskState

@Composable
fun KanbanBoard(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    val taskList = remember { mutableStateListOf<KanbanCardForm>() }
    val modalState = remember { ModalCreateFormState() }
    val taskGroup = taskList.groupBy { it.status }

    val assignees = listOf(
        Assignee("커비"),
        Assignee("바드"),
        Assignee("아오"),
    )

    Column(modifier = modifier) {
        Box {
            if (showDialog) {
                KanbanBoardDialog(
                    assignees = assignees,
                    modalState = modalState,
                    onClickCancel = { showDialog = false },
                    onClickConfirm = {
                        taskList.add(it)
                        showDialog = false
                    },
                )
            }
        }
        KanbanTaskBoardHeader(
            onClick = { showDialog = !showDialog },
            completion = 0.5f,
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                )
                .padding(24.dp),
        )
        Row(
            modifier = modifier
                .background(color = Color(0xFFF9FAFB))
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            TaskState.entries.forEach { state ->
                val stateTask = taskGroup[state] ?: emptyList()
                KanbanCardHolder(
                    state = state,
                    tasks = stateTask,
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 1300,
    heightDp = 910,
)
@Composable
fun KanbanBoardPreview() {
    KanbanBoard()
}
