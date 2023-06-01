package br.com.fundatec.fundatecheroesti21.character.domain

import androidx.recyclerview.widget.RecyclerView

import br.com.fundatec.fundatecheroesti21.character.view.CharacterModel
import br.com.fundatec.fundatecheroesti21.databinding.CharacterListItemBinding

class CharacterViewHolder(private val binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        binding.tvName.text = character.name
    }

}