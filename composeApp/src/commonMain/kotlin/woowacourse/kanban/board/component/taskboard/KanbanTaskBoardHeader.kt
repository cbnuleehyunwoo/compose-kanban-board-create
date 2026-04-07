package woowacourse.kanban.board.component.taskboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.component.taskcard.KanbanCardForm
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.TaskState

@Composable
fun KanbanTaskBoardHeader(
    totalTaskCount: Int,
    doneTaskCount: Int,
    taskCompletion: Float,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .height(113.dp)
            .fillMaxWidth(),

        ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Compose Desktop 칸반 보드",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Button(
                    shape = RoundedCornerShape(size = 10.dp),
                    onClick = { onClick() },
                    colors = ButtonColors(
                        containerColor = Color(0xFF4F39F6),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.White,
                    ),
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "새 태스크 생성 버튼",
                    )
                    Text(text = "새 태스크 생성")
                }
            }

            Text(
                text = "완료율: ${(taskCompletion * 100).toInt()}% ($doneTaskCount/$totalTaskCount)",
                fontSize = 14.sp,
                color = Color.Gray,
            )

        }
        LinearProgressIndicator(
            progress = { taskCompletion },
            color = Color(0xFF4F39F6),
            trackColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 1300,
    heightDp = 130,
)
@Composable
fun KanbanTaskBoardHeaderPreview() {
    val totalTaskCount = 4
    val doneTaskCount = 2
    val taskCompletion: Float = if (totalTaskCount == 0) 0f
    else (doneTaskCount.toFloat() / totalTaskCount)
        KanbanTaskBoardHeader(
        onClick = {},
        totalTaskCount = totalTaskCount,
        doneTaskCount = doneTaskCount,
        taskCompletion = taskCompletion,
    )
}
