package br.com.fundatec.fundatecheroesti21.character.data.domain


import br.com.fundatec.fundatecheroesti21.character.data.repository.CharacterRepository
import br.com.fundatec.fundatecheroesti21.character.domain.CharacterModel

class CharacterUseCase {

    private val repository by lazy { CharacterRepository() }

    fun getCharacters(): List<CharacterModel>{
        return repository.getCharacters()
    }
}