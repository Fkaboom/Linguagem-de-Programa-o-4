package br.com.fundatec.fundatecheroesti21.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheroesti21.databinding.ActivitySplashBinding
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.login.presentation.model.SplashViewModel
import br.com.fundatec.fundatecheroesti21.splashScreen.SplashSreenViewState

class SplashActivity : AppCompatActivity() {


private lateinit var binding: ActivitySplashBinding
private val viewModel: SplashViewModel by viewModels();
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initializeObserver()
        supportActionBar?.hide()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private fun initializeObserver(){
        viewModel.state.observe(this){
                viewState ->
            when (viewState) {
                SplashSreenViewState.loadLogin -> showLogin();
                SplashSreenViewState.sucess -> showSucess();
            }
        }
}

    private fun showSucess() {

    }

    private fun showLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
    }


