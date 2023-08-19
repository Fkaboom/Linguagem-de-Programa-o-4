package br.com.fundatec.fundatecheroesti21.login.data.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CharacterDao {
    @Insert
    fun insertUser(userEntity: UserEntity)

}