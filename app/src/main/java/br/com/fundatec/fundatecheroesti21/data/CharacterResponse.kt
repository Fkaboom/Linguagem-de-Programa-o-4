package br.com.fundatec.fundatecheroesti21.character.data


import java.util.Date

@JsonClass(generateAdapter = true)
data class CharacterResponse (
    val id: Int=0,
    val name: String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: String
)

annotation class JsonClass(val generateAdapter: Boolean)
