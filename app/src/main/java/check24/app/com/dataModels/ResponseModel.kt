package check24.app.com.dataModels

import com.google.gson.annotations.SerializedName


data class ResponseModel(
    @SerializedName("header") var headerModel: HeaderModel? = HeaderModel(),
    @SerializedName("filters") var filters: ArrayList<String> = arrayListOf(),
    @SerializedName("products") var products: ArrayList<ProductModel> = arrayListOf()
)