package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName


data class Header(

    @SerializedName("headerTitle") var headerTitle: String? = null,
    @SerializedName("headerDescription") var headerDescription: String? = null

)