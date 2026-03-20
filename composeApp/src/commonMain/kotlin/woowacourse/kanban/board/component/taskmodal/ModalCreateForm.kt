package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import woowacourse.kanban.board.model.Assignee

@Composable
fun ModalCreateForm(
    onClickCancel: () -> Unit,
    onClickConfirm: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = remember { ModalCreateFormState() }

    val assignees = listOf(
        Assignee("커비"),
        Assignee("바드"),
        Assignee("아오"),
        Assignee("하로"),
    )
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        ModalHeader()

        HorizontalDivider(
            thickness = Dp.Hairline,
            color = Color.LightGray,
        )

        ModalBody(
            assignees = assignees,
            state = state,
            modifier = Modifier,
            onClickCancel = TODO(),
            onClickConfirm = TODO(),
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 672,
    heightDp = 1000,
)
@Composable
private fun ModalCreateFormPreview() {
    ModalCreateForm(
        onClickCancel = {},
        onClickConfirm = {},
    )
}
