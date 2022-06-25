package vtsen.hashnode.dev.simplerestapidemo.GsonMealData

import com.google.gson.annotations.SerializedName

data class GsonMealCategory(
    @SerializedName("idCategory") val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

fun GsonMealCategory.asMealCategory(): MealCategory {
    return MealCategory (
        id = idCategory,
        name = strCategory,
        description = strCategoryDescription,
        imageUrl = strCategoryThumb,
    )
}