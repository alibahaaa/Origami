package ali.baha.origami.menu

import ali.baha.origami.uikit.BigTextView
import ali.baha.origami.uikit.TopBarType
import ali.baha.origami.uikit.TopBarView
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarView(
                title = "هنر کاغذ و تا",
                topBarType = TopBarType.Menu,
                navController = navController
            )
        },
    ) {
        Column {
            BigTextView(
                text = "در این پروژه از تکنولوژی های زیر استفاده شده است  :\n" +
                        "\n" +
                        "- رتروفیت\n" +
                        "- روم\n" +
                        "- هیلت\n" +
                        "- کوروتین\n" +
                        "- فلو\n" +
                        "- ویو مدل\n" +
                        "- نویگیشن\n" +
                        "- ریپازیتوری پترن\n" +
                        "- معماری کلین\n" +
                        "- جت پک کامپوز"
            )
        }

    }
}