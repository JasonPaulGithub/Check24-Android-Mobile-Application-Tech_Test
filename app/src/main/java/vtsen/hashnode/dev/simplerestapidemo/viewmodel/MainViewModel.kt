package vtsen.hashnode.dev.simplerestapidemo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vtsen.hashnode.dev.simplerestapidemo.GsonItemData.ItemCategory
import vtsen.hashnode.dev.simplerestapidemo.GsonItemData.asItemCategories
import vtsen.hashnode.dev.simplerestapidemo.R
import vtsen.hashnode.dev.simplerestapidemo.GsonMealData.MealCategory
import vtsen.hashnode.dev.simplerestapidemo.GsonMealData.asMealCategories
import vtsen.hashnode.dev.simplerestapidemo.repository.MainRepository
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson.RetrofitGsonItemsWebService
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitgson.RetrofitGsonMealsWebService
import kotlin.system.measureTimeMillis

class MainViewModel : ViewModel() {

    var itemCategories: List<ItemCategory>? by mutableStateOf(null)
        private set

    var itemsCategoryTitleStrId: Int? by mutableStateOf(null)
        private set

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
        RetrofitGsonItemsWebService(),
    )

    fun updateItemCategories() = viewModelScope.launch {

        println("Hello World!")

        // Print API response here.



        ////

        val time = measureTimeMillis {
            clear()
            itemsCategoryTitleStrId = R.string.retrofit_item

            val response = repository.getRetrofitGsonItemCategories(enablePerformanceTest)
            itemCategories = response.asItemCategories()
        }

        apiLoadingTime = time.toString()
    }

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
}