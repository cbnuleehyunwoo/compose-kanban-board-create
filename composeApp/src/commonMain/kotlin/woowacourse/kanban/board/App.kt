package woowacourse.kanban.board

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.component.taskboard.KanbanBoard
import woowacourse.kanban.board.component.taskmodal.ModalCreateForm

@Composable
@Preview(
    showBackground = true,
    widthDp = 1300,
    heightDp = 910,
)
fun App() {
    MaterialTheme {
        KanbanBoard()
    }
}
