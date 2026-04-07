package woowacourse.kanban.board.component.taskboard

import junit.framework.TestCase.assertEquals
import woowacourse.kanban.board.component.taskcard.KanbanCardForm
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.TaskState
import kotlin.test.Test

class KanbanBoardStateTest {

    @Test
    fun `태스크를 추가하면 전체 개수가 증가한다`() {
        val newTask = createTestTask(TaskState.TODO)
        val boardState = KanbanBoardState()

        boardState.addTask(newTask)

        assertEquals(1, boardState.totalTaskCount)
    }

    @Test
    fun `태스크 그룹화가 상태별로 올바르게 이루어진다`() {
        val boardState = KanbanBoardState()
        boardState.addTask(createTestTask(TaskState.TODO))
        boardState.addTask(createTestTask(TaskState.TODO))
        boardState.addTask(createTestTask(TaskState.DONE))

        val groups = boardState.taskGroup

        assertEquals(2, groups[TaskState.TODO]?.size)
        assertEquals(1, groups[TaskState.DONE]?.size)
        assertEquals(null, groups[TaskState.IN_PROGRESS])
    }

    private fun createTestTask(state: TaskState): KanbanCardForm {
        return KanbanCardForm(
            title = "테스트",
            assignee = Assignee("커비"),
            tags = listOf(),
            content = "내용",
            status = state
        )
    }
}
