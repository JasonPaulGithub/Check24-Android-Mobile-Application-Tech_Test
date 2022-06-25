package vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vtsen.hashnode.dev.simplerestapidemo.GsonItemData.GsonItemCategoriesResponse
import vtsen.hashnode.dev.simplerestapidemo.repository.MainRepository

class RetrofitGsonItemsWebService {

    private val api: RetrofitGsonItemsApi by lazy {
        createItemsApi()
    }

    suspend fun getItemCategories(): GsonItemCategoriesResponse {
        return api.getItemCategories()
    }

    private fun createItemsApi(): RetrofitGsonItemsApi {

        val gsonConverterFactory = GsonConverterFactory.create()

        val retrofit = Retrofit.Builder()
            .baseUrl(MainRepository.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()

        return retrofit.create(RetrofitGsonItemsApi::class.java)
    }
}