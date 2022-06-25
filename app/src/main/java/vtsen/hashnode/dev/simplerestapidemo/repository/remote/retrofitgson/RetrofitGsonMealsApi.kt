package vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson

import retrofit2.http.GET
import vtsen.hashnode.dev.simplerestapidemo.GsonMealData.GsonMealCategoriesResponse

interface RetrofitGsonMealsApi {
    @GET("categories.php")
    suspend fun getMealCategories(): GsonMealCategoriesResponse
}