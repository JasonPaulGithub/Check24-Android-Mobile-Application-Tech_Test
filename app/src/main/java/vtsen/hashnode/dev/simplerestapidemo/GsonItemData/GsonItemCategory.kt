package vtsen.hashnode.dev.simplerestapidemo.GsonItemItem

import com.google.gson.annotations.SerializedName
import vtsen.hashnode.dev.simplerestapidemo.GsonItemData.ItemCategory

data class GsonItemCategory(
    @SerializedName("idCategory") val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

fun GsonItemCategory.asItemCategory(): ItemCategory {
    return ItemCategory (
        id = idCategory,
        name = strCategory,
        description = strCategoryDescription,
        imageUrl = strCategoryThumb,
    )
}