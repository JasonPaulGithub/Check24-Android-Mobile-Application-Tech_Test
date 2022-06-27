package check24.app.com.dataModels

import com.google.gson.annotations.SerializedName


data class PriceModel(
    @SerializedName("value") var value: Double? = null,
    @SerializedName("currency") var currency: String? = null
)