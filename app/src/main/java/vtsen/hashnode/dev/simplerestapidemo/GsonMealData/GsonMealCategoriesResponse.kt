package vtsen.hashnode.dev.simplerestapidemo.GsonMealData

data class GsonMealCategoriesResponse (
    val categories: List<GsonMealCategory>
)

fun GsonMealCategoriesResponse.asMealCategories(): List<MealCategory> {
    return categories.map {
        it.asMealCategory()
    }
}