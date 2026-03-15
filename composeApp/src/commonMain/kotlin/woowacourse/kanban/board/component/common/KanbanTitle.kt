package woowacourse.kanban.board.component.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun KanbanTitle(
    title: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Bold,
    fontColor: Color = Color.Black,
    maxLines: Int = 1,
) {
    Text(
        text = title,
        modifier = modifier,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = fontColor,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
    )
}
