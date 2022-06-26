package vtsen.hashnode.dev.simplerestapidemo.ui.navigation

sealed class NavRoute(val path: String) {

    object Home: NavRoute("home")

    object ItemCategories: NavRoute("mealcategories")
    
}