package vtsen.hashnode.dev.simplerestapidemo.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import vtsen.hashnode.dev.simplerestapidemo.GsonItemData.GsonItemCategoriesResponse
import vtsen.hashnode.dev.simplerestapidemo.GsonMealData.GsonMealCategoriesResponse
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson.RetrofitGsonItemsWebService
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson.RetrofitGsonMealsWebService

class MainRepository(
    private val retrofitGsonWebService: RetrofitGsonMealsWebService,
    private val retrofitGsonItemsWebService: RetrofitGsonItemsWebService,
) {

    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        const val CHECK24_URL = "http://app.check24.de/products-test.json"
    }

    suspend fun getRetrofitGsonMealCategories(enableTest: Boolean): GsonMealCategoriesResponse
            = withContext(Dispatchers.IO) {

        if (enableTest) {
            repeat(10) {
                retrofitGsonWebService.getMealCategories()
            }
        }
        return@withContext retrofitGsonWebService.getMealCategories()
    }

    suspend fun getRetrofitGsonItemCategories(enableTest: Boolean): GsonItemCategoriesResponse
            = withContext(Dispatchers.IO) {

        if (enableTest) {
            repeat(10) {
                retrofitGsonItemsWebService.getItemCategories()
            }
        }
        return@withContext retrofitGsonItemsWebService.getItemCategories()
    }


}