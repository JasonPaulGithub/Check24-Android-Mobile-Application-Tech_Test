package vtsen.hashnode.dev.simplerestapidemo.GsonItemData

import com.google.gson.annotations.SerializedName

data class Products (
	@SerializedName("name") val name : String,
	@SerializedName("type") val type : String,
	@SerializedName("id") val id : Int,
	@SerializedName("color") val color : String,
	@SerializedName("imageURL") val imageURL : String,
	@SerializedName("colorCode") val colorCode : String,
	@SerializedName("available") val available : Boolean,
	@SerializedName("releaseDate") val releaseDate : Int,
	@SerializedName("description") val description : String,
	@SerializedName("longDescription") val longDescription : String,
	@SerializedName("rating") val rating : Double,
	@SerializedName("price") val price : Price
)