package com.sato.printdemo.modules.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sato.printdemo.R

class FormActivity : AppCompatActivity(), FormConstructor.FormSetView {

    private lateinit var presenter: FormConstructor.FormSetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        presenter = FormPresenter(this)
        presenter.getInfo()

    }
}
