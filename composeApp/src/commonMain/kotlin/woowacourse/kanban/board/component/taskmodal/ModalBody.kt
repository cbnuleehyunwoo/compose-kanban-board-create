package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.TagError
import woowacourse.kanban.board.model.TaskState
import woowacourse.kanban.board.model.TitleError

@Composable
fun ModalBody(
    state: ModalCreateFormState,
    assignees: List<Assignee>,
    modifier: Modifier = Modifier,
) {
    val tagSupportMessage = when(state.tagError) {
        TagError.TAG_FORM_INVALID -> "태그 형식이 올바르지 않습니다."
        TagError.TAG_OVER_N -> "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
        null -> "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."
    }

    val titleSupportMessage = when(state.titleError) {
        TitleError.TITLE_FORM_INVALID -> "제목을 입력해주세요"
        null -> ""
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ModalBodyInput(
            title = "제목",
            essential = true,
            placeHolder = "태스크 제목을 입력하세요",
            maxLines = 1,
            supportingText = titleSupportMessage,
            onValueChange = {
                state.title = it
                state.updateTitleValidation()
            },
            isValid = state.titleError == null,
            state = state.title,
        )

        ModalBodyInput(
            title = "설명",
            essential = false,
            placeHolder = "태스크에 대한 자세한 설명을 입력하세요",
            maxLines = 5,
            supportingText = "",
            state = state.content,
            isValid = true,
            onValueChange = {
                state.content = it
            },
        )
        ModalBodyInput(
            title = "태그",
            essential = false,
            placeHolder = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
            maxLines = 1,
            supportingText = tagSupportMessage,
            state = state.tag,
            isValid = state.tagError == null,
            onValueChange = {
                state.tag = it
                state.updateTagValidation()
            },
        )

        ModalBodySelector(
            title = "상태",
            essential = true,
            items = TaskState.getStateNames(),
            content = @Composable { name, id ->
                ModalOptionButton(
                    onClick = { state.status = id },
                    isSelected = state.status == id,
                    selectedContainerColor = Color(0xFFEFF6FF),
                    selectedBorderColor = Color(0xFF1447E6),
                    modifier = Modifier.height(52.dp),
                    content = {
                        ModalOptionStatus(
                            text = name,
                            modifier = Modifier,
                        )
                    },
                )
            },
        )

        ModalBodySelector(
            title = "담당자",
            essential = true,
            items = assignees.map { it.name },
            content = @Composable { name, id ->
                ModalOptionButton(
                    isSelected = state.assignee == id,
                    selectedBorderColor = Color(0xFF615FFF),
                    selectedContainerColor = Color(0xFFEFF6FF),
                    modifier = Modifier.height(68.dp),
                    onClick = {
                        state.assignee = id
                    },
                    content = {
                        ModalOptionAssignee(
                            name = name,
                            modifier = Modifier,
                        )
                    },
                )
            },
        )

        ModalAction(
            enabled = state.isValidContents,
            onClick = {},
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 672,
    heightDp = 820,
)
@Composable
private fun ModalBodyPreview() {
    val state = remember { ModalCreateFormState() }

    val assignees = listOf(
        Assignee("커비"),
        Assignee("바드"),
        Assignee("아오"),
        Assignee("하로"),
    )
    ModalBody(
        state = state,
        assignees = assignees,
    )
}
