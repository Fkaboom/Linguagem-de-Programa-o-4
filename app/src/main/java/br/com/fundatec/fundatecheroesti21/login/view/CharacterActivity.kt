package br.com.fundatec.fundatecheroesti21.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.fundatec.fundatecheroesti21.databinding.ActivityCharacterBinding
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity

class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterBinding

    private val empresa = arrayOf("Marvel", "DC")
    private val categoria = arrayOf("Herói", "Vilão")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val empresaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, empresa)
        empresaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.empresa.adapter = empresaAdapter

        val categoriaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categoria)
        categoriaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.category.adapter = categoriaAdapter

        binding.category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoriaSelecionada = categoria[position]
                Toast.makeText(
                    this@CharacterActivity,
                    categoriaSelecionada,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Nada selecionado
            }
        }

        binding.empresa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val empresaSelecionada = empresa[position]
                Toast.makeText(
                    this@CharacterActivity,
                    empresaSelecionada,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Nada selecionado
            }
        }

        binding.next.setOnClickListener {
            val intent = Intent(this@CharacterActivity, HomeActivity::class.java)

            startActivity(intent)
            finish();
        }
    }
}