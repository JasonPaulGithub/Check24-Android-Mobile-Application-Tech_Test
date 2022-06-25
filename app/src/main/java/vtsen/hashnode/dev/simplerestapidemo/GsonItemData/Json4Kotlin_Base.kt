package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base (
	@SerializedName("header") val header : Header,
	@SerializedName("filters") val filters : List<String>,
	@SerializedName("products") val products : List<Products>
)