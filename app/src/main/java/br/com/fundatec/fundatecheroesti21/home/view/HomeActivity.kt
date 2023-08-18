package br.com.fundatec.fundatecheroesti21.home.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import br.com.fundatec.fundatecheroesti21.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroesti21.login.view.CharacterActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateNewCharacter()
    }


    private fun navigateNewCharacter() {
        binding.casa.setOnClickListener {
            val intent = Intent(this@HomeActivity, CharacterActivity::class.java)
            startActivity(intent)
        }
    }
}