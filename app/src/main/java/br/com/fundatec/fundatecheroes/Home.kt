package br.com.fundatec.fundatecheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        val etName = findViewById<EditText>(R.id.et_name)
        val btOk = findViewById<Button>(R.id.okay_button)
        val btClear = findViewById<Button>(R.id.clean_button)
        val tvHello = findViewById<TextView>(R.id.tv_hello)

        btOk.setOnClickListener{
            tvHello.text = getString(R.string.ola,etName.text)
            tvHello.visibility = View.VISIBLE
        }
        btClear.setOnClickListener{

            tvHello.visibility = View.GONE
            etName.text.clear();
        }

    }

}
