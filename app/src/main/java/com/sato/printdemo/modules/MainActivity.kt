package com.sato.printdemo.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sato.printdemo.R
import com.sato.printdemo.modules.form.FormActivity
import com.sato.printdemo.modules.home.HomeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, HomeActivity::class.java)
        //val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
        finish()
    }
}
