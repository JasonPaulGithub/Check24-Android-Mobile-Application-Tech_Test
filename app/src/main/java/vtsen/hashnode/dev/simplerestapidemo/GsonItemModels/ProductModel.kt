package vtsen.hashnode.dev.simplerestapidemo.GsonItemModels

import com.google.gson.annotations.SerializedName


data class ProductModel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("color") var color: String? = null,
    @SerializedName("imageURL") var imageURL: String? = null,
    @SerializedName("colorCode") var colorCode: String? = null,
    @SerializedName("available") var available: Boolean? = null,
    @SerializedName("releaseDate") var releaseDate: Int? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("longDescription") var longDescription: String? = null,
    @SerializedName("rating") var rating: Double? = null,
    @SerializedName("price") var priceModel: PriceModel? = PriceModel()
)