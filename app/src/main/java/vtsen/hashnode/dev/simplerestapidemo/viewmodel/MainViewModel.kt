package vtsen.hashnode.dev.simplerestapidemo.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import vtsen.hashnode.dev.simplerestapidemo.GsonItemModels.ResponseModel
import vtsen.hashnode.dev.simplerestapidemo.GsonItemModels.ProductModel

class MainViewModel : ViewModel() {

    var products: List<ProductModel>? by mutableStateOf(null)
        private set

    var mealsCategoryTitleStrId: Int? by mutableStateOf(null)
        private set

    fun callAndParseItemCategories() {
        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://app.check24.de/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create Service
        val service = retrofit.create(APIService::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val response = service.getEmployeesNested()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    products = response.body()?.products
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                }
            }
        }
    }

}

interface APIService {
    @GET("products-test.json?header")
    suspend fun getEmployeesNested(): Response<ResponseModel>
}