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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KanbanTaskBoardHeader(
    completion: Float,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
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
                text = "완료율: ${(completion * 100).toInt()}%",
                fontSize = 14.sp,
                color = Color.LightGray,
            )

        }
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            progress = { 0.5f },
            color = Color(0xFF4F39F6),
            trackColor = Color.White,
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
    KanbanTaskBoardHeader(
        completion = 0.5f,
        onClick = {},
    )
}
