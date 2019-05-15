package za.co.pabimoloi.parmesan.presentation.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import za.co.pabimoloi.parmesan.presentation.home.Home
import za.co.pabimoloi.parmesan.R


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        stimulateSomeWork()
    }

    private fun stimulateSomeWork() {
        Handler().postDelayed(Runnable {
            startActivity(Intent(this@Splash, Home::class.java))
            finish()
        }, 3000)
    }
}
