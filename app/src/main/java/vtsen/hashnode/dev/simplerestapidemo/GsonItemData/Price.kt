package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName


data class Price(

    @SerializedName("value") var value: Double? = null,
    @SerializedName("currency") var currency: String? = null

)