package woowacourse.kanban.board.component.taskmodal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModalCreateFormState {
    var title by mutableStateOf(value = "")
    var content by mutableStateOf(value = "")
    var tag by mutableStateOf(value = "")
    var status by mutableIntStateOf(value = 0)
    var assignee by mutableIntStateOf(value = 0)

    val isValidContents: Boolean
        get() = isValidTitle && isValidTag

    var isValidTitle by mutableStateOf(value = true)

    var isValidTag by mutableStateOf(value = true)

    var errorTagMessage by mutableStateOf(value = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.")


    fun updateTitleValidation() {
        isValidTitle = title.isNotBlank()
    }

    fun updateTagValidation() {
        if (tag.isEmpty()) {
            errorTagMessage = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."
            isValidTag = true
            return
        }

        val tags = parseTags()
        if (tags.any { it.isBlank() }) {
            errorTagMessage = "태그 형식이 올바르지 않습니다."
            isValidTag = false
            return
        }

        if (tags.size > 5) {
            errorTagMessage = "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
            isValidTag = false
            return
        }
        tags.forEach {
            if (it.length > 5) {
                errorTagMessage = "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
                isValidTag = false
                return
            }
        }
        errorTagMessage = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."
        isValidTag = true
        return
    }

    private fun parseTags(): List<String> =
        tag.split(",")
            .map { it.trim() }
}
