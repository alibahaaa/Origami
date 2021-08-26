package ali.baha.origami.uikit

import ali.baha.origami.uikit.theme.B_Yek
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextView(text: String) {
    Text(
        modifier = Modifier.padding(end = 12.dp, start = 12.dp),
        text = text,
        style = TextStyle(fontFamily = B_Yek, fontSize = 18.sp)
    )
}

@Composable
fun BigTextView(text: String) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Text(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            text = text,
            style = TextStyle(fontFamily = B_Yek, fontSize = 18.sp, lineHeight = 25.sp)
        )
    }
}