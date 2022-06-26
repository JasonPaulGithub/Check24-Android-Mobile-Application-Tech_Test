package vtsen.hashnode.dev.simplerestapidemo.GsonItemModels

import com.google.gson.annotations.SerializedName


data class HeaderModel(
    @SerializedName("headerTitle") var headerTitle: String? = null,
    @SerializedName("headerDescription") var headerDescription: String? = null
)