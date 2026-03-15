package woowacourse.kanban.board.model

import org.jetbrains.compose.resources.DrawableResource

data class Assignee(
    val name: String,
    val profileImage: DrawableResource? = null,
)
