package prueba.tecnica.openbank.data.datasource.character


import prueba.tecnica.openbank.data.datasource.api.datamodel.character.CharacterDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("ts") timestamp: Long,
        @Query("hash") hash: String
    ): CharacterDataResponse
}