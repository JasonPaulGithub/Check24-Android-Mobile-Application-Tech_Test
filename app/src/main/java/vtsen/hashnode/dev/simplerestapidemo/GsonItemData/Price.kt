package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName

data class Price (
	@SerializedName("value") val value : Double,
	@SerializedName("currency") val currency : String
)