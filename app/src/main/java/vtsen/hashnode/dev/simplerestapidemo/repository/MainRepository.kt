package vtsen.hashnode.dev.simplerestapidemo.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import vtsen.hashnode.dev.simplerestapidemo.GsonMealData.GsonMealCategoriesResponse
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson.RetrofitGsonMealsWebService

class MainRepository(private val retrofitGsonWebService: RetrofitGsonMealsWebService, )
{

    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

    suspend fun getRetrofitGsonMealCategories(enableTest: Boolean): GsonMealCategoriesResponse =
        withContext(Dispatchers.IO) {

            if (enableTest) {
                repeat(10) {
                    retrofitGsonWebService.getMealCategories()
                }
            }
            return@withContext retrofitGsonWebService.getMealCategories()
        }

}