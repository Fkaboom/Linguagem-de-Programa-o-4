package br.com.fundatec.fundatecheroesti21.character.data.repository

import android.util.Log
import br.com.fundatec.fundatecheroesti21.character.data.CharacterRequest
import br.com.fundatec.fundatecheroesti21.character.data.CharacterResponse
import br.com.fundatec.fundatecheroesti21.character.domain.CharacterModel
import br.com.fundatec.fundatecheroesti21.database.FHDatabase
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CharacterRepository {

    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    private val client = RetrofitNetworkClient
        .createNetworkClient()
        .create(CharacterService::class.java)

    suspend fun createCharacter(
        characterRequest: CharacterRequest
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.createCharacter(
                    database.userDao().getId() as Int,
                    CharacterRequest(
                        characterRequest.name,
                        characterRequest.description,
                        characterRequest.image,
                        characterRequest.universeType,
                        characterRequest.characterType,
                        characterRequest.age,
                        characterRequest.birthday
                    )
                )
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("createCharacter", exception.message.orEmpty())
                false
            }
        }
    }


    private fun CharacterResponse.characterResponseToModel(): CharacterModel {
        return CharacterModel(
            name = name
        )
    }

    private fun List<CharacterResponse>.convertToModelList(): List<CharacterModel> {
        return map { it.characterResponseToModel() }
    }

    fun getCharacters(): List<CharacterModel> {
        val response: Response<List<CharacterResponse>> =
            client.getCharacter(database.userDao().getId() as Int)

        return if (response.isSuccessful) {
            val characterResponseList: List<CharacterResponse> = response.body() ?: emptyList()
            characterResponseList.convertToModelList()
        } else {
            emptyList()
        }
    }
}
