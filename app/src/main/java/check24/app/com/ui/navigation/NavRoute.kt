package check24.app.com.ui.navigation

sealed class NavRoute(val path: String) {

    object Home: NavRoute("home")

    object ItemCategories: NavRoute("itemcategories")

    object ItemScreen: NavRoute("itemscreen")

}