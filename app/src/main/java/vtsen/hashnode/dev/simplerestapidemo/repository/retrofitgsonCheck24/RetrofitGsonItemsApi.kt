package vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson

import retrofit2.http.GET
import vtsen.hashnode.dev.simplerestapidemo.GsonItemData.GsonItemCategoriesResponse

interface RetrofitGsonItemsApi {
    @GET("categories.php")
    suspend fun getItemCategories(): GsonItemCategoriesResponse
}