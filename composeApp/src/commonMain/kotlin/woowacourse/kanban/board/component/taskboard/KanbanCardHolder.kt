package woowacourse.kanban.board.component.taskboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.component.taskcard.KanbanCard
import woowacourse.kanban.board.component.taskcard.KanbanCardForm
import woowacourse.kanban.board.model.TaskState

@Composable
fun KanbanCardHolder(
    tasks: List<KanbanCardForm>,
    modifier: Modifier = Modifier,
    state: TaskState = TaskState.TODO,
) {
    Column(modifier = modifier.width(320.dp))
    {
        Row(
            modifier = modifier
                .width(320.dp)
                .height(48.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                    ),
                )
                .background(color = Color(0xFF155DFC))
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = state.stateName,
                fontSize = 16.sp,
                color = Color.White,
            )

            Text(
                text = "2",
                modifier = Modifier
                    .height(24.dp)
                    .clip(shape = RoundedCornerShape(16777200.dp))
                    .background(Color.White)
                    .padding(horizontal = 10.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF6FF))
                .border(1.dp, Color(0xFFBEDBFF))
                .padding(
                    vertical = 17.dp,
                    horizontal = 16.dp,
                ),
            ) {
            items(tasks) { task ->
                KanbanCard(
                    kanbanCardForm = task
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 800,
)
@Composable
fun KanbanCardHolderPreview() {
    KanbanCardHolder()
}
