package dan.jetpack.section9_paginglv4.data

import com.google.gson.annotations.SerializedName

data class Items (
    @SerializedName("id") val id : Long,
    @SerializedName("name") val name : String,
    @SerializedName("html_url") val url : String,
)