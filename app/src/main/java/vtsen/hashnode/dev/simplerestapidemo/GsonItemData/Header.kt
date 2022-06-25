package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName

data class Header (
	@SerializedName("headerTitle") val headerTitle : String,
	@SerializedName("headerDescription") val headerDescription : String
)