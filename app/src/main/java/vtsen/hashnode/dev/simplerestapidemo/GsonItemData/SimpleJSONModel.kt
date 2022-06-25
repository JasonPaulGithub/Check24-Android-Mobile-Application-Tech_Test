package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName


data class SimpleJSONModel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("age") var age: Int? = null,
    @SerializedName("count") var count: Int? = null
)