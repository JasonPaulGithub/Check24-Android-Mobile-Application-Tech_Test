package check24.app.com.GsonItemModels

import com.google.gson.annotations.SerializedName


data class PriceModel(
    @SerializedName("value") var value: Double? = null,
    @SerializedName("currency") var currency: String? = null
)