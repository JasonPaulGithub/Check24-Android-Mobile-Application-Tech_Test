package check24.app.com.ui.navigation

sealed class NavRoute(val path: String) {

    object Home: NavRoute("home")

    object ItemCategories: NavRoute("mealcategories")

    object ItemScreen: NavRoute("itemscreen")

}