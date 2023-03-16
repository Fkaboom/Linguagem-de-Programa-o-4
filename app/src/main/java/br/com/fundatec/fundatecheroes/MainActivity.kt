package br.com.fundatec.fundatecheroes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.et_name)
        val btOk = findViewById<Button>(R.id.botaoOk)
        val btClear = findViewById<Button>(R.id.botaoLimpar)
        val tvHello = findViewById<TextView>(R.id.tv_hello)

        btOk.setOnClickListener{
            tvHello.text = getString(R.string.hello,etName.text)
            tvHello.visibility = View.VISIBLE
        }
        btClear.setOnClickListener{

            tvHello.visibility = View.GONE
            etName.text.clear();
        }
    }


    }
