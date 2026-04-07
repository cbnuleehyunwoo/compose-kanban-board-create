package woowacourse.kanban.board.component.taskboard

import androidx.compose.ui.graphics.Color
import woowacourse.kanban.board.model.TaskState

data class KanbanStateColors(
    val headerContainer: Color,
    val contentContainer: Color,
    val contentBorder: Color,
)


object KanbanBoardDefaultColor {
    fun stateColors(state: TaskState): KanbanStateColors {
        return when (state) {
            TaskState.TODO -> KanbanStateColors(
                headerContainer = Color(0xFF155DFC),
                contentContainer = Color(0xFFEFF6FF),
                contentBorder = Color(0xFFBEDBFF)
            )
            TaskState.IN_PROGRESS -> KanbanStateColors(
                headerContainer = Color(0xFFE17100),
                contentContainer = Color(0xFFFFFBEB),
                contentBorder = Color(0xFFFEE685)
            )
            TaskState.DONE -> KanbanStateColors(
                headerContainer = Color(0xFF00A63E),
                contentContainer = Color(0xFFF0FDF4),
                contentBorder = Color(0xFFB9F8CF)
            )
        }
    }
}
