package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import vtsen.hashnode.dev.simplerestapidemo.GsonItemItem.GsonItemCategory
import vtsen.hashnode.dev.simplerestapidemo.GsonItemItem.asItemCategory

data class GsonItemCategoriesResponse (
    val categories: List<GsonItemCategory>
)

fun GsonItemCategoriesResponse.asItemCategories(): List<ItemCategory> {
    return categories.map {
        it.asItemCategory()
    }
}