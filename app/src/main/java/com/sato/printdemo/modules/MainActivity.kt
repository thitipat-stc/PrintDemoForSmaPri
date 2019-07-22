package com.sato.printdemo.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sato.printdemo.R
import com.sato.printdemo.modules.form.FormActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val intent = Intent(this, HomeActivity::class.java)
        Handler().postDelayed({
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}