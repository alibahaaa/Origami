package ali.baha.origami.app.routers

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
    object MenuScreen : Screen("menu_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }
}