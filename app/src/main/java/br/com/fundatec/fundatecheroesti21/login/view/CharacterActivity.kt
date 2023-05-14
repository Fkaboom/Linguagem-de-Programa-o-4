package br.com.fundatec.fundatecheroesti21.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityCharacterBinding
import br.com.fundatec.fundatecheroesti21.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheroesti21.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.login.presentation.model.CharacterViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewModel

class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()


    var Empresa = arrayOf("Marvel", "DC")
    val Empresa_ID = 1

    var Categoria = arrayOf("Heroi", "Vilão")
    val Categoria_ID = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        binding.category.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@CharacterActivity,
                    getString(Categoria_ID) + " " +
                            "" + Categoria[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.empresa.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@CharacterActivity,
                    getString(Empresa_ID) + " " +
                            "" + Empresa[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.next.setOnClickListener(){
            val intent = Intent(this@CharacterActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }


}
