package vtsen.hashnode.dev.simplerestapidemo.viewmodel

import SimpleJSONModel
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import vtsen.hashnode.dev.simplerestapidemo.GsonMealData.MealCategory
import vtsen.hashnode.dev.simplerestapidemo.GsonMealData.asMealCategories
import vtsen.hashnode.dev.simplerestapidemo.R
import vtsen.hashnode.dev.simplerestapidemo.repository.MainRepository
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson.RetrofitGsonMealsWebService
import kotlin.system.measureTimeMillis

class MainViewModel : ViewModel() {

    var mealCategories: List<MealCategory>? by mutableStateOf(null)
        private set

    var mealsCategoryTitleStrId: Int? by mutableStateOf(null)
        private set

    var apiLoadingTime: String? by mutableStateOf(null)
        private set

    var enablePerformanceTest: Boolean by mutableStateOf(false)
        private set

    private val repository = MainRepository(
        RetrofitGsonMealsWebService(),
    )

    fun updateMealCategoriesWithRetrofitGson() = viewModelScope.launch {

        val time = measureTimeMillis {
            clear()
            mealsCategoryTitleStrId = R.string.retrofit_gson

            val response = repository.getRetrofitGsonMealCategories(enablePerformanceTest)
            mealCategories = response.asMealCategories()
        }

        apiLoadingTime = time.toString()
    }

    private fun clear() {
        apiLoadingTime = null
        mealCategories = null
    }

    fun updateItemCategories() {

        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create Service
        val service = retrofit.create(APIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.getEmployees()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val items = response.body()
                    println(items)

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}

interface APIService {
    @GET("?name=meelad")
    suspend fun getEmployees(): Response<SimpleJSONModel>
}