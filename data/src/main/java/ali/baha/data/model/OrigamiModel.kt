package ali.baha.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class OrigamiRemoteModel {
    @SerializedName("data")
    val origamiModelDataModel: ArrayList<OrigamiDataModel> = ArrayList()
}

@Entity(tableName = "origami_table")
data class OrigamiDataModel(
    @PrimaryKey @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("image") val image: String = "",
    @SerializedName("description") val description: String = "",
)