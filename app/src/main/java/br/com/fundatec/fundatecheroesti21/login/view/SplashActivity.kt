package br.com.fundatec.fundatecheroesti21.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivitySplashBinding
import br.com.fundatec.fundatecheroesti21.splash.presentation.SplashViewModel
import br.com.fundatec.fundatecheroesti21.splashScreen.SplashScreenViewState
import com.google.android.material.snackbar.Snackbar

class SplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initializeObserver()
        supportActionBar?.hide()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                SplashScreenViewState.ShowLogin -> showLogin()
                SplashScreenViewState.ShowHome -> showHome()
            }
        }
    }

    private fun showHome() {
        Snackbar.make(binding.root, R.string.sucess, Snackbar.LENGTH_LONG).show()
    }

    private fun showLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}


