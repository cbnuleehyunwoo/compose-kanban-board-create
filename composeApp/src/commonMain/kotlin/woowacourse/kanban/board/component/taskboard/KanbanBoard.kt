package woowacourse.kanban.board.component.taskboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.TaskState

@Composable
fun KanbanBoard() {
    KanbanBoardContent(
        state = KanbanBoardState(),
        modifier = Modifier,
        colorsProvider = { KanbanBoardDefaultColor.stateColors(it) }
    )
}

@Composable
fun KanbanBoardContent(
    state: KanbanBoardState,
    modifier: Modifier = Modifier,
    colorsProvider: (TaskState) -> KanbanStateColors = { KanbanBoardDefaultColor.stateColors(it) }
) {

    val snackbarState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val assignees = remember {
        mutableStateListOf(
            Assignee("커비"),
            Assignee("바드"),
            Assignee("아오"),
        )
    }
    Box(modifier = modifier) {
        if (state.showDialog) {
            KanbanBoardDialog(
                assignees = assignees,
                modalState = state.modalState,
                onClickCancel = { state.showDialog = false },
                onClickConfirm = {
                    state.addTask(it)
                    state.showDialog = false
                    scope.launch {
                        snackbarState.showSnackbar(
                            message = "${it.title} 태스크가 생성되었습니다.",
                            duration = SnackbarDuration.Short,
                        )
                    }
                    state.modalState.clear()
                },
            )
        }
        Column(modifier = Modifier) {
            KanbanTaskBoardHeader(
                onClick = { state.showDialog = state.showDialog.not() },
                doneTaskCount = state.doneTaskCount,
                totalTaskCount = state.totalTaskCount,
                taskCompletion = state.taskCompletion,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .background(color = Color(0xFFF9FAFB))
                    .padding(24.dp),
            ) {
                TaskState.entries.forEach { taskState ->
                    val tasks = state.taskGroup[taskState] ?: emptyList()
                    val colors = colorsProvider(taskState)

                    KanbanCardHolder(
                        tasks = tasks,
                        state = taskState,
                        holderColor = colors,
                    )

                }
            }
        }
        SnackbarHost(
            hostState = snackbarState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
        )
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
