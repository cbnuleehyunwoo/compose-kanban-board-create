package woowacourse.kanban.board.component.taskboard

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import woowacourse.kanban.board.component.taskmodal.ModalCreateForm

@Composable
fun KanbanBoardDialog(
    onClickCancel: () -> Unit,
    onClickConfirm: () -> Unit,
) {
    Dialog(onDismissRequest = { onClickCancel() }) {
        Card(
            modifier = Modifier
                .height(818.dp)
                .width(672.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            ModalCreateForm(onClick = { onClickCancel() })
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 1300,
    heightDp = 910,
)
@Composable
fun KanbanBoardDialogPreview() {
    KanbanBoardDialog(
        onClickCancel = { },
        onClickConfirm = { },
    )
}
