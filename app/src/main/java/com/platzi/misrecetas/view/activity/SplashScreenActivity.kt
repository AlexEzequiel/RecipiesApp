package com.platzi.misrecetas.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.platzi.misrecetas.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val animacion = AnimationUtils.loadAnimation(this,R.anim.animacion)
        tvSplashScreen.startAnimation(animacion)
        val intent = Intent(this, MainActivity::class.java)

        animacion.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }
            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
                finish()
            }
            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }
}