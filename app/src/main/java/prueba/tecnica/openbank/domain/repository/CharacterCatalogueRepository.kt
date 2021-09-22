package prueba.tecnica.openbank.domain.repository

import prueba.tecnica.openbank.BuildConfig
import prueba.tecnica.openbank.data.datasource.api.datamodel.character.CharacterResponse
import prueba.tecnica.openbank.data.datasource.character.CharacterApi
import prueba.tecnica.openbank.data.datasource.common.RetrofitCommonApiClientGenerator
import prueba.tecnica.openbank.domain.Character
import java.security.MessageDigest

class CharacterCatalogueRepository {

    suspend fun getCatalogue(): List<Character> {
        val publicKey = BuildConfig.MARVEL_API_PUBLIC_KEY
        val privateKey = BuildConfig.MARVEL_API_PRIVATE_KEY
        val api = RetrofitCommonApiClientGenerator().generatedApi(CharacterApi::class.java)
        val ts = System.currentTimeMillis()

        return buildCharacterList(api.getCharacters(
            publicKey,
            ts,
            generateHashKey(ts, privateKey, publicKey)
        ).data.results)
    }

    private fun generateHashKey(ts: Long, privateKey: String, publicKey: String): String {
        val hashKeyDecrypted = "$ts$privateKey$publicKey"
        val md = MessageDigest.getInstance("MD5")
        val digested = md.digest(hashKeyDecrypted.toByteArray())
        return digested.joinToString("") {
            String.format("%02x", it)
        }
    }

    private fun buildCharacterList(results: List<CharacterResponse>) : List<Character>{
        val characterList = mutableListOf<Character>()

        for(characterResult in results){
            val character = Character().apply {
                name = characterResult.name
                uri = "${characterResult.thumbnail.path}.${characterResult.thumbnail.extension}"
                description = characterResult.description
            }
            characterList.add(character)
        }
        return characterList
    }
}