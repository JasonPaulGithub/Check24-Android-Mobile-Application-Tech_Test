package vtsen.hashnode.dev.simplerestapidemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vtsen.hashnode.dev.simplerestapidemo.repository.MainRepository
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitkotlinserdes.RetrofitKotlinSerdesMealsWebService
import vtsen.hashnode.dev.simplerestapidemo.repository.remote.retrofitmoshi.RetrofitMoshiMealsWebService

class MainViewModel(preview: Boolean = false) : ViewModel() {
    private val repository = MainRepository(
        RetrofitMoshiMealsWebService(),
        RetrofitKotlinSerdesMealsWebService()
    )

    init {
        viewModelScope.launch {
            val response = repository.getRetrofitMoshiMealCategories()
            //val response = repository.getRetrofitKotlinSerdesMealCategories()
            Log.d("ViewModelDebug", response.toString())
        }
    }

    fun init() {

    }
}