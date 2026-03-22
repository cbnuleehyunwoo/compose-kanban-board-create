package woowacourse.kanban.board.component.taskmodal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.model.TagError
import woowacourse.kanban.board.model.TitleError

class ModalCreateFormState {
    var title by mutableStateOf(value = "")
    var content by mutableStateOf(value = "")
    var tag by mutableStateOf(value = "")
    val tags: List<String>
        get() = parseTags()
    var status by mutableIntStateOf(value = 0)
    var assignee by mutableIntStateOf(value = 0)

    val isValidContents: Boolean
        get() = (titleError == null) &&
                (tagError == null)

    var titleError: TitleError? by mutableStateOf(TitleError.TITLE_FORM_INVALID)
    var tagError: TagError? by mutableStateOf(null)


    fun updateTitleValidation() {
        titleError = if (title.isNotBlank()) null
        else TitleError.TITLE_FORM_INVALID
    }

    fun updateTagValidation() {
        val tags = parseTags()
        tagError = when {
            tag.isEmpty() -> null
            tags.any { it.isBlank() } -> TagError.TAG_FORM_INVALID
            tags.size > 5 || tags.any { it.length > 5 } -> TagError.TAG_OVER_N
            else -> null
        }
    }

    private fun parseTags(): List<String> =
        tag.split(",")
            .map { it.trim() }
}
