package prueba.tecnica.openbank.data.datasource.api.datamodel.character

import com.google.gson.annotations.SerializedName

data class CharacterDataResponse(
    var data: DataContent
)

data class DataContent(
    var results: List<CharacterResponse>
)

data class CharacterResponse(
    var name: String,
    @SerializedName("resourceURI")
    var uri: String,
    var thumbnail: ThumbnailResponse,
    var description: String
)

data class ThumbnailResponse(
    var path: String,
    var extension: String
)