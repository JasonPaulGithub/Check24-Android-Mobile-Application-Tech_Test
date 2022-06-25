package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName


data class NestedJSONModel(

    @SerializedName("header") var header: Header? = Header(),
    @SerializedName("filters") var filters: ArrayList<String> = arrayListOf(),
    @SerializedName("products") var products: ArrayList<Products> = arrayListOf()

)